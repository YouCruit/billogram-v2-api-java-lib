package com.youcruit.billogram.objects.request;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Search<F extends FilterField, O extends OrderField> {
    private int page = 1;
    @SerializedName("page_size")
    private int pageSize = 10;
    @SerializedName("filter_type")
    private FilterType filterType;
    @SerializedName("filter_field")
    private String filterField;
    @SerializedName("filter_value")
    private String filterValue;
    @SerializedName("order_field")
    private String orderField;
    @SerializedName("order_direction")
    private SortDirection orderDirection;

    public Map<String, String> toQueryParameters() {
	Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("page", String.valueOf(page));
        queryParameters.put("page_size", String.valueOf(pageSize));
        if (filterType != null) {
            queryParameters.put("filter_type", filterType.fieldName);
            queryParameters.put("filter_field", filterField);
            queryParameters.put("filter_value", filterValue);
        }

        if (orderDirection != null) {
            queryParameters.put("order_direction", orderDirection.directionName);
            queryParameters.put("order_field", orderField);
        }
	return queryParameters;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    public Search withPage(int page) {
	this.page = page;
	return this;
    }

    public Search withPageSize(int pageSize) {
	this.pageSize = pageSize;
	return this;
    }

    public Search withFilter(FilterType filterType, FilterField filterField, String filterValue) {
	this.filterType = filterType;
	this.filterField = filterField.getFieldName();
	this.filterValue = filterValue;
	return this;
    }

    public Search withOrder(SortDirection orderDirection, OrderField orderField) {
	this.orderDirection = orderDirection;
	this.orderField = orderField.getFieldName();
	return this;
    }

    public FilterType getFilterType() {
	return filterType;
    }

    public String getFilterField() {
	return filterField;
    }

    public String getFilterValue() {
	return filterValue;
    }

    public String getOrderField() {
	return orderField;
    }

    public SortDirection getOrderDirection() {
	return orderDirection;
    }
}
