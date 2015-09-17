package com.youcruit.billogram.client;

import java.io.IOException;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.customer.CustomerFilterField;
import com.youcruit.billogram.objects.request.customer.CustomerOrderField;
import com.youcruit.billogram.objects.response.customer.Customer;
import com.youcruit.billogram.objects.response.customer.CustomerResponse;
import com.youcruit.billogram.objects.response.customer.CustomerSearchResponse;

public class CustomerClient extends AbstractRestClient<CustomerFilterField, CustomerOrderField, CustomerSearchResponse, CustomerResponse, Customer> {

    public CustomerClient(HttpClient httpClient) {
	super(httpClient, "customer", CustomerSearchResponse.class, CustomerResponse.class);
    }

    @Override
    protected String getId(Customer fullCustomer) {
	return fullCustomer.getCustomerNo().toString();
    }

    @Override
    public CustomerResponse create(Customer fullCustomer) throws IOException {
        return super.create(fullCustomer);
    }

    @Override
    public void createAsync(Customer fullCustomer, BillogramCallback<CustomerResponse> callback) {
        super.createAsync(fullCustomer, callback);
    }

    @Override
    public CustomerResponse get(String id) throws IOException {
        return super.get(id);
    }

    @Override
    public void getAsync(String id, BillogramCallback<CustomerResponse> callback) {
        super.getAsync(id, callback);
    }

    @Override
    public CustomerSearchResponse search(Search<CustomerFilterField, CustomerOrderField> search) throws IOException {
	return super.search(search);
    }

    @Override
    public void searchAsync(Search<CustomerFilterField, CustomerOrderField> search, BillogramCallback<CustomerSearchResponse> callback) {
	super.searchAsync(search, callback);
    }

    @Override
    public CustomerResponse update(Customer fullCustomer) throws IOException {
	return super.update(fullCustomer);
    }

    @Override
    public void updateAsync(Customer fullCustomer, BillogramCallback<CustomerResponse> callback) {
	super.updateAsync(fullCustomer, callback);
    }
}
