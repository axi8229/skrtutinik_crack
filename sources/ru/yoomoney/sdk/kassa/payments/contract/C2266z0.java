package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractWallet;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.z0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2266z0 extends H0 {
    public final AbstractWallet a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2266z0(AbstractWallet paymentOption) {
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
        return (obj instanceof C2266z0) && Intrinsics.areEqual(this.a, ((C2266z0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AbstractWalletContractInfo(paymentOption=" + this.a + ")";
    }
}
