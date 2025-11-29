package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.SBP;

/* loaded from: classes5.dex */
public final class D0 extends H0 {
    public final SBP a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D0(SBP paymentOption) {
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
        return (obj instanceof D0) && Intrinsics.areEqual(this.a, ((D0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SBPContractInfo(paymentOption=" + this.a + ")";
    }
}
