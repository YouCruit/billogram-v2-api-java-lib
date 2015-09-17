package com.youcruit.billogram.serializers;

import java.util.TimeZone;

public class DateTypeAdapter extends GenericDateTypeAdapter {
    public DateTypeAdapter() {
	super("yyyy-MM-dd", TimeZone.getTimeZone("UTC"));
    }
}
