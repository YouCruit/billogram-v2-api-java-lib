package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.SerializedName;

public enum BillogramFlag {
    @SerializedName("partly paid") PARTLY_PAID,
    @SerializedName("new message") NEW_MESSAGE,
    @SerializedName("new event") NEW_EVENT,
    @SerializedName("message") MESSAGE,
    @SerializedName("delivery failed") DELIVERY_FAILED,
    @SerializedName("not delivered") NOT_DELIVERED,
    @SerializedName("paid on collection") PAID_ON_COLLECTION,
    @SerializedName("factoring denied") FACTORING_DENIED,
    @SerializedName("rot-deduction") ROT_REDUCTION
}
