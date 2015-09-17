package com.youcruit.billogram.client.http;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import com.youcruit.billogram.client.BillogramCallback;
import com.youcruit.billogram.objects.request.Search;

public interface HttpClient {

    String API_BASE_URL = "https://billogram.com/api/v2";
    String API_SANDBOX_BASE_URL = "https://sandbox.billogram.com/api/v2";

    enum Method {
	PUT, POST, GET, DELETE
    }

    <V> void async(URI uri, Object requestBody, Method method, BillogramCallback<V> callback, Class<V> responseClass);

    <V> V sync(URI uri, Object requestBody, Method method, Class<V> responseClass) throws IOException;


    URI pathToUri(String... pathSegments);

    URI pathToUri(Search search, String... pathSegments);

    URI pathToUri(Map<String, String> queryParameters, String... pathSegments);

}
