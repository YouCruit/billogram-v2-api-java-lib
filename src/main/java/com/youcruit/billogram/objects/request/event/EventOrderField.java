package com.youcruit.billogram.objects.request.event;

import com.youcruit.billogram.objects.request.OrderField;

public enum EventOrderField implements OrderField {
    CREATED_AT("created_at");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    EventOrderField(String fieldName) {
	this.fieldName = fieldName;
    }
}

