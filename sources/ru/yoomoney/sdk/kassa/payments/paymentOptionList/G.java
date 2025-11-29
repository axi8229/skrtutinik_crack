package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class G extends L {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(ru.yoomoney.sdk.kassa.payments.payment.tokenize.k tokenizeInputModel) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        this.a = tokenizeInputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof G) && Intrinsics.areEqual(this.a, ((G) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StartTokenization(tokenizeInputModel=" + this.a + ")";
    }
}
