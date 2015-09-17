package com.youcruit.billogram.objects.response.billogram;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsData {

    @SerializedName("invoice_no")
    @Expose
    private Integer invoiceNo;
    @SerializedName("delivery_method")
    @Expose
    private DeliveryMethod deliveryMethod;
    @SerializedName("letter_id")
    @Expose
    private String letterId;
    @Expose
    private BigDecimal amount;
    @Expose
    @SerializedName("payer_name")
    private String payerName;
    @Expose
    @SerializedName("banking_amount")
    private BigDecimal bankingAmount;
    @Expose
    private Boolean manual;
    @Expose
    @SerializedName("reminder_fee")
    private BigDecimal reminderFee;
    @Expose
    @SerializedName("reminder_count")
    private Integer reminderCount;
    @Expose
    @SerializedName("interest_rate")
    private BigDecimal interestRate;
    @Expose
    @SerializedName("customer_email")
    private String customerEmail;
    @Expose
    private String ip;
    @Expose
    private String type;
    @Expose
    private String message;
    @Expose
    @SerializedName("collector_method")
    private String collectorMethod;
    @Expose
    @SerializedName("collector_reference")
    private String collectorReference;
    @Expose
    @SerializedName("factoring_method")
    private String factoringMethod;
    @Expose
    @SerializedName("factoring_reference")
    private String factoringReference;
    @Expose
    @SerializedName("sells_for")
    private BigDecimal sellsFor;
    @Expose
    @SerializedName("sold_for")
    private BigDecimal soldFor;
    @SerializedName("remaining_sum")
    @Expose
    private Integer remainingSum;
    @SerializedName("total_sum")
    @Expose
    private Integer totalSum;
    @Expose
    @SerializedName("scanning_central")
    private boolean scanningCentral;

    public Integer getInvoiceNo() {
	return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
	this.invoiceNo = invoiceNo;
    }

    public String getLetterId() {
	return letterId;
    }

    public void setLetterId(String letterId) {
	this.letterId = letterId;
    }

    public DeliveryMethod getDeliveryMethod() {
	return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
	this.deliveryMethod = deliveryMethod;
    }

    public Integer getRemainingSum() {
	return remainingSum;
    }

    public void setRemainingSum(Integer remainingSum) {
	this.remainingSum = remainingSum;
    }

    public EventsData withRemainingSum(Integer remainingSum) {
	this.setRemainingSum(remainingSum);
	return this;
    }

    public Integer getTotalSum() {
	return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
	this.totalSum = totalSum;
    }

    public EventsData withTotalSum(Integer totalSum) {
	this.setTotalSum(totalSum);
	return this;
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public String getPayerName() {
	return payerName;
    }

    public void setPayerName(String payerName) {
	this.payerName = payerName;
    }

    public BigDecimal getBankingAmount() {
	return bankingAmount;
    }

    public void setBankingAmount(BigDecimal bankingAmount) {
	this.bankingAmount = bankingAmount;
    }

    public Boolean getManual() {
	return manual;
    }

    public void setManual(Boolean manual) {
	this.manual = manual;
    }

    public BigDecimal getReminderFee() {
	return reminderFee;
    }

    public void setReminderFee(BigDecimal reminderFee) {
	this.reminderFee = reminderFee;
    }

    public Integer getReminderCount() {
	return reminderCount;
    }

    public void setReminderCount(Integer reminderCount) {
	this.reminderCount = reminderCount;
    }

    public BigDecimal getInterestRate() {
	return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
	this.interestRate = interestRate;
    }

    public String getCustomerEmail() {
	return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getCollectorMethod() {
	return collectorMethod;
    }

    public void setCollectorMethod(String collectorMethod) {
	this.collectorMethod = collectorMethod;
    }

    public String getCollectorReference() {
	return collectorReference;
    }

    public void setCollectorReference(String collectorReference) {
	this.collectorReference = collectorReference;
    }

    public String getFactoringMethod() {
	return factoringMethod;
    }

    public void setFactoringMethod(String factoringMethod) {
	this.factoringMethod = factoringMethod;
    }

    public String getFactoringReference() {
	return factoringReference;
    }

    public void setFactoringReference(String factoringReference) {
	this.factoringReference = factoringReference;
    }

    public BigDecimal getSellsFor() {
	return sellsFor;
    }

    public void setSellsFor(BigDecimal sellsFor) {
	this.sellsFor = sellsFor;
    }

    public BigDecimal getSoldFor() {
	return soldFor;
    }

    public void setSoldFor(BigDecimal soldFor) {
	this.soldFor = soldFor;
    }

    public boolean isScanningCentral() {
	return scanningCentral;
    }

    public void setScanningCentral(boolean scanningCentral) {
	this.scanningCentral = scanningCentral;
    }
}
