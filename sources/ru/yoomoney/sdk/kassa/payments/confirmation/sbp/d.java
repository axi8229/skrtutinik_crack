package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends f {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Throwable throwable) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.a, ((d) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "GetPaymentDetailsFailed(throwable=" + this.a + ")";
    }
}
