package com.youcruit.billogram.objects.response.event;

import com.google.gson.annotations.SerializedName;

public enum BillogramEvent {
    @SerializedName("BillogramCreated")BILLOGRAM_CREATED,
    @SerializedName("BillogramSent")BILLOGRAM_SENT,
    @SerializedName("Payment")PAYMENT,
    @SerializedName("ReminderSent")REMINDER_SENT,
    @SerializedName("Overdue")OVERDUE,
    @SerializedName("Credit")CREDIT,
    @SerializedName("BillogramEnded")BILLOGRAM_ENDED,
    @SerializedName("Resent")RESENT,
    @SerializedName("DeliveryAccepted")DELIVERY_ACCEPTED,
    @SerializedName("DeliveryFailed")DELIVERY_FAILED,
    @SerializedName("EmailNotAccepted")EMAIL_NOT_ACCEPTED,
    @SerializedName("LetterSent")LETTER_SENT,
    @SerializedName("OverpaymentAdjustment")OVERPAYMENT_ADJUSTMENT,
    @SerializedName("InterestStarted")INTEREST_STARTED,
    @SerializedName("CustomerMessage")CUSTOMER_MESSAGE,
    @SerializedName("CreditorMessage")CREDITOR_MESSAGE,
    @SerializedName("DataChange")DATA_CHANGE,
    @SerializedName("InvoiceSent")INVOICE_SENT,
    @SerializedName("Collection")COLLECTION,
    @SerializedName("CollectorPayment")COLLECTOR_PAYMENT,
    @SerializedName("CollectionEnded")COLLECTION_ENDED,
    @SerializedName("CollectionCancelled")COLLECTION_CANCELLED,
    @SerializedName("CollectionStatusUpdate")COLLECTION_STATUS_UPDATE,
    @SerializedName("FactoringRequest")FACTORING_REQUEST,
    @SerializedName("BillogramSold")BILLOGRAM_SOLD,
    @SerializedName("FactoringCreditRequest")FACTORING_CREDIT_REQUEST,
    @SerializedName("FactoringDenied")FACTORING_DENIED,
    @SerializedName("FactoringCreditRequestDenied")FACTORING_CREDIT_REQUEST_DENIED,
    @SerializedName("Writeoff")WRITEOFF,
    @SerializedName("NewInvoicePDF")NEW_INVOICE_PDF,
    @SerializedName("Deleted")DELETED,

}
