package com.youcruit.billogram.client;

import java.io.IOException;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.event.EventFilterField;
import com.youcruit.billogram.objects.request.event.EventOrderField;
import com.youcruit.billogram.objects.response.common.Response;
import com.youcruit.billogram.objects.response.event.Event;
import com.youcruit.billogram.objects.response.event.EventSearchResponse;

public class EventClient extends AbstractRestClient<EventFilterField, EventOrderField, EventSearchResponse, Response, Event> {

    public EventClient(HttpClient httpClient) {
	super(httpClient, "billogram_event", EventSearchResponse.class, Response.class);
    }

    @Override
    public void searchAsync(Search<EventFilterField, EventOrderField> search, BillogramCallback<EventSearchResponse> callback) {
	super.searchAsync(search, callback);
    }

    @Override
    public EventSearchResponse search(Search<EventFilterField, EventOrderField> search) throws IOException {
	return super.search(search);
    }

    @Override
    protected String getId(Event fullEvent) {
	return null;
    }
}
