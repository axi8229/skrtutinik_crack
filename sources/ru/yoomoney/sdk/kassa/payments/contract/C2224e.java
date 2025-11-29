package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2224e extends AbstractC2236k {
    public final ru.yoomoney.sdk.kassa.payments.payment.selectOption.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2224e(ru.yoomoney.sdk.kassa.payments.payment.selectOption.a outputModel) {
        super(0);
        Intrinsics.checkNotNullParameter(outputModel, "outputModel");
        this.a = outputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2224e) && Intrinsics.areEqual(this.a, ((C2224e) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LoadContractSuccess(outputModel=" + this.a + ")";
    }
}
