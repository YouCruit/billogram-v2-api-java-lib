package com.youcruit.billogram.client.http;

import java.io.IOException;
import java.net.Proxy;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.youcruit.billogram.client.BillogramCallback;
import com.youcruit.billogram.exception.ApiException;
import com.youcruit.billogram.objects.response.error.ApiError;
import com.youcruit.billogram.objects.response.error.ErrorData;

public class OkHttpBillogramClient extends AbstractHttpClient {
    public static final Logger LOGGER = LogManager.getLogger(OkHttpBillogramClient.class);

    private final OkHttpClient client;
    private static final MediaType JSON = MediaType.parse("application/json");

    public OkHttpBillogramClient(String username, String password) {
	this(createOkClient(username, password), null, null);
    }

    public OkHttpBillogramClient(String username, String password, String apiUrl) {
	this(createOkClient(username, password), null, apiUrl);
    }

    public OkHttpBillogramClient(String username, String password, boolean sandbox) {
	this(createOkClient(username, password), null, getApiUrl(sandbox));
    }

    private static OkHttpClient createOkClient(String username, String password) {
	OkHttpClient okHttpClient = new OkHttpClient().setAuthenticator(new BasicAuthenticator(username, password));
	okHttpClient.interceptors().add(new UserAgentInterceptor());
	return okHttpClient;
    }

    public OkHttpBillogramClient(OkHttpClient okHttpClient, Gson gson, String apiUrl) {
	super(gson, apiUrl);
	this.client = okHttpClient;
    }

    public <V> void async(URI uri, Object requestBody, HttpClient.Method method, BillogramCallback<V> callback, Class<V> responseClass) {
	final Request request = createRequest(uri, requestBody, method);
	client.newCall(request).enqueue(new CallbackWrapper<V>(callback, responseClass));
    }

    public <V> V sync(URI uri, Object requestBody, HttpClient.Method method, Class<V> responseClass) throws IOException {
	final Request request = createRequest(uri, requestBody, method);
	final Response response = client.newCall(request).execute();
	String responseJson = response.body().string();
	if (LOGGER.isTraceEnabled()) {
	    LOGGER.trace("Response json for " + uri + " : " + responseJson);
	}
	if (response.isSuccessful()) {
	    if (Void.class.getName().equals(responseClass.getName())) {
		return null;
	    }
	    return gson.fromJson(responseJson, responseClass);
	} else {
	    final ApiError error = gson.fromJson(responseJson, ApiError.class);
	    throw new ApiException(error);
	}
    }

    private Request createRequest(URI uri, Object requestBody, HttpClient.Method method) {
	Request.Builder requestBuilder = new Request.Builder().url(uri.toString());
	RequestBody payload = null;
	if (requestBody == null && method == Method.POST) {
	    requestBody = Collections.emptyMap();
	}
	if (requestBody != null) {
	    String requestString = gson.toJson(requestBody);
	    if (LOGGER.isDebugEnabled()) {
		StringBuilder sb = new StringBuilder(method.name()).append(" Request for ").append(uri);
		LOGGER.debug(sb);
		if (LOGGER.isTraceEnabled()) {
		    sb.append(" : ").append(requestBody);
		    LOGGER.trace(sb);
		}
	    }
	    payload = RequestBody.create(JSON, requestString.getBytes(UTF8));
	}
	requestBuilder.method(method.name(), payload);
	return requestBuilder.build();
    }

    private class CallbackWrapper<V> implements Callback {
	private final BillogramCallback<V> callback;
	private final Class<V> clazz;

	private CallbackWrapper(BillogramCallback<V> callback, Class<V> clazz) {
	    this.callback = callback;
	    this.clazz = clazz;
	}

	@Override
	public void onFailure(Request request, IOException e) {
	    callback.onError(e);
	}

	@Override
	public void onResponse(Response response) throws IOException {
	    boolean callbackDone = false;
	    String responseJson = null;
	    try {
		responseJson = response.body().string();
		if (LOGGER.isTraceEnabled()) {
		    LOGGER.trace("Response json for " + response.request().uri() + " (" + response.code() + "): " + responseJson);
		}
		if (response.isSuccessful()) {
		    final V responseObject = gson.fromJson(responseJson, clazz);
		    callbackDone = true;
		    callback.onSuccess(responseObject);
		} else {
		    ApiError error;
		    try {
			error = gson.fromJson(responseJson, ApiError.class);
		    } catch (RuntimeException e) {
			error = new ApiError();
			error.setData(new ErrorData());
			error.getData().setMessage("Unpalatable response from request");
		    }
		    error.setHttpStatusCode(response.code());
		    callbackDone = true;
		    callback.onError(new ApiException(error));
		}
	    } finally {
		if (!callbackDone) {
		    callback.onError(new IOException("Could not parse response " + responseJson));
		}
	    }
	}
    }

    private static class UserAgentInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
	    Request originalRequest = chain.request();
	    Request requestWithUserAgent = originalRequest.newBuilder().removeHeader("User-Agent").addHeader("User-Agent", USER_AGENT).build();
	    return chain.proceed(requestWithUserAgent);
	}
    }

    public static class BasicAuthenticator implements Authenticator {

	private final String username;
	private final String password;

	public BasicAuthenticator(String username, String password) {
	    this.username = username;
	    this.password = password;
	}

	@Override
	public Request authenticate(Proxy proxy, Response response) throws IOException {
	    final String credential = Credentials.basic(username, password);
	    return response.request().newBuilder().header("Authorization", credential).build();
	}

	@Override
	public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
	    return null;
	}
    }

    @Override
    public URI pathToUri(final Map<String, String> queryParameters, String... pathSegments) {
	HttpUrl.Builder builder = HttpUrl.parse(baseUrl).newBuilder();
	for (String pathSegment : pathSegments) {
	    builder.addPathSegment(pathSegment);
	}
	for (Map.Entry<String, String> e : queryParameters.entrySet()) {
	    builder.addQueryParameter(e.getKey(), e.getValue());
	}
	return builder.build().uri();
    }
}
