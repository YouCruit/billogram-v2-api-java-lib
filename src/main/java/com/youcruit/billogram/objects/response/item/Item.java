package com.youcruit.billogram.objects.response.item;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.youcruit.billogram.objects.response.billogram.Bookkeeping;
import com.youcruit.billogram.objects.response.billogram.RegionalSweden;
import com.youcruit.billogram.objects.response.billogram.Unit;
import com.youcruit.billogram.serializers.TimestampTypeAdapter;

public class Item extends BillogramItem {

    @Expose
    private Bookkeeping bookkeeping = new Bookkeeping();
    @Expose
    @SerializedName("created_at")
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date createdAt;
    @SerializedName("updated_at")
    @JsonAdapter(TimestampTypeAdapter.class)
    private Date updatedAt;

    
    public Bookkeeping getBookkeeping() {
        return bookkeeping;
    }

    public void setBookkeeping(Bookkeeping bookkeeping) {
        this.bookkeeping = bookkeeping;
    }

    @Override
    public Item withCount(Integer count) {
        return (Item) super.withCount(count);
    }

    @Override
    public Item withDescription(String description) {
        return (Item) super.withDescription(description);
    }

    @Override
    public Item withDiscount(BigDecimal discount) {
        return (Item) super.withDiscount(discount);
    }

    @Override
    public Item withItemNo(String itemNo) {
        return (Item) super.withItemNo(itemNo);
    }

    @Override
    public Item withPrice(BigDecimal price) {
        return (Item) super.withPrice(price);
    }

    @Override
    public Item withRegionalSweden(RegionalSweden regionalSweden) {
        return (Item) super.withRegionalSweden(regionalSweden);
    }

    @Override
    public Item withTitle(String title) {
        return (Item) super.withTitle(title);
    }

    @Override
    public Item withUnit(Unit unit) {
        return (Item) super.withUnit(unit);
    }

    @Override
    public Item withVat(Integer vat) {
        return (Item) super.withVat(vat);
    }
}

