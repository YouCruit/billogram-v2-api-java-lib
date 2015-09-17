package com.youcruit.billogram.objects.request.billogram;

import com.youcruit.billogram.objects.request.OrderField;

public enum BillogramOrderField implements OrderField {
    INVOICE_NO("invoice_no"), INVOICE_DATE("invoice_date"), DUE_DATE("due_date"), CUSTOMER_NAME("customer:name"), CUSTOMER_NO("customer:customer_no"),
    STATE("state");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    BillogramOrderField(String fieldName) {
	this.fieldName = fieldName;
    }
}
