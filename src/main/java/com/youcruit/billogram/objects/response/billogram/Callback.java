package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Callback {

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

    public Callback withUrl(String url) {
	this.url = url;
	return this;
    }

    
    public String getSignKey() {
	return signKey;
    }

    
    public void setSignKey(String signKey) {
	this.signKey = signKey;
    }

    public Callback withSignKey(String signKey) {
	this.signKey = signKey;
	return this;
    }

    
    public String getCustom() {
	return custom;
    }

    
    public void setCustom(String custom) {
	this.custom = custom;
    }

    public Callback withCustom(String custom) {
	this.custom = custom;
	return this;
    }

}
