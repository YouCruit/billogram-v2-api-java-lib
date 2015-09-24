package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.event.CallbackEvent;

public class Callback {
    @Expose
    private CallbackBillogram billogram;
    @Expose
    private CallbackEvent event;
    @Expose
    private String url;
    @SerializedName("sign_key")
    @Expose
    private String signKey;
    @Expose
    private String custom;
    @Expose
    @SerializedName("callback_id")
    private String callbackId;

    public String getUrl() {
	return url;

    }
    public void setUrl(String url) {
	this.url = url;
    }

    public String getSignKey() {
	return signKey;
    }

    
    public void setSignKey(String signKey) {
	this.signKey = signKey;
    }

    public String getCustom() {
	return custom;
    }

    
    public void setCustom(String custom) {
	this.custom = custom;
    }

    public void verifySignature(String key) {

    }

    public CallbackBillogram getBillogram() {
        return billogram;
    }

    public void setBillogram(CallbackBillogram billogram) {
        this.billogram = billogram;
    }

    public CallbackEvent getEvent() {
        return event;
    }

    public void setEvent(CallbackEvent event) {
        this.event = event;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

}
