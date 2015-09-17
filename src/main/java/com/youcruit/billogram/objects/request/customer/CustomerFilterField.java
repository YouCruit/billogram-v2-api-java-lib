package com.youcruit.billogram.objects.request.customer;

import com.youcruit.billogram.objects.request.FilterField;

public enum CustomerFilterField implements FilterField{
    CUSTOMER_NO("customer_no"),
    CUSTOMER_NAME("name"),
    NOTES("notes"),
    CUSTOMER_ORD_NO("org_no"),
    COMPANY_TYPE("company_type"),
    CONTACT_NAME("contact:name"),
    CONTACT_EMAIL("contact:email"),
    CONTACT_PHONE("contact:phone"),
    ADDRESS_STREET("address:street_address"),
    ADDRESS_CAREFOF("address:careof"),
    ADDRESS_ZIPCODE("address:zipcode"),
    ADDRESS_CITY("address:city"),
    ADDRESS_COUNTRY("address:country"),
    DELIVERY_ADDRESS_NAME("delivery_address:name"),
    DELIVERY_ADDRESS_STREET("delivery_address:street_address"),
    DELIVERY_ADDRESS_CAREFOF("delivery_address:careof"),
    DELIVERY_ADDRESS_ZIPCODE("delivery_address:zipcode"),
    DELIVERY_ADDRESS_CITY("address:city"),
    DELIVERY_ADDRESS_COUNTRY("delivery_address:country");

    private final String fieldName;

    @Override
    public String getFieldName() {
	return fieldName;
    }

    CustomerFilterField(String fieldName) {
	this.fieldName = fieldName;
    }
}
