package com.youcruit.billogram.objects.response.callback;

import static java.util.Locale.US;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

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

    public String getCustom() {
	return custom;
    }

    public void setCustom(String custom) {
	this.custom = custom;
    }

    public String getSignature() {
	return signature;
    }

    public void setSignature(String signature) {
	this.signature = signature;
    }

    public boolean verifySignature(byte[] key) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(callbackId.getBytes("UTF-8"));
            final String md5Digest = DatatypeConverter.printHexBinary(digest.digest(key)).toLowerCase(US);
            return md5Digest.equals(signature.toLowerCase(US));
        } catch (UnsupportedEncodingException |NoSuchAlgorithmException e) {
            // If UTF-8 or MD5 doesn't exist, JVM is broken
            throw new Error(e);
        }
    }
}