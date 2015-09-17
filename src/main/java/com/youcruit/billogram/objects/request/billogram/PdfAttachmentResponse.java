package com.youcruit.billogram.objects.request.billogram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PdfAttachmentResponse extends PdfResponse {
    @Expose
    @SerializedName("file_name")
    private String fileName;

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }
}
