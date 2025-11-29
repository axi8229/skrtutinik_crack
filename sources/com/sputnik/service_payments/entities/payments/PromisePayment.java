package com.sputnik.service_payments.entities.payments;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PromisePayment.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/sputnik/service_payments/entities/payments/PromisePayment;", "", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "accrual", "Lcom/sputnik/service_payments/entities/payments/PromisedPayment;", "promisedPayment", "<init>", "(Lcom/sputnik/service_payments/entities/payments/PaymentHistory;Lcom/sputnik/service_payments/entities/payments/PromisedPayment;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "getAccrual", "()Lcom/sputnik/service_payments/entities/payments/PaymentHistory;", "Lcom/sputnik/service_payments/entities/payments/PromisedPayment;", "getPromisedPayment", "()Lcom/sputnik/service_payments/entities/payments/PromisedPayment;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PromisePayment {
    private final PaymentHistory accrual;
    private final PromisedPayment promisedPayment;

    public PromisePayment() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromisePayment)) {
            return false;
        }
        PromisePayment promisePayment = (PromisePayment) other;
        return Intrinsics.areEqual(this.accrual, promisePayment.accrual) && Intrinsics.areEqual(this.promisedPayment, promisePayment.promisedPayment);
    }

    public int hashCode() {
        PaymentHistory paymentHistory = this.accrual;
        int iHashCode = (paymentHistory == null ? 0 : paymentHistory.hashCode()) * 31;
        PromisedPayment promisedPayment = this.promisedPayment;
        return iHashCode + (promisedPayment != null ? promisedPayment.hashCode() : 0);
    }

    public String toString() {
        return "PromisePayment(accrual=" + this.accrual + ", promisedPayment=" + this.promisedPayment + ")";
    }

    public PromisePayment(PaymentHistory paymentHistory, PromisedPayment promisedPayment) {
        this.accrual = paymentHistory;
        this.promisedPayment = promisedPayment;
    }

    public /* synthetic */ PromisePayment(PaymentHistory paymentHistory, PromisedPayment promisedPayment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : paymentHistory, (i & 2) != 0 ? null : promisedPayment);
    }

    public final PromisedPayment getPromisedPayment() {
        return this.promisedPayment;
    }
}
