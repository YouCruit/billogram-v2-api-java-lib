package com.youcruit.billogram.objects.request.event;

import com.youcruit.billogram.objects.request.FilterField;

public enum EventFilterField implements FilterField {
    BILLOGRAM_ID("billogram_id");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    EventFilterField(String fieldName) {
	this.fieldName = fieldName;
    }
}
