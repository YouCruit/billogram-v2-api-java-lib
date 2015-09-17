package com.youcruit.billogram.objects.response.address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrimaryAddress extends BaseAddress {
    @Expose
    @SerializedName("use_careof_as_attention")
    private Boolean useCareofAsAttention;

    public Boolean getUseCareofAsAttention() {
	return useCareofAsAttention;
    }

    public void setUseCareofAsAttention(Boolean useCareofAsAttention) {
	this.useCareofAsAttention = useCareofAsAttention;
    }

    public PrimaryAddress withUseCareofAsAttention(Boolean useCareofAsAttention) {
	setUseCareofAsAttention(useCareofAsAttention);
	return this;
    }

    public PrimaryAddress withCity(String city) {
	setCity(city);
	return this;
    }

    public PrimaryAddress withCareof(String careof) {
	setCareof(careof);
	return this;
    }

    public PrimaryAddress withCountry(String country) {
	setCountry(country);
	return this;
    }

    public PrimaryAddress withZipcode(String zipcode) {
	setZipcode(zipcode);
	return this;
    }

    public PrimaryAddress withStreetAddress(String streetAddress) {
	setStreetAddress(streetAddress);
	return this;
    }
}
