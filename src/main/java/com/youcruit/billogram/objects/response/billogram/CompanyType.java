package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.SerializedName;

public enum CompanyType {
    @SerializedName("business") BUSINESS,
    @SerializedName("individual") INDIVIDUAL,
    @SerializedName("foreign business") FOREIGN_BUSINESS,
    @SerializedName("foreign individual") FOREIGN_INDIVIDUAL
}
