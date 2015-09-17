package com.youcruit.billogram.objects.response.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalCountMeta {
    @Expose
    @SerializedName("total_count")
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
