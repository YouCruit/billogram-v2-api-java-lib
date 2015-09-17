package com.youcruit.billogram.objects.response.error;

public enum BillogramErrors {
    MISSING_AUTH(401),
    INVALID_AUTH(403),
    PERMISSION_DENIED(403),
    NOT_FOUND(404),
    NOT_AVAILABLE_YET(404),
    METHOD_NOT_ALLOWED(500),
    MISSING_QUERY_PARAMETER(400),
    INVALID_QUERY_PARAMETER(400),
    INVALID_PARAMETER(400),
    READ_ONLY_PARAMETER(400),
    UNKNOWN_PARAMETER(400),
    INVALID_OBJECT_STATE(400);

    public final int httpStatus;
    BillogramErrors(int httpStatus) {
	this.httpStatus = httpStatus;
    }
}
