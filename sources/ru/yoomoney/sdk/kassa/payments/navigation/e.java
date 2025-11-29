package ru.yoomoney.sdk.kassa.payments.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends v {
    public final int a;
    public final String b;

    public e(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && Intrinsics.areEqual(this.b, eVar.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "Contract(paymentOptionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
