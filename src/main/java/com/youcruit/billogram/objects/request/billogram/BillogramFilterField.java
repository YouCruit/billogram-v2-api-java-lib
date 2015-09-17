package com.youcruit.billogram.objects.request.billogram;

import com.youcruit.billogram.objects.request.FilterField;

public enum BillogramFilterField implements FilterField{
    ID("id"), INVOICE_NO("invoice_no"), INVOICE_DATE("invoice_date"), DUE_DATE("due_date"), OCR_NUMBER("ocr_number"), CUSTOMER_NAME("customer:name"), CUSTOMER_NO("customer:customer_no"),
    CUSTOMER_ORD_NO("customer:org_no"), STATE("state");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    BillogramFilterField(String fieldName) {
	this.fieldName = fieldName;
    }
}
