package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2501o extends C {
    public final int a;
    public final String b;

    public C2501o(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2501o)) {
            return false;
        }
        C2501o c2501o = (C2501o) obj;
        return this.a == c2501o.a && Intrinsics.areEqual(this.b, c2501o.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ClickOnUnbind(optionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
