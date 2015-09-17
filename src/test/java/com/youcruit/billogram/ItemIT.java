package com.youcruit.billogram;

import java.io.IOException;

import org.junit.Test;

import com.youcruit.billogram.client.ItemClient;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.exception.ApiException;
import com.youcruit.billogram.objects.response.item.Item;

public class ItemIT extends HttpIT {
    private final HttpClient client;
    private final ItemClient itemClient;

    public ItemIT(Class<HttpClient> httpClientClass) {
	super(httpClientClass);
	client = createClient();
	itemClient = new ItemClient(client);
    }

    @Test(expected = ApiException.class)
    public void insufficientDataTest() throws IOException {
        final Item item = new Item().withCount(1);
        itemClient.create(item);
    }
}
