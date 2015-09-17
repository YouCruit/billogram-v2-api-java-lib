package com.youcruit.billogram.client;

import static com.youcruit.billogram.client.http.HttpClient.Method.DELETE;
import static com.youcruit.billogram.client.http.HttpClient.Method.GET;
import static com.youcruit.billogram.client.http.HttpClient.Method.POST;
import static com.youcruit.billogram.client.http.HttpClient.Method.PUT;

import java.io.IOException;
import java.net.URI;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.FilterField;
import com.youcruit.billogram.objects.request.OrderField;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.response.common.Response;
import com.youcruit.billogram.objects.response.common.SearchResponse;

abstract class AbstractRestClient<F extends FilterField, O extends OrderField, SR extends SearchResponse, R extends Response, Data> {
    protected final HttpClient httpClient;
    protected final String endpoint;
    protected final Class<SR> searchResponseClass;
    protected final Class<R> responseClass;

    public AbstractRestClient(HttpClient httpClient, String endpoint, Class<SR> searchResponseClass, Class<R> responseClass) {
	this.httpClient = httpClient;
	this.endpoint = endpoint;
	this.searchResponseClass = searchResponseClass;
	this.responseClass = responseClass;
    }


    protected SR search(Search<F, O> search) throws IOException {
	final URI uri = httpClient.pathToUri(search, endpoint);
	return httpClient.sync(uri, null, GET, searchResponseClass);
    }

    protected void searchAsync(Search<F, O> search, BillogramCallback<SR> callback) {
	final URI uri = httpClient.pathToUri(search, endpoint);
	httpClient.async(uri, null, GET, callback, searchResponseClass);
    }

    protected R get(String id) throws IOException {
	final URI uri = httpClient.pathToUri(endpoint, id);
	return httpClient.sync(uri, null, GET, responseClass);
    }

    protected void getAsync(String id, BillogramCallback<R> callback) {
	final URI uri = httpClient.pathToUri(endpoint, id);
	httpClient.async(uri, null, GET, callback, responseClass);
    }

    protected R update(Data data) throws IOException {
	final URI uri = httpClient.pathToUri(endpoint, getId(data));
	return httpClient.sync(uri, data, PUT, responseClass);
    }

    protected void updateAsync(Data data, BillogramCallback<R> callback) {
	final URI uri = httpClient.pathToUri(endpoint, getId(data));
	httpClient.async(uri, data, PUT, callback, responseClass);
    }

    protected R create(Data data) throws IOException {
	final URI uri = httpClient.pathToUri(endpoint);
	return httpClient.sync(uri, data, POST, responseClass);
    }

    protected void createAsync(Data data, BillogramCallback<R> callback) {
	final URI uri = httpClient.pathToUri(endpoint);
	httpClient.async(uri, data, POST, callback, responseClass);
    }

    protected void delete(String id) throws IOException {
	final URI uri = httpClient.pathToUri(endpoint, id);
	httpClient.sync(uri, null, DELETE, Void.class);
    }

    protected void deleteAsync(String id, BillogramCallback<Void> callback) {
	final URI uri = httpClient.pathToUri(endpoint, id);
	httpClient.async(uri, null, DELETE, callback, Void.class);
    }

    protected abstract String getId(Data data);
}
