package com.youcruit.billogram.objects.request;

public enum FilterType {
    // Exact match for the given field
    FIELD("field"),
    // Match a prefix for the given field
    FIELD_PREFIX("field-prefix"),
    // Match any substring in the given field
    FIELD_SEARCH("field-search"),
    // Perform a "special" search(?)
    SPECIAL("special");

    public final String fieldName;

    FilterType(String fieldName) {
        this.fieldName = fieldName;
    }
}
