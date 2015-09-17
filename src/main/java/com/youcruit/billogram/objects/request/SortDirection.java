package com.youcruit.billogram.objects.request;

public enum SortDirection {
    ASCENDING("asc"),
    DESCENDING("desc");

    public final String directionName;

    SortDirection(String directionName) {
        this.directionName = directionName;
    }
}
