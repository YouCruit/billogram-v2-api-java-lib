package com.youcruit.billogram.objects.response.error;

import com.google.gson.annotations.Expose;

public class ApiError {
    @Expose
    private BillogramErrors status;
    @Expose
    private ErrorData data;
    @Expose(serialize = false, deserialize =  false)
    private int httpStatusCode;

    public BillogramErrors getStatus() {
	return status;
    }

    public void setStatus(BillogramErrors status) {
	this.status = status;
    }

    public ErrorData getData() {
	return data;
    }

    public void setData(ErrorData data) {
	this.data = data;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
