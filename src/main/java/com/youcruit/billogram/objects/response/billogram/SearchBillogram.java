package com.youcruit.billogram.objects.response.billogram;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.youcruit.billogram.objects.response.common.BillogramState;
import com.youcruit.billogram.objects.response.customer.BillogramCustomer;

public class SearchBillogram extends CompactBillogram {
    @Expose
    private BillogramCustomer customer = new BillogramCustomer();

    public BillogramCustomer getCustomer() {
	return customer;
    }

    public void setCustomer(BillogramCustomer customer) {
	this.customer = customer;
    }

    public SearchBillogram withCustomer(BillogramCustomer customer) {
	this.customer = customer;
	return this;
    }

    @Override
    public SearchBillogram withAttestedAt(Date attestedAt) {
	return (SearchBillogram) super.withAttestedAt(attestedAt);
    }

    @Override
    public SearchBillogram withId(String id) {
	return (SearchBillogram) super.withId(id);
    }

    @Override
    public SearchBillogram withOcrNumber(String ocrNumber) {
	return (SearchBillogram) super.withOcrNumber(ocrNumber);
    }

    @Override
    public SearchBillogram withRemainingSum(BigDecimal remainingSum) {
	return (SearchBillogram) super.withRemainingSum(remainingSum);
    }

    @Override
    public SearchBillogram withState(BillogramState state) {
	return (SearchBillogram) super.withState(state);
    }

    @Override
    public SearchBillogram withTotalSum(BigDecimal totalSum) {
	return (SearchBillogram) super.withTotalSum(totalSum);
    }

    @Override
    public SearchBillogram withCreatedAt(Date createdAt) {
        return (SearchBillogram) super.withCreatedAt(createdAt);
    }

    @Override
    public SearchBillogram withCurrency(String currency) {
        return (SearchBillogram) super.withCurrency(currency);
    }

    @Override
    public SearchBillogram withDueDate(Date dueDate) {
        return (SearchBillogram) super.withDueDate(dueDate);
    }

    @Override
    public SearchBillogram withFlags(Set<BillogramFlag> flags) {
        return (SearchBillogram) super.withFlags(flags);
    }

    @Override
    public SearchBillogram withFlags(BillogramFlag... flags) {
        return (SearchBillogram) super.withFlags(flags);
    }

    @Override
    public SearchBillogram withInvoiceDate(Date invoiceDate) {
        return (SearchBillogram) super.withInvoiceDate(invoiceDate);
    }

    @Override
    public SearchBillogram withInvoiceNo(Integer invoiceNo) {
        return (SearchBillogram) super.withInvoiceNo(invoiceNo);
    }

    @Override
    public SearchBillogram withUpdatedAt(Date updatedAt) {
        return (SearchBillogram) super.withUpdatedAt(updatedAt);
    }
}
