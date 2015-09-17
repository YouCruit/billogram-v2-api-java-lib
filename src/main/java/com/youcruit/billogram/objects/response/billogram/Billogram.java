package com.youcruit.billogram.objects.response.billogram;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.common.BillogramState;
import com.youcruit.billogram.objects.response.customer.BillogramCustomer;
import com.youcruit.billogram.objects.response.event.CallbackEvent;
import com.youcruit.billogram.objects.response.item.BillogramItem;

public class Billogram extends CompactBillogram {

    @SerializedName("reminder_fee")
    @Expose
    private String reminderFee;
    @SerializedName("interest_rate")
    @Expose
    private BigDecimal interestRate;
    @Expose(serialize = false)
    private String attachment;
    @SerializedName("automatic_reminders")
    @Expose
    private Boolean automaticReminders;
    @SerializedName("rounding_value")
    @Expose(serialize = false)
    private BigDecimal roundingValue;
    @Expose(serialize = false)
    private List<CallbackEvent> events = new ArrayList<>();
    @SerializedName("due_days")
    @Expose
    private Integer dueDays;
    @Expose
    private Callback callbacks = new Callback();
    @SerializedName("interest_fee")
    @Expose(serialize = false)
    private Integer interestFee;
    @Expose
    private Info info;
    @SerializedName("invoice_fee")
    @Expose
    private Integer invoiceFee;
    @SerializedName("invoice_fee_vat")
    @Expose(serialize = false)
    private Integer invoiceFeeVat;
    @Expose
    private List<BillogramItem> items = new ArrayList<>();
    @SerializedName("reminder_count")
    @Expose(serialize = false)
    private Integer reminderCount;
    @SerializedName("delivery_method")
    @Expose(serialize = false)
    private DeliveryMethod deliveryMethod;
    @Expose(serialize = false)
    private String url;
    @SerializedName("regional_sweden")
    @Expose
    private SwedenSpecific regionalSweden;
    @SerializedName("detailed_sums")
    @Expose(serialize = false)
    private DetailedSums detailedSums = new DetailedSums();
    @Expose
    private BillogramCustomer customer;

    public Billogram withAttestedAt(Date attestedAt) {
	super.withAttestedAt(attestedAt);
	return this;
    }

    public String getReminderFee() {
	return reminderFee;
    }

    public void setReminderFee(String reminderFee) {
	this.reminderFee = reminderFee;
    }

    public Billogram withReminderFee(String reminderFee) {
	this.reminderFee = reminderFee;
	return this;
    }

    public BigDecimal getInterestRate() {
	return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
	this.interestRate = interestRate;
    }

    public Billogram withInterestRate(BigDecimal interestRate) {
	this.interestRate = interestRate;
	return this;
    }

    public Billogram withState(BillogramState state) {
	super.withState(state);
	return this;
    }

    public String getAttachment() {
	return attachment;
    }

    public void setAttachment(String attachment) {
	this.attachment = attachment;
    }

    public Billogram withAttachment(String attachment) {
	this.attachment = attachment;
	return this;
    }

    public Boolean getAutomaticReminders() {
	return automaticReminders;
    }

    public void setAutomaticReminders(Boolean automaticReminders) {
	this.automaticReminders = automaticReminders;
    }

    public Billogram withAutomaticReminders(Boolean automaticReminders) {
	this.automaticReminders = automaticReminders;
	return this;
    }

    public BigDecimal getRoundingValue() {
	return roundingValue;
    }

    public void setRoundingValue(BigDecimal roundingValue) {
	this.roundingValue = roundingValue;
    }

    public Billogram withRoundingValue(BigDecimal roundingValue) {
	this.roundingValue = roundingValue;
	return this;
    }

    public Billogram withOcrNumber(String ocrNumber) {
	super.withOcrNumber(ocrNumber);
	return this;
    }

    public List<CallbackEvent> getEvents() {
	return events;
    }

    public void setEvents(List<CallbackEvent> events) {
	this.events = events;
    }

    public Billogram withEvents(List<CallbackEvent> events) {
	this.events = events;
	return this;
    }

    public Integer getDueDays() {
	return dueDays;
    }

    public void setDueDays(Integer dueDays) {
	this.dueDays = dueDays;
    }

    public Billogram withDueDays(Integer dueDays) {
	this.dueDays = dueDays;
	return this;
    }

    public Callback getCallbacks() {
	return callbacks;
    }

    public void setCallbacks(Callback callbacks) {
	this.callbacks = callbacks;
    }

    public Billogram withCallbacks(Callback callbacks) {
	this.callbacks = callbacks;
	return this;
    }

    public Integer getInterestFee() {
	return interestFee;
    }

    public void setInterestFee(Integer interestFee) {
	this.interestFee = interestFee;
    }

    public Billogram withInterestFee(Integer interestFee) {
	this.interestFee = interestFee;
	return this;
    }

    public Info getInfo() {
	return info;
    }

    public void setInfo(Info info) {
	this.info = info;
    }

    public Billogram withInfo(Info info) {
	this.info = info;
	return this;
    }

    public Integer getInvoiceFee() {
	return invoiceFee;
    }

    public void setInvoiceFee(Integer invoiceFee) {
	this.invoiceFee = invoiceFee;
    }

    public Billogram withInvoiceFee(Integer invoiceFee) {
	this.invoiceFee = invoiceFee;
	return this;
    }

    public Integer getInvoiceFeeVat() {
	return invoiceFeeVat;
    }

    public void setInvoiceFeeVat(Integer invoiceFeeVat) {
	this.invoiceFeeVat = invoiceFeeVat;
    }

    public Billogram withInvoiceFeeVat(Integer invoiceFeeVat) {
	this.invoiceFeeVat = invoiceFeeVat;
	return this;
    }

    public List<BillogramItem> getItems() {
	return items;
    }

    public void setItems(List<BillogramItem> items) {
	this.items = items;
    }

    public Billogram withItems(List<BillogramItem> items) {
	this.items = items;
	return this;
    }

    public Billogram withTotalSum(BigDecimal totalSum) {
	super.withTotalSum(totalSum);
	return this;
    }

    public Billogram withRemainingSum(BigDecimal remainingSum) {
	super.withRemainingSum(remainingSum);
	return this;
    }

    public Integer getReminderCount() {
	return reminderCount;
    }

    public void setReminderCount(Integer reminderCount) {
	this.reminderCount = reminderCount;
    }

    public Billogram withReminderCount(Integer reminderCount) {
	this.reminderCount = reminderCount;
	return this;
    }

    public DeliveryMethod getDeliveryMethod() {
	return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
	this.deliveryMethod = deliveryMethod;
    }

    public Billogram withDeliveryMethod(DeliveryMethod deliveryMethod) {
	this.deliveryMethod = deliveryMethod;
	return this;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public Billogram withUrl(String url) {
	this.url = url;
	return this;
    }

    public SwedenSpecific getRegionalSweden() {
	return regionalSweden;
    }

    public void setRegionalSweden(SwedenSpecific regionalSweden) {
	this.regionalSweden = regionalSweden;
    }

    public Billogram withRegionalSweden(SwedenSpecific regionalSweden) {
	this.regionalSweden = regionalSweden;
	return this;
    }

    public DetailedSums getDetailedSums() {
	return detailedSums;
    }

    public void setDetailedSums(DetailedSums detailedSums) {
	this.detailedSums = detailedSums;
    }

    public Billogram withDetailedSums(DetailedSums detailedSums) {
	this.detailedSums = detailedSums;
	return this;
    }

    @Override
    public Billogram withId(String id) {
        super.withId(id);
        return this;
    }

    @Override
    public Billogram withCreatedAt(Date createdAt) {
        super.withCreatedAt(createdAt);
        return this;
    }

    @Override
    public Billogram withCurrency(String currency) {
        super.withCurrency(currency);
        return this;
    }

    public BillogramCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BillogramCustomer customer) {
        this.customer = customer;
    }

    public Billogram withCustomer(BillogramCustomer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public Billogram withDueDate(Date dueDate) {
        super.withDueDate(dueDate);
        return this;
    }

    @Override
    public Billogram withFlags(Set<BillogramFlag> flags) {
        super.withFlags(flags);
        return this;
    }

    @Override
    public Billogram withUpdatedAt(Date updatedAt) {
        super.withUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public Billogram withFlags(BillogramFlag... flags) {
        super.withFlags(flags);
        return this;
    }

    @Override
    public Billogram withInvoiceDate(Date invoiceDate) {
        super.withInvoiceDate(invoiceDate);
        return this;
    }

    @Override
    public Billogram withInvoiceNo(Integer invoiceNo) {
        super.withInvoiceNo(invoiceNo);
        return this;
    }

}