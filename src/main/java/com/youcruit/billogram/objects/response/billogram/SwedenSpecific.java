package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SwedenSpecific {

    @Expose
    private Integer rotavdrag;
    @SerializedName("rotavdrag_personal_number")
    @Expose
    private String rotavdragPersonalNumber;
    @SerializedName("rotavdrag_description")
    @Expose
    private String rotavdragDescription;
    @SerializedName("reversed_vat")
    @Expose
    private Boolean reversedVat;

    public Integer getRotavdrag() {
	return rotavdrag;
    }

    public void setRotavdrag(Integer rotavdrag) {
	this.rotavdrag = rotavdrag;
    }

    public SwedenSpecific withRotavdrag(Integer rotavdrag) {
	this.rotavdrag = rotavdrag;
	return this;
    }

    public String getRotavdragPersonalNumber() {
	return rotavdragPersonalNumber;
    }

    public void setRotavdragPersonalNumber(String rotavdragPersonalNumber) {
	this.rotavdragPersonalNumber = rotavdragPersonalNumber;
    }

    public SwedenSpecific withRotavdragPersonalNumber(String rotavdragPersonalNumber) {
	this.rotavdragPersonalNumber = rotavdragPersonalNumber;
	return this;
    }

    public String getRotavdragDescription() {
	return rotavdragDescription;
    }

    public void setRotavdragDescription(String rotavdragDescription) {
	this.rotavdragDescription = rotavdragDescription;
    }

    public SwedenSpecific withRotavdragDescription(String rotavdragDescription) {
	this.rotavdragDescription = rotavdragDescription;
	return this;
    }

    public Boolean getReversedVat() {
	return reversedVat;
    }

    public void setReversedVat(Boolean reversedVat) {
	this.reversedVat = reversedVat;
    }

    public SwedenSpecific withReversedVat(Boolean reversedVat) {
	this.reversedVat = reversedVat;
	return this;
    }

}
