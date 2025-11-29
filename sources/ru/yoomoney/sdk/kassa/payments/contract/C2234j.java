package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2234j extends AbstractC2236k {
    public final ru.yoomoney.sdk.kassa.payments.model.Q a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2234j(ru.yoomoney.sdk.kassa.payments.model.Q instrument, String str) {
        super(0);
        Intrinsics.checkNotNullParameter(instrument, "instrument");
        this.a = instrument;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2234j)) {
            return false;
        }
        C2234j c2234j = (C2234j) obj;
        return Intrinsics.areEqual(this.a, c2234j.a) && Intrinsics.areEqual(this.b, c2234j.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "TokenizePaymentInstrument(instrument=" + this.a + ", csc=" + this.b + ")";
    }
}
