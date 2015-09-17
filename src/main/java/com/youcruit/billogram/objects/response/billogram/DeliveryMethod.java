package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.SerializedName;

public enum DeliveryMethod {
    @SerializedName("Email+Letter") EMAIL_AND_LETTER,
    @SerializedName("Email") EMAIL,
    @SerializedName("LETTER") LETTER;
}
