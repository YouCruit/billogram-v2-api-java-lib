package com.youcruit.billogram.objects.request.customer;

import com.youcruit.billogram.objects.request.OrderField;

public enum CustomerOrderField implements OrderField {
    CUSTOMER_NO("customer_no"),
    CUSTOMER_NAME("name"),
    CUSTOMER_ORD_NO("org_no"),
    CONTACT_EMAIL("contact:email"),
    ADDRESS_ZIPCODE("address:zipcode"),
    ADDRESS_CITY("address:city"),
    DELIVERY_ADDRESS_NAME("delivery_address:name"),
    DELIVERY_ADDRESS_ZIPCODE("delivery_address:zipcode"),
    DELIVERY_ADDRESS_CITY("address:city"),
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    CustomerOrderField(String fieldName) {
	this.fieldName = fieldName;
    }
}
