package com.youcruit.billogram.objects.response.error;

import com.google.gson.annotations.Expose;

public class ApiError {
    @Expose
    private BillogramErrors status;
    @Expose
    private ErrorData data;

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
}
