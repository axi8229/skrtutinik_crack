package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class I extends L {
    public final ru.yoomoney.sdk.kassa.payments.model.Q a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(ru.yoomoney.sdk.kassa.payments.model.Q instrumentBankCard) {
        super(0);
        Intrinsics.checkNotNullParameter(instrumentBankCard, "instrumentBankCard");
        this.a = instrumentBankCard;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof I) && Intrinsics.areEqual(this.a, ((I) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UnbindInstrument(instrumentBankCard=" + this.a + ")";
    }
}
