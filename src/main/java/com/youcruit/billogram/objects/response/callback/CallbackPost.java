package com.youcruit.billogram.objects.response.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.billogram.CallbackBillogram;
import com.youcruit.billogram.objects.response.event.CallbackEvent;

public class CallbackPost {

    @Expose
    private CallbackBillogram billogram = new CallbackBillogram();
    @Expose
    private CallbackEvent event = new CallbackEvent();
    @SerializedName("callback_id")
    @Expose
    private String callbackId;
    @Expose
    private String custom;
    @Expose
    private String signature;

    public CallbackBillogram getBillogram() {
	return billogram;
    }

    public void setBillogram(CallbackBillogram billogram) {
	this.billogram = billogram;
    }

    public CallbackPost withBillogram(CallbackBillogram billogram) {
	this.billogram = billogram;
	return this;
    }

    public CallbackEvent getEvent() {
	return event;
    }

    public void setEvent(CallbackEvent event) {
	this.event = event;
    }

    public CallbackPost withEvent(CallbackEvent event) {
	this.event = event;
	return this;
    }

    public String getCallbackId() {
	return callbackId;
    }

    public void setCallbackId(String callbackId) {
	this.callbackId = callbackId;
    }

    public CallbackPost withCallbackId(String callbackId) {
	this.callbackId = callbackId;
	return this;
    }

    public String getCustom() {
	return custom;
    }

    public void setCustom(String custom) {
	this.custom = custom;
    }

    public CallbackPost withCustom(String custom) {
	this.custom = custom;
	return this;
    }

    public String getSignature() {
	return signature;
    }

    public void setSignature(String signature) {
	this.signature = signature;
    }

    public CallbackPost withSignature(String signature) {
	this.signature = signature;
	return this;
    }
}