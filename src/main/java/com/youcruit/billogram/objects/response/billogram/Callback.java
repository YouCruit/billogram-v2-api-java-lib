package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.event.CallbackEvent;

public class Callback {
    @Expose
    CallbackBillogram billogram;
    @Expose
    CallbackEvent event;
    @Expose
    private String url;
    @SerializedName("sign_key")
    @Expose
    private String signKey;
    @Expose
    private String custom;

    
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
}
