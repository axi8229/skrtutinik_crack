package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* loaded from: classes5.dex */
public final class A0 extends H0 {
    public final BankCardPaymentOption a;
    public final ru.yoomoney.sdk.kassa.payments.model.Q b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A0(BankCardPaymentOption paymentOption, ru.yoomoney.sdk.kassa.payments.model.Q instrument) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        Intrinsics.checkNotNullParameter(instrument, "instrument");
        this.a = paymentOption;
        this.b = instrument;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final ru.yoomoney.sdk.kassa.payments.model.Q b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A0)) {
            return false;
        }
        A0 a0 = (A0) obj;
        return Intrinsics.areEqual(this.a, a0.a) && Intrinsics.areEqual(this.b, a0.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "LinkedBankCardContractInfo(paymentOption=" + this.a + ", instrument=" + this.b + ")";
    }
}
