package com.youcruit.billogram.objects.response.error;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorData {
    @Expose
    private String message;
    @Expose
    private String field;
    @Expose
    @SerializedName("field_path")
    private List<String> fieldPath;

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public String getField() {
	return field;
    }

    public void setField(String field) {
	this.field = field;
    }

    public List<String> getFieldPath() {
        return fieldPath;
    }

    public void setFieldPath(List<String> fieldPath) {
        this.fieldPath = fieldPath;
    }
}
