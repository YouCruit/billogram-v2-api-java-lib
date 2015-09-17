package com.youcruit.billogram.objects.request.billogram;

import com.google.gson.annotations.SerializedName;

public enum ResendMethod {
    @SerializedName("Email") EMAIL,
    @SerializedName("Letter") LETTER
}
