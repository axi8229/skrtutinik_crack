package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2522z extends C {
    public final int a;
    public final String b;

    public C2522z(int i, String str) {
        super(0);
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2522z)) {
            return false;
        }
        C2522z c2522z = (C2522z) obj;
        return this.a == c2522z.a && Intrinsics.areEqual(this.b, c2522z.b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ProceedWithPaymentMethod(optionId=" + this.a + ", instrumentId=" + this.b + ")";
    }
}
