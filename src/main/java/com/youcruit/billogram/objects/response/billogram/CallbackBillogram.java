package com.youcruit.billogram.objects.response.billogram;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.common.BillogramState;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public class CallbackBillogram {

    @Expose(serialize = false)
    private String id;
    @SerializedName("ocr_number")
    @Expose(serialize = false)
    private String ocrNumber;
    @Expose(serialize = false)
    private BillogramState state;
    @SerializedName("remaining_sum")
    @Expose(serialize = false)
    private BigDecimal remainingSum;
    @SerializedName("total_sum")
    @Expose(serialize = false)
    private BigDecimal totalSum;
    @SerializedName("attested_at")
    @Expose(serialize = false)
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date attestedAt;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getOcrNumber() {
	return ocrNumber;
    }

    public void setOcrNumber(String ocrNumber) {
	this.ocrNumber = ocrNumber;
    }

    public BillogramState getState() {
	return state;
    }

    public void setState(BillogramState state) {
	this.state = state;
    }

    public BigDecimal getRemainingSum() {
	return remainingSum;
    }

    public void setRemainingSum(BigDecimal remainingSum) {
	this.remainingSum = remainingSum;
    }

    public BigDecimal getTotalSum() {
	return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
	this.totalSum = totalSum;
    }

    public Date getAttestedAt() {
	return attestedAt;
    }

    public void setAttestedAt(Date attestedAt) {
	this.attestedAt = attestedAt;
    }
}
