package com.youcruit.billogram.client;

import java.io.IOException;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.item.ItemFilterField;
import com.youcruit.billogram.objects.request.item.ItemOrderField;
import com.youcruit.billogram.objects.response.item.Item;
import com.youcruit.billogram.objects.response.item.ItemResponse;
import com.youcruit.billogram.objects.response.item.ItemSearchResponse;

public class ItemClient extends AbstractRestClient<ItemFilterField, ItemOrderField, ItemSearchResponse, ItemResponse, Item> {
    public ItemClient(HttpClient httpClient) {
	super(httpClient, "item", ItemSearchResponse.class, ItemResponse.class);
    }

    @Override
    public ItemResponse create(Item item) throws IOException {
	return super.create(item);
    }

    @Override
    public void createAsync(Item item, BillogramCallback<ItemResponse> callback) {
	super.createAsync(item, callback);
    }

    @Override
    public ItemResponse get(String id) throws IOException {
	return super.get(id);
    }

    @Override
    public void getAsync(String id, BillogramCallback<ItemResponse> callback) {
	super.getAsync(id, callback);
    }

    @Override
    public ItemSearchResponse search(Search<ItemFilterField, ItemOrderField> search) throws IOException {
	return super.search(search);
    }

    @Override
    public void searchAsync(Search<ItemFilterField, ItemOrderField> search, BillogramCallback<ItemSearchResponse> callback) {
	super.searchAsync(search, callback);
    }

    @Override
    public ItemResponse update(Item item) throws IOException {
	return super.update(item);
    }

    @Override
    public void updateAsync(Item item, BillogramCallback<ItemResponse> callback) {
	super.updateAsync(item, callback);
    }

    @Override
    public void delete(String id) throws IOException {
	super.delete(id);
    }

    @Override
    public void deleteAsync(String id, BillogramCallback<Void> callback) {
	super.deleteAsync(id, callback);
    }

    @Override
    protected String getId(Item item) {
	return item.getItemNo();
    }
}
