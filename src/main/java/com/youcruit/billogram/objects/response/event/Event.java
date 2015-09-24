package com.youcruit.billogram.objects.response.event;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.youcruit.billogram.objects.response.billogram.EventsData;

public class Event extends CallbackEvent {
    @Expose
    private EventsData data = new EventsData();

    public EventsData getData() {
	return data;
    }

    public void setData(EventsData data) {
	this.data = data;
    }

    public CallbackEvent withData(EventsData data) {
	this.data = data;
	return this;
    }

    public CallbackEvent withCreatedAt(Date createdAt) {
	setCreatedAt(createdAt);
	return this;
    }

    public CallbackEvent withType(BillogramEvent type) {
	setType(type);
	return this;
    }
}
