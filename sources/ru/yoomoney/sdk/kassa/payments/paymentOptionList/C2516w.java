package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2516w extends C {
    public final int a;
    public final String b;

    public C2516w(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2516w)) {
            return false;
        }
        C2516w c2516w = (C2516w) obj;
        return this.a == c2516w.a && Intrinsics.areEqual(this.b, c2516w.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "OpenUnbindingAlert(optionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
