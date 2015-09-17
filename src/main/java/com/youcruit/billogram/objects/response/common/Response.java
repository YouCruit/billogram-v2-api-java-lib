package com.youcruit.billogram.objects.response.common;

import com.google.gson.annotations.Expose;

public class Response<T> {
    @Expose
    private T data;

    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }
}
