package com.youcruit.billogram.exception;

import java.io.IOException;

import com.youcruit.billogram.objects.response.error.ApiError;

public class ApiException extends IOException {
    private static final long serialVersionUID = -744741081235948125L;

    private final ApiError error;

    public ApiException(ApiError error) {
        super(getString(error));
        this.error = error;
    }

    private static String getString(ApiError error) {
        final StringBuilder sb = new StringBuilder();
        sb.append(error.getStatus().name()).append('(').append(error.getStatus().httpStatus).append(") ").append(error.getData().getMessage());
        final String fieldName = error.getData().getField();
        if (fieldName != null && !fieldName.trim().isEmpty()) {
            sb.append(" for field: '").append(fieldName). append("' and path: '").append(error.getData().getFieldPath()).append("'");
        }
        return sb.toString();
    }

    public ApiError getError() {
        return error;
    }
}
