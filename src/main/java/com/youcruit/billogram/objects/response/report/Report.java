package com.youcruit.billogram.objects.response.report;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public class Report {
    @Expose(serialize = false)
    private String filename;
    @Expose(serialize = false)
    private ReportType type;
    @Expose(serialize = false)
    @SerializedName("file_type")
    private  String mimeType;
    @Expose(serialize = false)
    private String info;
    @Expose(serialize = false)
    @SerializedName("created_at")
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date createdAt;
    @Expose(serialize = false)
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date content;

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public ReportType getType() {
	return type;
    }

    public void setType(ReportType type) {
	this.type = type;
    }

    public String getMimeType() {
	return mimeType;
    }

    public void setMimeType(String mimeType) {
	this.mimeType = mimeType;
    }

    public String getInfo() {
	return info;
    }

    public void setInfo(String info) {
	this.info = info;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public Date getContent() {
	return content;
    }

    public void setContent(Date content) {
	this.content = content;
    }
}
