package com.sputnik.data.entities.payments;

import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.service_payments.ReceiptPaymentState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPaymentReceipt.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001c\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/sputnik/data/entities/payments/DataPaymentReceipt;", "", "", "uuid", "Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "state", "amount", "paymentSystem", "confirmation", "linkToken", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUuid", "Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "getAmount", "getPaymentSystem", "getConfirmation", "getLinkToken", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPaymentReceipt {
    private final String amount;
    private final String confirmation;

    @SerializedName("link_token")
    private final String linkToken;

    @SerializedName("payment_system")
    private final String paymentSystem;
    private final ReceiptPaymentState state;
    private final String uuid;

    public DataPaymentReceipt() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataPaymentReceipt)) {
            return false;
        }
        DataPaymentReceipt dataPaymentReceipt = (DataPaymentReceipt) other;
        return Intrinsics.areEqual(this.uuid, dataPaymentReceipt.uuid) && this.state == dataPaymentReceipt.state && Intrinsics.areEqual(this.amount, dataPaymentReceipt.amount) && Intrinsics.areEqual(this.paymentSystem, dataPaymentReceipt.paymentSystem) && Intrinsics.areEqual(this.confirmation, dataPaymentReceipt.confirmation) && Intrinsics.areEqual(this.linkToken, dataPaymentReceipt.linkToken);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ReceiptPaymentState receiptPaymentState = this.state;
        int iHashCode2 = (iHashCode + (receiptPaymentState == null ? 0 : receiptPaymentState.hashCode())) * 31;
        String str2 = this.amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.paymentSystem;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.confirmation;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.linkToken;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DataPaymentReceipt(uuid=" + this.uuid + ", state=" + this.state + ", amount=" + this.amount + ", paymentSystem=" + this.paymentSystem + ", confirmation=" + this.confirmation + ", linkToken=" + this.linkToken + ")";
    }

    public DataPaymentReceipt(String str, ReceiptPaymentState receiptPaymentState, String str2, String str3, String str4, String str5) {
        this.uuid = str;
        this.state = receiptPaymentState;
        this.amount = str2;
        this.paymentSystem = str3;
        this.confirmation = str4;
        this.linkToken = str5;
    }

    public /* synthetic */ DataPaymentReceipt(String str, ReceiptPaymentState receiptPaymentState, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : receiptPaymentState, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final ReceiptPaymentState getState() {
        return this.state;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaymentSystem() {
        return this.paymentSystem;
    }

    public final String getConfirmation() {
        return this.confirmation;
    }

    public final String getLinkToken() {
        return this.linkToken;
    }
}
