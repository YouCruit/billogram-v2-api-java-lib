package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.youcruit.billogram.objects.response.customer.BillogramCustomer;

public class SearchBillogram extends CompactBillogram {
    @Expose
    private BillogramCustomer customer = new BillogramCustomer();

    public BillogramCustomer getCustomer() {
	return customer;
    }

    public void setCustomer(BillogramCustomer customer) {
	this.customer = customer;
    }
}
