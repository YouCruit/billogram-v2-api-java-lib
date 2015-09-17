package com.youcruit.billogram.objects.response.item;

import java.math.BigDecimal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.billogram.RegionalSweden;
import com.youcruit.billogram.objects.response.billogram.Unit;

public class BillogramItem {
    @SerializedName("item_no")
    @Expose
    private String itemNo;
    @Expose
    private Integer count;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private Unit unit;
    @Expose
    private BigDecimal price;
    @Expose
    private Integer vat;
    @Expose
    private Integer discount;
    @SerializedName("regional_sweden")
    @Expose
    private RegionalSweden regionalSweden;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public BillogramItem withTitle(String title) {
        this.title = title;
        return this;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BillogramItem withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }


    public Integer getVat() {
        return vat;
    }


    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public BillogramItem withVat(Integer vat) {
        this.vat = vat;
        return this;
    }


    public Unit getUnit() {
        return unit;
    }


    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public BillogramItem withUnit(Unit unit) {
        this.unit = unit;
        return this;
    }


    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }

    public BillogramItem withCount(Integer count) {
        this.count = count;
        return this;
    }


    public Integer getDiscount() {
        return discount;
    }


    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BillogramItem withDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }


    public String getItemNo() {
        return itemNo;
    }


    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public BillogramItem withItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public BillogramItem withDescription(String description) {
        this.description = description;
        return this;
    }


    public RegionalSweden getRegionalSweden() {
        return regionalSweden;
    }


    public void setRegionalSweden(RegionalSweden regionalSweden) {
        this.regionalSweden = regionalSweden;
    }

    public BillogramItem withRegionalSweden(RegionalSweden regionalSweden) {
        this.regionalSweden = regionalSweden;
        return this;
    }
}
