package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2447u extends E {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2447u(Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2447u) && Intrinsics.areEqual(this.a, ((C2447u) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ProcessAuthFailed(error=" + this.a + ")";
    }
}
