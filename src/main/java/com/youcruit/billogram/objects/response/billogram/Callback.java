package com.youcruit.billogram.objects.response.billogram;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

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

    public boolean verifySignature(byte[] key) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(callbackId.getBytes("UTF-8"));
            final String md5Digest = DatatypeConverter.printHexBinary(digest.digest(key));
            return md5Digest.equals(signKey);
        } catch (UnsupportedEncodingException|NoSuchAlgorithmException e) {
            // If UTF-8 or MD5 doesn't exist, JVM is broken
            throw new Error(e);
        }
    }
}
