package com.youcruit.billogram;

import static com.youcruit.billogram.client.BillogramClient.SendCommand.SEND;
import static com.youcruit.billogram.objects.request.billogram.BillogramOrderField.CUSTOMER_NO;
import static com.youcruit.billogram.objects.request.billogram.SendMethod.EMAIL;
import static com.youcruit.billogram.objects.response.error.BillogramErrors.NOT_AVAILABLE_YET;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Test;

import com.youcruit.billogram.client.BillogramClient;
import com.youcruit.billogram.client.CustomerClient;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.exception.ApiException;
import com.youcruit.billogram.objects.request.FilterType;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.SortDirection;
import com.youcruit.billogram.objects.request.billogram.BillogramFilterField;
import com.youcruit.billogram.objects.request.billogram.BillogramOrderField;
import com.youcruit.billogram.objects.request.billogram.BillogramSearch;
import com.youcruit.billogram.objects.request.billogram.PdfFileResponse;
import com.youcruit.billogram.objects.response.billogram.Billogram;
import com.youcruit.billogram.objects.response.billogram.SearchBillogram;
import com.youcruit.billogram.objects.response.billogram.Unit;
import com.youcruit.billogram.objects.response.common.BillogramState;
import com.youcruit.billogram.objects.response.customer.BillogramCustomer;
import com.youcruit.billogram.objects.response.customer.Customer;
import com.youcruit.billogram.objects.response.item.BillogramItem;

public class BillogramIT extends HttpIT {

    private static final Logger LOGGER = Logger.getLogger(BillogramIT.class.getName());

    private final HttpClient client;
    private final BillogramClient billogramClient;

    public BillogramIT(Class<HttpClient> httpClientClass) {
	super(httpClientClass);
	client = createClient();
	billogramClient = new BillogramClient(client);
    }

    @Test
    public void createRetrieveAndSend() throws IOException, InterruptedException {
	CustomerClient customerClient = new CustomerClient(client);
	Customer customer = CustomerHelper.createCustomer(customerClient);

	final Billogram billogram = new Billogram().withCustomer(new BillogramCustomer().withCustomerNo(customer.getCustomerNo()));
	final BillogramItem item = new BillogramItem().withCount(1).withDescription("foodesc").withDiscount(BigDecimal.valueOf(5)).withItemNo("34567");
	item.withPrice(new BigDecimal("12345.25")).withTitle("titledesc").withUnit(Unit.UNIT).withVat(6);

	billogram.getItems().add(item);
	final Billogram billogram2 = billogramClient.create(billogram).getData();
	billogram2.withCurrency("SEK");
	final Billogram billogram3 = billogramClient.update(billogram2).getData();

	billogramClient.command(billogram3.getId(), EMAIL, SEND);
	PdfFileResponse pdf = null;
	int attemptsLeft = 5;
	while(true) {
	    try {
		pdf = billogramClient.getPdf(billogram3.getId(), null, null);
		break;
	    } catch (ApiException e) {
		if (e.getError().getStatus() != NOT_AVAILABLE_YET || attemptsLeft-- <= 0) {
		    throw e;
		}
		System.err.println("Retrying against");
		Thread.sleep(5000);
	    }
	}
	assertNotNull(pdf);
	assertTrue(pdf.getData().asByteArray().length != 0);
    }

    @Test
    public void createRetrieveAndSell() throws IOException, InterruptedException {
	CustomerClient customerClient = new CustomerClient(client);
	Customer customer = CustomerHelper.createCustomer(customerClient);

	final Billogram billogram = new Billogram().withCustomer(new BillogramCustomer().withCustomerNo(customer.getCustomerNo()));
	final BillogramItem item = new BillogramItem().withCount(1).withDescription("foodesc").withDiscount(BigDecimal.valueOf(5)).withItemNo("34567");
	item.withPrice(new BigDecimal("12345.25")).withTitle("titledesc").withUnit(Unit.UNIT).withVat(6);

	billogram.getItems().add(item);
	final Billogram billogram2 = billogramClient.create(billogram).getData();
	billogram2.withCurrency("SEK");
	final Billogram billogram3 = billogramClient.update(billogram2).getData();

	billogramClient.command(billogram3.getId(), BillogramClient.Command.SELL);
    }

    @Test
    public void testSearch() throws IOException, InterruptedException {
	CustomerClient customerClient = new CustomerClient(client);
	Customer customer = CustomerHelper.createCustomer(customerClient);

	final Billogram billogram = new Billogram().withCustomer(new BillogramCustomer().withCustomerNo(customer.getCustomerNo()));
	final BillogramItem item = new BillogramItem().withCount(1).withDescription("foodesc").withDiscount(BigDecimal.valueOf(5)).withItemNo("34567");
	item.withPrice(new BigDecimal("12345.25")).withTitle("titledesc").withUnit(Unit.UNIT).withVat(6);

	billogram.getItems().add(item);
	final Billogram billogram2 = billogramClient.create(billogram).getData();
	billogram2.withCurrency("SEK");
	final Billogram billogram3 = billogramClient.update(billogram2).getData();

	//billogramClient.command(billogram3.getId(), EMAIL, SEND);

	Search<BillogramFilterField, BillogramOrderField> search = new BillogramSearch();
	search.withFilter(FilterType.FIELD, BillogramFilterField.STATE, BillogramState.UNATTESTED.toString());
	search.withOrder(SortDirection.DESCENDING, CUSTOMER_NO);
	for(SearchBillogram result : billogramClient.search(search).getData()) {
	    if (result.getId().equals(billogram3.getId())) {
		return;
	    }
	}
	fail("Didn not find the document " + billogram3.getId());
    }
}
