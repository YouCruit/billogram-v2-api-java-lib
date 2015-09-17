package com.youcruit.billogram.objects.request.item;

import com.youcruit.billogram.objects.request.OrderField;

public enum ItemOrderField implements OrderField {
    ITEM_NO("item_no"),
    TITLE("title"),
    PRICE("price"),
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    ItemOrderField(String fieldName) {
	this.fieldName = fieldName;
    }
}

