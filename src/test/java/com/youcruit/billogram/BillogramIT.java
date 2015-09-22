package com.youcruit.billogram;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.youcruit.billogram.client.BillogramClient;
import com.youcruit.billogram.client.CustomerClient;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.response.billogram.Billogram;
import com.youcruit.billogram.objects.response.billogram.Unit;
import com.youcruit.billogram.objects.response.customer.BillogramCustomer;
import com.youcruit.billogram.objects.response.customer.Customer;
import com.youcruit.billogram.objects.response.item.BillogramItem;

public class BillogramIT extends HttpIT {

    private final HttpClient client;
    private final BillogramClient billogramClient;

    public BillogramIT(Class<HttpClient> httpClientClass) {
	super(httpClientClass);
	client = createClient();
	billogramClient = new BillogramClient(client);
    }

    @Test
    public void createTestInsufficientData() throws IOException {
	CustomerClient customerClient = new CustomerClient(client);
	Customer customer = CustomerHelper.createCustomer(customerClient);

	final Billogram billogram = new Billogram().withCustomer(new BillogramCustomer().withCustomerNo(customer
		.getCustomerNo()));
	final BillogramItem item = new BillogramItem().withCount(1).withDescription("foodesc").withDiscount(BigDecimal.valueOf(5))
						      .withItemNo("34567");
	item.withPrice(new BigDecimal("12345.25")).withTitle("titledesc").withUnit(Unit.UNIT).withVat(6);

	billogram.getItems().add(item);
	final Billogram billogram2 = billogramClient.create(billogram).getData();
	billogram2.withCurrency("SEK");
	final Billogram billogram3 = billogramClient.update(billogram2).getData();
	billogramClient.delete(billogram2.getId());
    }
}
