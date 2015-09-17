package com.youcruit.billogram.objects.response.report;

import com.google.gson.annotations.SerializedName;

public enum ReportType {
    @SerializedName("sie4") SIE4,
    @SerializedName("sie4 report") SIE4_REPORT,
    @SerializedName("debtors ledger journal") DEBTORS_LEDGER_JOURNAL;
}
