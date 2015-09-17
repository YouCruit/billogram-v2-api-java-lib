package com.youcruit.billogram.objects.response.billogram;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.serializers.DateTypeAdapter;

public class Info {

    @SerializedName("reference_number")
    @Expose
    private String referenceNumber;
    @SerializedName("our_reference")
    @Expose
    private String ourReference;
    @SerializedName("order_no")
    @Expose
    private String orderNo;
    @SerializedName("shipping_date")
    @Expose
    @JsonAdapter(DateTypeAdapter.class)
    private Date shippingDate;
    @SerializedName("order_date")
    @Expose
    @JsonAdapter(DateTypeAdapter.class)
    private Date orderDate;
    @Expose
    private String message;
    @SerializedName("delivery_date")
    @Expose
    @JsonAdapter(DateTypeAdapter.class)
    private Date deliveryDate;
    @SerializedName("your_reference")
    @Expose
    private String yourReference;

    
    public String getReferenceNumber() {
	return referenceNumber;
    }

    
    public void setReferenceNumber(String referenceNumber) {
	this.referenceNumber = referenceNumber;
    }

    public Info withReferenceNumber(String referenceNumber) {
	this.referenceNumber = referenceNumber;
	return this;
    }

    
    public String getOurReference() {
	return ourReference;
    }

    
    public void setOurReference(String ourReference) {
	this.ourReference = ourReference;
    }

    public Info withOurReference(String ourReference) {
	this.ourReference = ourReference;
	return this;
    }

    
    public String getOrderNo() {
	return orderNo;
    }

    
    public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
    }

    public Info withOrderNo(String orderNo) {
	this.orderNo = orderNo;
	return this;
    }

    
    public Date getShippingDate() {
	return shippingDate;
    }

    
    public void setShippingDate(Date shippingDate) {
	this.shippingDate = shippingDate;
    }

    public Info withShippingDate(Date shippingDate) {
	this.shippingDate = shippingDate;
	return this;
    }

    
    public Date getOrderDate() {
	return orderDate;
    }

    
    public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
    }

    public Info withOrderDate(Date orderDate) {
	this.orderDate = orderDate;
	return this;
    }

    
    public String getMessage() {
	return message;
    }

    
    public void setMessage(String message) {
	this.message = message;
    }

    public Info withMessage(String message) {
	this.message = message;
	return this;
    }

    
    public Date getDeliveryDate() {
	return deliveryDate;
    }

    
    public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

    public Info withDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
	return this;
    }

    
    public String getYourReference() {
	return yourReference;
    }

    
    public void setYourReference(String yourReference) {
	this.yourReference = yourReference;
    }

    public Info withYourReference(String yourReference) {
	this.yourReference = yourReference;
	return this;
    }

}
