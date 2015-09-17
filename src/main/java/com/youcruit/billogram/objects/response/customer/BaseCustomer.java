package com.youcruit.billogram.objects.response.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class BaseCustomer {
    @Expose
    private String name;
    @SerializedName("org_no")
    @Expose
    private String orgNo;
    @SerializedName("customer_no")
    @Expose
    private Integer customerNo;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getCustomerNo() {
	return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
	this.customerNo = customerNo;
    }

    public String getOrgNo() {
	return orgNo;
    }

    public void setOrgNo(String orgNo) {
	this.orgNo = orgNo;
    }
}
