package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class Q implements Z {
    public final Throwable a;

    public Q(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.a = throwable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Q) && Intrinsics.areEqual(this.a, ((Q) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Error(throwable=" + this.a + ")";
    }
}
