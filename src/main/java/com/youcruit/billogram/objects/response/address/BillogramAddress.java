package com.youcruit.billogram.objects.response.address;

import com.google.gson.annotations.Expose;

public class BillogramAddress extends BaseAddress {
    @Expose
    private String attention;


    public String getAttention() {
	return attention;
    }

    public void setAttention(String attention) {
	this.attention = attention;
    }

    public BillogramAddress withAttention(String attention) {
	setAttention(attention);
	return this;
    }

    public BillogramAddress withCity(String city) {
	setCity(city);
	return this;
    }

    public BillogramAddress withCareof(String careof) {
	setCareof(careof);
	return this;
    }

    public BillogramAddress withCountry(String country) {
	setCountry(country);
	return this;
    }

    public BillogramAddress withZipcode(String zipcode) {
	setZipcode(zipcode);
	return this;
    }

    public BillogramAddress withStreetAddress(String streetAddress) {
	setStreetAddress(streetAddress);
	return this;
    }
}
