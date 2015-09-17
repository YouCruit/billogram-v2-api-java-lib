package com.youcruit.billogram;

import java.io.IOException;

import org.junit.Test;

import com.youcruit.billogram.client.ReportClient;
import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.report.ReportFilterField;
import com.youcruit.billogram.objects.request.report.ReportOrderField;
import com.youcruit.billogram.objects.response.report.ReportSearchResponse;

public class ReportIT extends HttpIT {
    private final HttpClient client;
    private final ReportClient reportClient;

    public ReportIT(Class<HttpClient> httpClientClass) {
	super(httpClientClass);
	client = createClient();
	reportClient = new ReportClient(client);
    }

    @Test
    public void foo() throws IOException {
	final ReportSearchResponse searchResponse = reportClient.search(new Search<ReportFilterField, ReportOrderField>());
	System.err.println(searchResponse.getData());
    }
}
