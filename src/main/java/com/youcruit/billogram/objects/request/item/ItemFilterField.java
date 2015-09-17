package com.youcruit.billogram.objects.request.item;

import com.youcruit.billogram.objects.request.FilterField;

public enum ItemFilterField implements FilterField {
    ITEM_NO("item_no"), TITLE("title"), DESCRIPTION("description"), PRICE("price"), BOOKKEEPING_INCOME_ACCOUNT("bookkeeping:income_account"), BOOKKEEPING_VAT_ACCOUNT("bookkeeping:vat_account");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    ItemFilterField(String fieldName) {
	this.fieldName = fieldName;
    }
}
