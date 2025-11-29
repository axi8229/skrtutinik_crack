package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.SberBank;

/* loaded from: classes5.dex */
public final class E0 extends H0 {
    public final SberBank a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E0(SberBank paymentOption, String str) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
        this.b = str;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E0)) {
            return false;
        }
        E0 e0 = (E0) obj;
        return Intrinsics.areEqual(this.a, e0.a) && Intrinsics.areEqual(this.b, e0.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "SberBankContractInfo(paymentOption=" + this.a + ", userPhoneNumber=" + this.b + ")";
    }
}
