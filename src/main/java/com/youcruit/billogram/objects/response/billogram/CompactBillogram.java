package com.youcruit.billogram.objects.response.billogram;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.serializers.DateTypeAdapter;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public abstract class CompactBillogram extends CallbackBillogram {
    @SerializedName("invoice_no")
    @Expose
    private Integer invoiceNo;
    @Expose(serialize = false)
    private Set<BillogramFlag> flags = new HashSet<>();
    @SerializedName("invoice_date")
    @Expose
    @JsonAdapter(DateTypeAdapter.class)
    private Date invoiceDate;
    @SerializedName("due_date")
    @Expose
    @JsonAdapter(DateTypeAdapter.class)
    private Date dueDate;
    @Expose
    private String currency;
    @SerializedName("created_at")
    @Expose(serialize = false)
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date createdAt;
    @SerializedName("updated_at")
    @Expose(serialize = false)
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date updatedAt;

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public CompactBillogram withCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
	return this;
    }

    public Date getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
    }

    public CompactBillogram withUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
	return this;
    }

    public String getCurrency() {
	return currency;
    }

    public void setCurrency(String currency) {
	this.currency = currency;
    }

    public CompactBillogram withCurrency(String currency) {
	this.currency = currency;
	return this;
    }

    public Date getDueDate() {
	return dueDate;
    }

    public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
    }

    public CompactBillogram withDueDate(Date dueDate) {
	this.dueDate = dueDate;
	return this;
    }

    public Date getInvoiceDate() {
	return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
	this.invoiceDate = invoiceDate;
    }

    public CompactBillogram withInvoiceDate(Date invoiceDate) {
	this.invoiceDate = invoiceDate;
	return this;
    }

    public Integer getInvoiceNo() {
	return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
	this.invoiceNo = invoiceNo;
    }

    public CompactBillogram withInvoiceNo(Integer invoiceNo) {
	this.invoiceNo = invoiceNo;
	return this;
    }


    public Set<BillogramFlag> getFlags() {
	return flags;
    }

    public void setFlags(Set<BillogramFlag> flags) {
	this.flags = flags;
    }

    public CompactBillogram withFlags(Set<BillogramFlag> flags) {
	this.flags = flags;
	return this;
    }

    public CompactBillogram withFlags(BillogramFlag... flags) {
	this.flags.addAll(Arrays.asList(flags));
	return this;
    }
}
