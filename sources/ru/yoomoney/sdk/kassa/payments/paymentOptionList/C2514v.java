package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2514v extends C {
    public final int a;
    public final String b;

    public C2514v(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2514v)) {
            return false;
        }
        C2514v c2514v = (C2514v) obj;
        return this.a == c2514v.a && Intrinsics.areEqual(this.b, c2514v.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "OpenUnbindScreen(optionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
