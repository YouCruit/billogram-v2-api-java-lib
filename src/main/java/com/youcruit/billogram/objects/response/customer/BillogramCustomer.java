package com.youcruit.billogram.objects.response.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.address.BillogramAddress;

public class BillogramCustomer extends BaseCustomer {

    @SerializedName("vat_no")
    @Expose
    private String vatNo;
    @Expose
    private String phone;
    @Expose
    private BillogramAddress address;
    @Expose
    private String email;


    public String getVatNo() {
	return vatNo;
    }

    public void setVatNo(String vatNo) {
	this.vatNo = vatNo;
    }

    public BillogramCustomer withVatNo(String vatNo) {
	this.vatNo = vatNo;
	return this;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public BillogramCustomer withPhone(String phone) {
	this.phone = phone;
	return this;
    }

    public BillogramAddress getAddress() {
	return address;
    }

    public void setAddress(BillogramAddress address) {
	this.address = address;
    }

    public BillogramCustomer withAddress(BillogramAddress address) {
	this.address = address;
	return this;
    }

    public BillogramCustomer withCustomerNo(Integer customerNo) {
	setCustomerNo(customerNo);
	return this;
    }

    public BillogramCustomer withName(String name) {
	setName(name);
	return this;
    }

    public BillogramCustomer withOrgNo(String orgNo) {
	setOrgNo(orgNo);
	return this;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public BillogramCustomer withEmail(String email) {
	setEmail(email);
	return this;
    }
}
