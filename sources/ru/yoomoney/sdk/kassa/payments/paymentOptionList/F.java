package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class F extends L {
    public final int a;
    public final String b;

    public F(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f = (F) obj;
        return this.a == f.a && Intrinsics.areEqual(this.b, f.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ShowContract(paymentOptionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
