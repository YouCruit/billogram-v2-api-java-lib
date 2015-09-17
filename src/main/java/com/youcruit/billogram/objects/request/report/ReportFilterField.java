package com.youcruit.billogram.objects.request.report;

import com.youcruit.billogram.objects.request.FilterField;

public enum ReportFilterField implements FilterField {
    FILENAME("filename");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    ReportFilterField(String fieldName) {
	this.fieldName = fieldName;
    }
}
