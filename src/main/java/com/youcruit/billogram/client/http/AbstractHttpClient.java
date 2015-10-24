package com.youcruit.billogram.client.http;

import static java.util.Collections.EMPTY_MAP;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.client.ManifestHelper;

public abstract class AbstractHttpClient implements HttpClient {

    public static final Charset UTF8 = Charset.forName("UTF-8");

    protected final Gson gson;
    protected final String baseUrl;
	public static final String IMPLEMENTATION_TITLE = "billogram-v2-api-java-lib";

	public final static String VERSION = ManifestHelper.getVersion(IMPLEMENTATION_TITLE);
	public static final String USER_AGENT = "billogram-v2-api-java-lib-" + VERSION;

    public AbstractHttpClient(Gson gson, String baseUrl) {
	this.baseUrl = baseUrl == null ? API_BASE_URL : baseUrl;
	this.gson = gson == null ? createGson() : gson;
    }

    protected static Gson createGson() {
	return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    protected static String getApiUrl(boolean sandbox) {
	return sandbox ? API_SANDBOX_BASE_URL : API_BASE_URL;
    }


    @SuppressWarnings("unchecked")
    public URI pathToUri(String... pathSegments) {
	return pathToUri(EMPTY_MAP, pathSegments);
    }

    @SuppressWarnings("unchecked")
    public URI pathToUri(Search search, String... pathSegments) {
	if (search == null) {
	    return pathToUri(EMPTY_MAP, pathSegments);
	} else {
	    return pathToUri(search.toQueryParameters(), pathSegments);
	}
    }

    public URI pathToUri(Map<String, String> queryParameters, String... pathSegments) {
	StringBuilder sb = new StringBuilder(baseUrl);
	if (baseUrl.endsWith("/")) {
	    sb.setLength(sb.length() - 1);
	}
	try {
	    for (String pathSegment : pathSegments) {
		sb.append('/').append(URLEncoder.encode(pathSegment, "UTF-8"));
	    }

	    if (queryParameters.size() > 0) {
		boolean first = true;
		for (Map.Entry<String, String> queryParameter : queryParameters.entrySet()) {
		    sb.append(first ? '?' : '&');
		    first = false;
		    sb.append(queryParameter.getKey()).append('=').append(URLEncoder.encode(queryParameter.getValue(), "UTF-8"));
		}
	    }
	    return URI.create(sb.toString());
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
    }

    @Override
    public Gson getMapper() {
	return gson;
    }
}
