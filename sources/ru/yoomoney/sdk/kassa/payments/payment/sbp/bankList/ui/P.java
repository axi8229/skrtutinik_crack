package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class P implements Z {
    public final Throwable a;
    public final ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C b;

    public P(Throwable throwable, ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C previosListState) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(previosListState, "previosListState");
        this.a = throwable;
        this.b = previosListState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P)) {
            return false;
        }
        P p = (P) obj;
        return Intrinsics.areEqual(this.a, p.a) && Intrinsics.areEqual(this.b, p.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ActivityNotFoundError(throwable=" + this.a + ", previosListState=" + this.b + ")";
    }
}
