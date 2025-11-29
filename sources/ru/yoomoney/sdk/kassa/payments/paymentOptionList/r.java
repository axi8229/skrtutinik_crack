package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r extends C {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && Intrinsics.areEqual(this.a, ((r) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadPaymentOptionListFailed(error=" + this.a + ")";
    }
}
