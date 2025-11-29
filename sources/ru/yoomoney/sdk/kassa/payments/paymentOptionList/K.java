package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class K extends L {
    public final ru.yoomoney.sdk.kassa.payments.model.Q a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(ru.yoomoney.sdk.kassa.payments.model.Q instrumentBankCard) {
        super(0);
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        this.a = instrumentBankCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof K) && Intrinsics.areEqual(this.a, ((K) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UnbindSuccess(instrumentBankCard=" + this.a + ")";
    }
}
