package com.youcruit.billogram.objects.request.billogram;

import javax.xml.bind.DatatypeConverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PdfResponse {
    @Expose
    @SerializedName("file_type")
    private String fileType;
    @Expose
    private String content;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] asByteArray() {
        return DatatypeConverter.parseBase64Binary(content);
    }
}
