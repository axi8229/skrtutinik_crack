package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.PaymentIdCscConfirmation;

/* loaded from: classes5.dex */
public final class C0 extends H0 {
    public final PaymentIdCscConfirmation a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0(PaymentIdCscConfirmation paymentOption) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.contract.H0
    public final ru.yoomoney.sdk.kassa.payments.model.T a() {
        return this.a;
    }

    public final PaymentIdCscConfirmation b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0) && Intrinsics.areEqual(this.a, ((C0) obj).a);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "PaymentIdCscConfirmationContractInfo(paymentOption=" + this.a + ", allowWalletLinking=true)";
    }
}
