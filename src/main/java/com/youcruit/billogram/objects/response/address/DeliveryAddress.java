package com.youcruit.billogram.objects.response.address;

import com.google.gson.annotations.Expose;

public class DeliveryAddress extends BaseAddress {
    @Expose
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public DeliveryAddress withName(String name) {
	setName(name);
	return this;
    }

    public DeliveryAddress withCity(String city) {
        setCity(city);
        return this;
    }

    public DeliveryAddress withCareof(String careof) {
        setCareof(careof);
        return this;
    }

    public DeliveryAddress withCountry(String country) {
        setCountry(country);
        return this;
    }

    public DeliveryAddress withZipcode(String zipcode) {
        setZipcode(zipcode);
        return this;
    }

    public DeliveryAddress withStreetAddress(String streetAddress) {
        setStreetAddress(streetAddress);
        return this;
    }

}
