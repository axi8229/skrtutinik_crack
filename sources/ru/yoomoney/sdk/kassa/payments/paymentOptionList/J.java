package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class J extends L {
    public final ru.yoomoney.sdk.kassa.payments.model.T a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(ru.yoomoney.sdk.kassa.payments.model.T paymentOption) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J) && Intrinsics.areEqual(this.a, ((J) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UnbindLinkedCard(paymentOption=" + this.a + ")";
    }
}
