package com.youcruit.billogram.objects.request.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PdfAttachment extends PdfFile {
    @Expose
    @SerializedName("filename")
    private String fileName;

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }
}
