package com.sputnik.domain.entities.service_payments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DomainPaymentReceipt.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/sputnik/domain/entities/service_payments/DomainPaymentReceipt;", "", "", "uuid", "Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "state", "amount", "paymentSystem", "confirmation", "linkToken", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "getState", "()Lcom/sputnik/domain/entities/service_payments/ReceiptPaymentState;", "getAmount", "getPaymentSystem", "getConfirmation", "getLinkToken", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DomainPaymentReceipt {
    private final String amount;
    private final String confirmation;
    private final String linkToken;
    private final String paymentSystem;
    private final ReceiptPaymentState state;
    private final String uuid;

    public DomainPaymentReceipt() {
        this(null, null, null, null, null, null, 63, null);
    }

    public DomainPaymentReceipt(String str, ReceiptPaymentState receiptPaymentState, String str2, String str3, String str4, String str5) {
        this.uuid = str;
        this.state = receiptPaymentState;
        this.amount = str2;
        this.paymentSystem = str3;
        this.confirmation = str4;
        this.linkToken = str5;
    }

    public /* synthetic */ DomainPaymentReceipt(String str, ReceiptPaymentState receiptPaymentState, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : receiptPaymentState, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getLinkToken() {
        return this.linkToken;
    }
}
