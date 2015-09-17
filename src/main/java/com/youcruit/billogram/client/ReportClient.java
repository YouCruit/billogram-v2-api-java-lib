package com.youcruit.billogram.client;

import java.io.IOException;

import com.youcruit.billogram.client.http.HttpClient;
import com.youcruit.billogram.objects.request.Search;
import com.youcruit.billogram.objects.request.report.ReportFilterField;
import com.youcruit.billogram.objects.request.report.ReportOrderField;
import com.youcruit.billogram.objects.response.report.Report;
import com.youcruit.billogram.objects.response.report.ReportResponse;
import com.youcruit.billogram.objects.response.report.ReportSearchResponse;

public class ReportClient extends AbstractRestClient<ReportFilterField, ReportOrderField, ReportSearchResponse, ReportResponse, Report> {
    public ReportClient(HttpClient httpClient) {
	super(httpClient, "report", ReportSearchResponse.class, ReportResponse.class);
    }

    @Override
    public String getId(Report report) {
	return report.getFilename();
    }

    @Override
    public ReportResponse get(String filename) throws IOException {
	return super.get(filename);
    }

    @Override
    public void getAsync(String filename, BillogramCallback<ReportResponse> callback) {
	super.getAsync(filename, callback);
    }

    @Override
    public ReportSearchResponse search(Search<ReportFilterField, ReportOrderField> search) throws IOException {
	return super.search(search);
    }

    @Override
    public void searchAsync(Search<ReportFilterField, ReportOrderField> search, BillogramCallback<ReportSearchResponse> callback) {
	super.searchAsync(search, callback);
    }
}
