package com.youcruit.billogram.objects.request.report;

import com.youcruit.billogram.objects.request.OrderField;

public enum ReportOrderField implements OrderField {
    CREATED_AT("created_at"),
    FILENAME("filename");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    ReportOrderField(String fieldName) {
	this.fieldName = fieldName;
    }
}

