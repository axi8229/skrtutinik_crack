package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.BankCardPaymentOption;

/* loaded from: classes5.dex */
public final class B0 extends H0 {
    public final BankCardPaymentOption a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(BankCardPaymentOption paymentOption) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof B0) && Intrinsics.areEqual(this.a, ((B0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "NewBankCardContractInfo(paymentOption=" + this.a + ")";
    }
}
