package com.youcruit.billogram.objects.request.billogram;

import com.google.gson.annotations.SerializedName;

public enum SendMethod {
    @SerializedName("Email") EMAIL,
    @SerializedName("SMS") SMS,
    @SerializedName("Letter") LETTER,
    @SerializedName("Email+Letter") EMAIL_AND_LETTER,
    @SerializedName("SMS+Letter") SMS_AND_LETTER,
    @SerializedName("Efaktura") EFAKTURA,
    ;
}
