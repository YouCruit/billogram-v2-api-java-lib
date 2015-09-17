package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.SerializedName;

public enum Unit {
    // units of piece goods
    @SerializedName("unit")UNIT,
    // hours of work/service
    @SerializedName("hour")HOUR,
    // days of service/rent
    @SerializedName("day")DAY,
    // months of service
    @SerializedName("month")MONTH,
    // kilogram product sold
    @SerializedName("kg")KG,
    // gram product sold
    @SerializedName("gram")GRAM,
    // kwh sold
    @SerializedName("kwh")KWH,
    // ton product sold
    @SerializedName("ton")TON,
    // meters product sold
    @SerializedName("meter")METER,
    // millimeters product sold
    @SerializedName("mm")MM,
    // kilometer product sold, or distance travelled
    @SerializedName("km")KM,
    // square meters product sold
    @SerializedName("m2")M2,
    // cubic meters product sold
    @SerializedName("m3")M3,
    // liters product sold
    @SerializedName("litre")LITRE,
}
