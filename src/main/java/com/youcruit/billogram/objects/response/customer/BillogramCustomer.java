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

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public BillogramAddress getAddress() {
	return address;
    }

    public void setAddress(BillogramAddress address) {
	this.address = address;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
