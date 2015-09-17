package com.youcruit.billogram.objects.response.common;

import com.google.gson.annotations.SerializedName;

public enum BillogramState {
    @SerializedName("Unattested")UNATTESTED,
    @SerializedName("Sending")SENDING,
    @SerializedName("Unpaid")UNPAID,
    @SerializedName("CollectorEnded")COLLECTORENDED,
    @SerializedName("Collecting")COLLECTING,
    @SerializedName("Collection")COLLECTION,
    @SerializedName("Factoring")FACTORING,
    @SerializedName("Sold")SOLD,
    @SerializedName("Ended")ENDED,
    @SerializedName("Paid")PAID,
    @SerializedName("Credited")CREDITED,
    @SerializedName("FactoringDenied")FACTORINGDENIED,
    @SerializedName("PartlyPaid")PARTLYPAID,
    @SerializedName("Overdue")OVERDUE,
    @SerializedName("Reminder_1")REMINDER_1,
    @SerializedName("Reminder_2")REMINDER_2,
    @SerializedName("Reminder_3")REMINDER_3,
    @SerializedName("Reminder_Many")REMINDER_MANY,
    @SerializedName("Deleted")DELETED
}
