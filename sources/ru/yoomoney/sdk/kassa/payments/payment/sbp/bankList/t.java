package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class t extends C {
    public final Throwable a;
    public final C b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Throwable throwable, C previosListState) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(previosListState, "previosListState");
        this.a = throwable;
        this.b = previosListState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.a, tVar.a) && Intrinsics.areEqual(this.b, tVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ActivityNotFoundError(throwable=" + this.a + ", previosListState=" + this.b + ")";
    }
}
