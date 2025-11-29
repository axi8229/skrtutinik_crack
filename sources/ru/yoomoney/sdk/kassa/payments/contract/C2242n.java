package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2242n extends AbstractC2244o {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2242n(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        this.a = tokenizeInputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2242n) && Intrinsics.areEqual(this.a, ((C2242n) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Effect.ShowTokenize";
    }
}
