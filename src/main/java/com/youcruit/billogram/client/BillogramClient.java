package com.youcruit.billogram.client;

import static com.youcruit.billogram.client.http.HttpClient.Method.GET;
import static com.youcruit.billogram.client.http.HttpClient.Method.POST;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.billogram.BillogramFilterField;
import com.youcruit.billogram.objects.request.billogram.BillogramOrderField;
import com.youcruit.billogram.objects.request.billogram.PdfFileResponse;
import com.youcruit.billogram.objects.request.billogram.SendMethod;
import com.youcruit.billogram.objects.response.billogram.Billogram;
import com.youcruit.billogram.objects.response.billogram.BillogramResponse;
import com.youcruit.billogram.objects.response.billogram.BillogramSearchResponse;
import com.youcruit.billogram.objects.response.callback.CallbackPost;

import okio.ByteString;

public class BillogramClient extends AbstractRestClient<BillogramFilterField, BillogramOrderField, BillogramSearchResponse, BillogramResponse, Billogram> {

    public enum Command {
	SELL("sell"), COLLECT("collect"), WRITEOFF("writeoff");

	public final String command;

	Command(String command) {
	    this.command = command;
	}
    }

    public enum SendCommand {
	SEND("send"), RESEND("resend"), REMIND("remind");

	public final String command;

	SendCommand(String command) {
	    this.command = command;
	}
    }

    public enum CreditMode {
	@SerializedName("full")FULL,
	@SerializedName("remaining") REMAINING,
	@SerializedName("amount") AMOUNT;
    }

    public BillogramClient(HttpClient httpClient) {
	super(httpClient, "billogram", BillogramSearchResponse.class, BillogramResponse.class);
    }

    @Override
    public BillogramResponse create(Billogram fullBillogram) throws IOException {
	return super.create(fullBillogram);
    }

    @Override
    public void createAsync(Billogram fullBillogram, BillogramCallback<BillogramResponse> callback) {
	super.createAsync(fullBillogram, callback);
    }

    @Override
    public BillogramResponse update(Billogram fullBillogram) throws IOException {
	return super.update(fullBillogram);
    }

    @Override
    public void updateAsync(Billogram fullBillogram, BillogramCallback<BillogramResponse> callback) {
	super.updateAsync(fullBillogram, callback);
    }

    @Override
    public BillogramResponse get(String id) throws IOException {
	return super.get(id);
    }

    @Override
    public void getAsync(String id, BillogramCallback<BillogramResponse> callback) {
	super.getAsync(id, callback);
    }

    @Override
    public BillogramSearchResponse search(Search<BillogramFilterField, BillogramOrderField> search) throws IOException {
	return super.search(search);
    }

    @Override
    public void searchAsync(Search<BillogramFilterField, BillogramOrderField> search, BillogramCallback<BillogramSearchResponse> callback) {
	super.searchAsync(search, callback);
    }

    public BillogramResponse command(String billogramId, Command command) throws IOException {
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", command.command);
	return httpClient.sync(uri, null, POST, responseClass);
    }


    public void commandAsync(String billogramId, Command command, BillogramCallback<BillogramResponse> callback) {
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", command.command);
	httpClient.async(uri, null, POST, callback, BillogramResponse.class);
    }

    public BillogramResponse command(String billogramId, SendMethod resendMethod, SendCommand command) throws IOException {
	Map<String, SendMethod> resendRequest = Collections.singletonMap("method", resendMethod);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", command.command);
	return httpClient.sync(uri, resendRequest, POST, responseClass);
    }


    public void commandAsync(String billogramId, SendMethod resendMethod, SendCommand command, BillogramCallback<BillogramResponse> callback) {
	Map<String, SendMethod> resendRequest = Collections.singletonMap("method", resendMethod);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", command.command);
	httpClient.async(uri, resendRequest, POST, callback, BillogramResponse.class);
    }

    public BillogramResponse commandPayment(String billogramId, BigDecimal amount) throws IOException {
	Map<String, BigDecimal> paymentRequest = Collections.singletonMap("amount", amount);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "payment");
	return httpClient.sync(uri, paymentRequest, POST, BillogramResponse.class);
    }

    public void commandPaymentAsync(String billogramId, BigDecimal amount, BillogramCallback<BillogramResponse> callback) {
	Map<String, BigDecimal> paymentRequest = Collections.singletonMap("amount", amount);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "payment");
	httpClient.async(uri, paymentRequest, POST, callback, BillogramResponse.class);
    }

    public BillogramResponse commandCredit(String billogramId, BigDecimal amount, CreditMode creditMode) throws IOException {
	Map<String, Object> creditRequest = new HashMap<>();
	creditRequest.put("mode", creditMode);
	creditRequest.put("amount", amount);
	final URI uri = httpClient.pathToUri("billogram" + billogramId, "command", "credit");
	return httpClient.sync(uri, creditRequest, POST, BillogramResponse.class);
    }

    public void commandCredit(String billogramId, BigDecimal amount, CreditMode creditMode, BillogramCallback<BillogramResponse> callback) {
	Map<String, Object> creditRequest = new HashMap<>();
	creditRequest.put("mode", creditMode);
	creditRequest.put("amount", amount);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "credit");
	httpClient.async(uri, creditRequest, POST, callback, BillogramResponse.class);
    }

    public BillogramResponse addMessage(String billogramId, String message) throws IOException {
	Map<String, String> body = Collections.singletonMap("message", message);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "message");
	return httpClient.sync(uri, body, POST, BillogramResponse.class);
    }

    public void addMessageAsync(String billogramId, String message, BillogramCallback<BillogramResponse> callback) {
	Map<String, String> body = Collections.singletonMap("message", message);
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "message");
	httpClient.async(uri, body, POST, callback, BillogramResponse.class);
    }

    public BillogramResponse addPdf(String billogramId, String fileName, byte[] pdfData) throws IOException {
	Map<String, String> body = new HashMap<>();
	body.put("filename", fileName);
	body.put("content", ByteString.of(pdfData).base64());
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "attach");
	return httpClient.sync(uri, body, POST, BillogramResponse.class);
    }

    public void addPdfAsync(String billogramId, String fileName, byte[] pdfData, BillogramCallback<BillogramResponse> callback) {
	Map<String, String> body = new HashMap<>();
	body.put("filename", fileName);
	body.put("content", ByteString.of(pdfData).base64());
	final URI uri = httpClient.pathToUri(endpoint, billogramId, "command", "attach");
	httpClient.async(uri, body, POST, callback, BillogramResponse.class);
    }

    public PdfFileResponse getPdf(String billogramId, String invoiceNo, String letterId) throws IOException {
	Map<String, String> queryParameters = createPdfQueryParameter(invoiceNo, letterId);
	final URI uri = httpClient.pathToUri(queryParameters, endpoint, billogramId + ".pdf");
	return httpClient.sync(uri, null, GET, PdfFileResponse.class);
    }

    public void getPdf(String billogramId, String invoiceNo, String letterId, BillogramCallback<PdfFileResponse> callback) {
	Map<String, String> queryParameters = createPdfQueryParameter(invoiceNo, letterId);
	final URI uri = httpClient.pathToUri(queryParameters, endpoint, billogramId + ".pdf");
	httpClient.async(uri, null, GET, callback, PdfFileResponse.class);
    }

    public PdfFileResponse getPdfAttachment(String billogramId, String invoiceNo, String letterId) throws IOException {
	Map<String, String> queryParameters = createPdfQueryParameter(invoiceNo, letterId);
	final URI uri = httpClient.pathToUri(queryParameters, endpoint, billogramId + ".pdf");
	return httpClient.sync(uri, null, GET, PdfFileResponse.class);
    }

    public void getPdfAttachment(String billogramId, String invoiceNo, String letterId, BillogramCallback<PdfFileResponse> callback) {
	Map<String, String> queryParameters = createPdfQueryParameter(invoiceNo, letterId);
	final URI uri = httpClient.pathToUri(queryParameters, endpoint, billogramId + ".pdf");
	httpClient.async(uri, null, GET, callback, PdfFileResponse.class);
    }
    private Map<String, String> createPdfQueryParameter(final String invoiceNo, final String letterId) {
	Map<String, String> queryParameters = new HashMap<>();
	if (invoiceNo != null) {
	    queryParameters.put("invoice_no", invoiceNo);
	}
	if (letterId != null) {
	    queryParameters.put("letter_id", letterId);
	}
	return queryParameters;
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
    protected String getId(Billogram fullBillogram) {
	return fullBillogram.getId();
    }

    public CallbackPost parseCallback(String json) {
	return httpClient.getMapper().fromJson(json, CallbackPost.class);
    }
}
