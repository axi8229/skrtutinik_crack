package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y1 implements A1 {
    public final Throwable a;

    public y1(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y1) && Intrinsics.areEqual(this.a, ((y1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StartError(error=" + this.a + ")";
    }
}
