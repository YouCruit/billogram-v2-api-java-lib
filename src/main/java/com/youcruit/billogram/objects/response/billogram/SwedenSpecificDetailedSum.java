package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SwedenSpecificDetailedSum {

    @SerializedName("rotavdrag_sum")
    @Expose
    private Integer rotavdragSum;

    public Integer getRotavdragSum() {
	return rotavdragSum;
    }

    public void setRotavdragSum(Integer rotavdragSum) {
	this.rotavdragSum = rotavdragSum;
    }

    public SwedenSpecificDetailedSum withRotavdragSum(Integer rotavdragSum) {
	this.rotavdragSum = rotavdragSum;
	return this;
    }

}