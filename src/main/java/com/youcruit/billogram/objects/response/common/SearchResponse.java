package com.youcruit.billogram.objects.response.common;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class SearchResponse<T> {

    @Expose
    private List<T> data = new ArrayList<>();
    @Expose
    private TotalCountMeta meta = new TotalCountMeta();

    public List<T> getData() {
	return data;
    }

    public void setData(List<T> data) {
	this.data = data;
    }

    public TotalCountMeta getMeta() {
	return meta;
    }

    public void setMeta(TotalCountMeta meta) {
	this.meta = meta;
    }

}
