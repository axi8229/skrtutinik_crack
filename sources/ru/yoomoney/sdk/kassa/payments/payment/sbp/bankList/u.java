package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u extends C {
    public final Throwable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Throwable throwable) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && Intrinsics.areEqual(this.a, ((u) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Error(throwable=" + this.a + ")";
    }
}
