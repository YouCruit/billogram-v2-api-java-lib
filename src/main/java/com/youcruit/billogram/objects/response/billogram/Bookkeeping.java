package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookkeeping {
    @SerializedName("income_account")
    @Expose
    private String incomeAccount;
    @SerializedName("vat_account")
    @Expose
    private String vatAccount;

    public String getIncomeAccount() {
	return incomeAccount;
    }

    public void setIncomeAccount(String incomeAccount) {
	this.incomeAccount = incomeAccount;
    }

    public Bookkeeping withIncomeAccount(String incomeAccount) {
	this.incomeAccount = incomeAccount;
	return this;
    }

    public String getVatAccount() {
	return vatAccount;
    }

    public void setVatAccount(String vatAccount) {
	this.vatAccount = vatAccount;
    }

    public Bookkeeping withVatAccount(String vatAccount) {
	this.vatAccount = vatAccount;
	return this;
    }
}
