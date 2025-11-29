package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class M extends O {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof M) && Intrinsics.areEqual(this.a, ((M) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StartError(error=" + this.a + ")";
    }
}
