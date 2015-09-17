package com.youcruit.billogram;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.youcruit.billogram.client.CustomerClient;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.exception.ApiException;
import com.youcruit.billogram.objects.request.FilterType;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.SortDirection;
import com.youcruit.billogram.objects.request.customer.CustomerFilterField;
import com.youcruit.billogram.objects.request.customer.CustomerOrderField;
import com.youcruit.billogram.objects.response.address.DeliveryAddress;
import com.youcruit.billogram.objects.response.address.PrimaryAddress;
import com.youcruit.billogram.objects.response.customer.Contact;
import com.youcruit.billogram.objects.response.customer.Customer;
import com.youcruit.billogram.objects.response.customer.CustomerResponse;
import com.youcruit.billogram.objects.response.customer.CustomerSearchResponse;

public class CustomerIT extends HttpIT {
    private final HttpClient client;
    private final CustomerClient customerClient;

    public CustomerIT(Class<HttpClient> httpClientClass) {
	super(httpClientClass);
	client = createClient();
	customerClient = new CustomerClient(client);
    }


    @Test(expected = ApiException.class)
    public void createInsufficientCustomer() throws IOException {
        final Customer newCustomer = new Customer();
        newCustomer.withAddress(new PrimaryAddress().withZipcode("2345").withStreetAddress("Testg 1")
                                                    .withCareof("CO foobar")
                                                    .withUseCareofAsAttention(false)
                                                    .withCity("MMX").withCountry("SE"));
        newCustomer.withContact(new Contact().withEmail("foo@example.com").withName("Foo Bar")
                                             .withPhone("+46112112112"));
        newCustomer.withDeliveryAddress(new DeliveryAddress().withStreetAddress("Leveransgatan 1").withCareof("NA").withZipcode("12345").withName("アップデート前にゲーム").withCountry("SE").withCity("MMA"));
        newCustomer.withOrgNo("777777-7777").withVatNo("12345678");

        final CustomerResponse customerResponse = customerClient.create(newCustomer);

        customerClient.update(customerResponse.getData());
    }

    @Test
    public void createCorrectCustomer() throws IOException {
        final Customer newCustomer = new Customer();
        newCustomer.withAddress(new PrimaryAddress().withZipcode("2345").withStreetAddress("Testg 1").withCareof("CO foobar").withUseCareofAsAttention(false).withCity("MMX").withCountry("SE"));
        newCustomer.withContact(new Contact().withEmail("foo@example.com").withName("Foo Bar").withPhone("+46112112112"));
        newCustomer.withDeliveryAddress(new DeliveryAddress().withStreetAddress("Leveransgatan 1").withCareof("NA").withZipcode("12345").withName("アップデート前にゲーム").withCountry("SE").withCity("MMA"));
        newCustomer.withOrgNo("777777-7777").withVatNo("12345678").withName("BarCorp");

        final CustomerResponse customerResponse = customerClient.create(newCustomer);
    }

    @Test
    public void searchCustomer() throws IOException {
        final Customer customer = CustomerHelper.createCustomer(customerClient);
        Search<CustomerFilterField, CustomerOrderField> search = new Search<>();
        search.withFilter(FilterType.FIELD, CustomerFilterField.CUSTOMER_NO, customer.getCustomerNo().toString());
        search.withOrder(SortDirection.ASCENDING, CustomerOrderField.CREATED_AT);
        final CustomerSearchResponse response = customerClient.search(search);
        assertEquals(response.getData().size(), 1);
        assertEquals(customer.getCustomerNo(), response.getData().get(0).getCustomerNo());
    }
}
