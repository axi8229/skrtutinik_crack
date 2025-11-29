package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q1 extends C1 {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(String token) {
        super(0);
        Intrinsics.checkNotNullParameter(token, "token");
        this.a = token;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q1) && Intrinsics.areEqual(this.a, ((q1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PaymentAuthToken(token=" + this.a + ")";
    }
}
