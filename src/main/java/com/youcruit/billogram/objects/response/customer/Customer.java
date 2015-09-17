package com.youcruit.billogram.objects.response.customer;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.address.DeliveryAddress;
import com.youcruit.billogram.objects.response.address.PrimaryAddress;
import com.youcruit.billogram.objects.response.billogram.CompanyType;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public class Customer extends BaseCustomer {

    @SerializedName("vat_no")
    @Expose
    private String vatNo;
    @Expose
    private PrimaryAddress address;
    @Expose
    @SerializedName("delivery_address")
    private DeliveryAddress deliveryAddress;
    @Expose(serialize = false)
    @SerializedName("created_at")
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date createdAt;
    @Expose(serialize = false)
    @SerializedName("updated_at")
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date updatedAt;
    @Expose
    @SerializedName("company_type")
    private CompanyType companyType;
    @Expose
    private String notes;
    @Expose
    private Contact contact;

    public String getVatNo() {
	return vatNo;
    }

    public void setVatNo(String vatNo) {
	this.vatNo = vatNo;
    }

    public Customer withVatNo(String vatNo) {
	this.vatNo = vatNo;
	return this;
    }


    public PrimaryAddress getAddress() {
	return address;
    }

    public void setAddress(PrimaryAddress address) {
	this.address = address;
    }

    public Customer withAddress(PrimaryAddress address) {
	this.address = address;
	return this;
    }

    public Customer withCustomerNo(Integer customerNo) {
	setCustomerNo(customerNo);
	return this;
    }

    public Customer withName(String name) {
	setName(name);
	return this;
    }

    public Customer withOrgNo(String orgNo) {
	setOrgNo(orgNo);
	return this;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Customer withDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public Customer withCompanyType(CompanyType companyType) {
        this.companyType = companyType;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer withNotes(String notes) {
        setNotes(notes);
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Customer withContact(Contact contact) {
        setContact(contact);
        return this;
    }
}
