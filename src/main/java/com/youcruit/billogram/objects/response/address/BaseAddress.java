package com.youcruit.billogram.objects.response.address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

abstract class BaseAddress {

    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private String zipcode;
    @Expose
    private String careof;
    @SerializedName("street_address")
    @Expose
    private String streetAddress;


    public String getCity() {
	return city;
    }


    public void setCity(String city) {
	this.city = city;
    }

    public String getCountry() {
	return country;
    }


    public void setCountry(String country) {
	this.country = country;
    }

    public String getZipcode() {
	return zipcode;
    }


    public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
    }

    public String getCareof() {
	return careof;
    }

    public void setCareof(String careof) {
	this.careof = careof;
    }

    public String getStreetAddress() {
	return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
    }
}
