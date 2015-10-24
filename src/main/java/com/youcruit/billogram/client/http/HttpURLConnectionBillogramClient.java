package com.youcruit.billogram.client.http;

import com.google.gson.Gson;
import com.youcruit.billogram.client.BillogramCallback;
import com.youcruit.billogram.exception.ApiException;
import com.youcruit.billogram.objects.response.error.ApiError;
import com.youcruit.billogram.objects.response.error.ErrorData;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;

public class HttpURLConnectionBillogramClient extends AbstractHttpClient {
    private static final String APPLICATION_JSON = "application/json";
	private static final String UTF_8 = "UTF-8";
	private static final String ISO_8859_1 = "ISO-8859-1";
	private final String basicAuth;
	private int connectionTimeout = 10000;
	private int requestTimeout = 10000;

	public HttpURLConnectionBillogramClient(String username, String password) {
		this(username, password, null, null);
	}

	public HttpURLConnectionBillogramClient(String username, String password, String apiUrl) {
		this(username, password, null, apiUrl);
	}

	public HttpURLConnectionBillogramClient(String username, String password, boolean sandbox) {
		this(username, password, null, getApiUrl(sandbox));
	}

	public HttpURLConnectionBillogramClient(String username, String password, Gson gson, String apiUrl) {
		super(gson, apiUrl);
		try {
			// Using ISO8859-1 to have it work the same as OkHttp Credentials class
			basicAuth = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes(ISO_8859_1));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("JVM without ISO-8859-1. SERIOUSLY broken.", e);
		}
	}

	@Override
	public <V> void async(URI uri, Object requestBody, Method method, BillogramCallback<V> callback, Class<V> responseClass) {
		throw new IllegalArgumentException("Asynchronous is not implemented in " + getClass().getName());
	}

	@Override
	public <V> V sync(URI uri, Object requestBody, Method method, Class<V> responseClass) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
		connection.setRequestMethod(method.name());
		connection.setConnectTimeout(connectionTimeout);
		connection.setReadTimeout(requestTimeout);
		connection.setUseCaches(false);
		connection.setDoInput(true);
		setHeaders(connection);
		setRequestBody(connection, requestBody);
		connection.connect();
		int responseCode = connection.getResponseCode();
		if (responseCode == 202 || responseCode == 204) {
			return null;
		} else if (responseCode >= 200 && responseCode < 300) {
			if (Void.class.getName().equals(responseClass.getName())) {
				return null;
			}
			try (InputStream is = connection.getInputStream()) {
				return gson.fromJson(new InputStreamReader(is, UTF_8), responseClass);
			}
		} else {
			try (InputStream is = connection.getErrorStream()) {
				ApiError error;
				try {
					error = gson.fromJson(new InputStreamReader(is, UTF_8), ApiError.class);
				} catch (RuntimeException e) {
					e.printStackTrace();
					error = new ApiError();
					error.setData(new ErrorData());
					error.getData().setMessage("Unpalatable response from request");
				}
				error.setHttpStatusCode(responseCode);
				throw new ApiException(error);
			}
		}
	}

	private void setRequestBody(HttpURLConnection connection, Object body) throws IOException {
		if (body != null) {
			connection.setDoOutput(true);
			try (OutputStream os = connection.getOutputStream()) {
				gson.toJson(body, new PrintStream(os));
			}
		}
	}

	private void setHeaders(HttpURLConnection connection) {
		System.err.println(USER_AGENT);
		connection.setRequestProperty("User-Agent", USER_AGENT);
		connection.setRequestProperty("Accept-Charset", UTF_8);
		connection.setRequestProperty("Accept", APPLICATION_JSON);
		connection.setRequestProperty("Content-Type", APPLICATION_JSON);
		connection.setRequestProperty("Authorization", basicAuth);
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getRequestTimeout() {
		return requestTimeout;
	}

	public void setRequestTimeout(int requestTimeout) {
		this.requestTimeout = requestTimeout;
	}
}
