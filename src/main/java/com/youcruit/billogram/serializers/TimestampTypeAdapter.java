package com.youcruit.billogram.serializers;

import java.util.TimeZone;

public class TimestampTypeAdapter extends GenericDateTypeAdapter{
    public TimestampTypeAdapter() {
	super("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }
}
