package com.youcruit.billogram.objects.response.event;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public class CallbackEvent {

    @Expose
    private BillogramEvent type;
    @SerializedName("created_at")
    @Expose
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date createdAt;

    public BillogramEvent getType() {
	return type;
    }

    public void setType(BillogramEvent type) {
	this.type = type;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }
}
