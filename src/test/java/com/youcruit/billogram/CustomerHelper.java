package com.youcruit.billogram;

import java.io.IOException;

import com.youcruit.billogram.client.CustomerClient;
import com.youcruit.billogram.objects.response.address.DeliveryAddress;
import com.youcruit.billogram.objects.response.address.PrimaryAddress;
import com.youcruit.billogram.objects.response.billogram.CompanyType;
import com.youcruit.billogram.objects.response.customer.Contact;
import com.youcruit.billogram.objects.response.customer.CustomerResponse;
import com.youcruit.billogram.objects.response.customer.Customer;

public class CustomerHelper {
    private CustomerHelper() {}
    public static Customer createCustomer(CustomerClient customerClient) throws IOException {
	final Customer newCustomer = new Customer().withName("Foo");
	newCustomer.withAddress(new PrimaryAddress().withZipcode("2345").withStreetAddress("Testg 1")
						    .withCareof("CO foobar")
						    .withUseCareofAsAttention(false)
						    .withCity("MMX").withCountry("SE"));
	newCustomer.withContact(new Contact().withEmail("foo@example.com").withName("Foo Bar")
					     .withPhone("+46112112112"));
	newCustomer.withDeliveryAddress(new DeliveryAddress().withStreetAddress("Leveransgatan 1").withCareof("NA")
							     .withZipcode("12345").withName("アップデート前にゲーム")
							     .withCountry("SE").withCity("MMA"));
	newCustomer.withName("Test Customer").withOrgNo("777777-7777").withVatNo("12345678");
	newCustomer.withCompanyType(CompanyType.BUSINESS);

	final CustomerResponse customerResponse = customerClient.create(newCustomer);
	return customerResponse.getData();
    }
}
