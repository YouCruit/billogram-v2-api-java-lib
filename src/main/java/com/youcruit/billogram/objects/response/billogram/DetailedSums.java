package com.youcruit.billogram.objects.response.billogram;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailedSums {

    @SerializedName("invoice_fee")
    @Expose
    private Integer invoiceFee;
    @SerializedName("invoice_fee_vat")
    @Expose
    private Integer invoiceFeeVat;
    @SerializedName("net_sum")
    @Expose
    private BigDecimal netSum;
    @SerializedName("vat_sum")
    @Expose
    private BigDecimal vatSum;
    @SerializedName("gross_sum")
    @Expose
    private BigDecimal grossSum;
    @Expose
    private BigDecimal rounding;
    @SerializedName("reminder_fee")
    @Expose
    private BigDecimal reminderFee;
    @SerializedName("interest_fee")
    @Expose
    private BigDecimal interestFee;
    @SerializedName("paid_sum")
    @Expose
    private BigDecimal paidSum;
    @SerializedName("collector_paid_sum")
    @Expose
    private BigDecimal collectorPaidSum;
    @SerializedName("remaining_sum")
    @Expose
    private BigDecimal remainingSum;
    @SerializedName("regional_sweden")
    @Expose
    private SwedenSpecificDetailedSum regionalSweden;

    
    public Integer getInvoiceFee() {
	return invoiceFee;
    }

    
    public void setInvoiceFee(Integer invoiceFee) {
	this.invoiceFee = invoiceFee;
    }

    public DetailedSums withInvoiceFee(Integer invoiceFee) {
	this.invoiceFee = invoiceFee;
	return this;
    }

    
    public Integer getInvoiceFeeVat() {
	return invoiceFeeVat;
    }

    
    public void setInvoiceFeeVat(Integer invoiceFeeVat) {
	this.invoiceFeeVat = invoiceFeeVat;
    }

    public DetailedSums withInvoiceFeeVat(Integer invoiceFeeVat) {
	this.invoiceFeeVat = invoiceFeeVat;
	return this;
    }

    
    public BigDecimal getNetSum() {
	return netSum;
    }

    
    public void setNetSum(BigDecimal netSum) {
	this.netSum = netSum;
    }

    public DetailedSums withNetSum(BigDecimal netSum) {
	this.netSum = netSum;
	return this;
    }

    
    public BigDecimal getVatSum() {
	return vatSum;
    }

    
    public void setVatSum(BigDecimal vatSum) {
	this.vatSum = vatSum;
    }

    public DetailedSums withVatSum(BigDecimal vatSum) {
	this.vatSum = vatSum;
	return this;
    }

    
    public BigDecimal getGrossSum() {
	return grossSum;
    }

    
    public void setGrossSum(BigDecimal grossSum) {
	this.grossSum = grossSum;
    }

    public DetailedSums withGrossSum(BigDecimal grossSum) {
	this.grossSum = grossSum;
	return this;
    }

    
    public BigDecimal getRounding() {
	return rounding;
    }

    
    public void setRounding(BigDecimal rounding) {
	this.rounding = rounding;
    }

    public DetailedSums withRounding(BigDecimal rounding) {
	this.rounding = rounding;
	return this;
    }

    
    public BigDecimal getReminderFee() {
	return reminderFee;
    }

    
    public void setReminderFee(BigDecimal reminderFee) {
	this.reminderFee = reminderFee;
    }

    public DetailedSums withReminderFee(BigDecimal reminderFee) {
	this.reminderFee = reminderFee;
	return this;
    }

    
    public BigDecimal getInterestFee() {
	return interestFee;
    }

    
    public void setInterestFee(BigDecimal interestFee) {
	this.interestFee = interestFee;
    }

    public DetailedSums withInterestFee(BigDecimal interestFee) {
	this.interestFee = interestFee;
	return this;
    }

    
    public BigDecimal getPaidSum() {
	return paidSum;
    }

    
    public void setPaidSum(BigDecimal paidSum) {
	this.paidSum = paidSum;
    }

    public DetailedSums withPaidSum(BigDecimal paidSum) {
	this.paidSum = paidSum;
	return this;
    }

    
    public BigDecimal getCollectorPaidSum() {
	return collectorPaidSum;
    }

    
    public void setCollectorPaidSum(BigDecimal collectorPaidSum) {
	this.collectorPaidSum = collectorPaidSum;
    }

    public DetailedSums withCollectorPaidSum(BigDecimal collectorPaidSum) {
	this.collectorPaidSum = collectorPaidSum;
	return this;
    }

    
    public BigDecimal getRemainingSum() {
	return remainingSum;
    }

    
    public void setRemainingSum(BigDecimal remainingSum) {
	this.remainingSum = remainingSum;
    }

    public DetailedSums withRemainingSum(BigDecimal remainingSum) {
	this.remainingSum = remainingSum;
	return this;
    }

    
    public SwedenSpecificDetailedSum getRegionalSweden() {
	return regionalSweden;
    }

    
    public void setRegionalSweden(SwedenSpecificDetailedSum regionalSweden) {
	this.regionalSweden = regionalSweden;
    }

    public DetailedSums withRegionalSweden(SwedenSpecificDetailedSum regionalSweden) {
	this.regionalSweden = regionalSweden;
	return this;
    }

}
