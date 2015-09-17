package com.youcruit.billogram.objects.response.customer;

import com.google.gson.annotations.Expose;

public class Contact {
    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String phone;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Contact withName(String name) {
	setName(name);
	return this;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Contact withEmail(String email) {
	setEmail(email);
	return this;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public Contact withPhone(String phone) {
	setPhone(phone);
	return this;
    }
}
