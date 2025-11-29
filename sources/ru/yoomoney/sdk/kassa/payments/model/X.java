package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class X {
    public final String a;
    public final Y b;

    public X(String paymentToken, Y y) {
        Intrinsics.checkNotNullParameter(paymentToken, "paymentToken");
        this.a = paymentToken;
        this.b = y;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return false;
        }
        X x = (X) obj;
        return Intrinsics.areEqual(this.a, x.a) && Intrinsics.areEqual(this.b, x.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Y y = this.b;
        return iHashCode + (y == null ? 0 : y.hashCode());
    }

    public final String toString() {
        return "PaymentTokenInfo(paymentToken=" + this.a + ", profilingInfo=" + this.b + ")";
    }
}
