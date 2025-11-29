package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class N {
    public final String a;
    public final W b;
    public final t0 c;

    public N(String paymentId, W status, t0 userPaymentProcess) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(userPaymentProcess, "userPaymentProcess");
        this.a = paymentId;
        this.b = status;
        this.c = userPaymentProcess;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n = (N) obj;
        return Intrinsics.areEqual(this.a, n.a) && this.b == n.b && this.c == n.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentDetails(paymentId=" + this.a + ", status=" + this.b + ", userPaymentProcess=" + this.c + ")";
    }
}
