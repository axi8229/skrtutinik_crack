package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w extends z {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        this.a = tokenizeInputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && Intrinsics.areEqual(this.a, ((w) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Tokenize(tokenizeInputModel=" + this.a + ")";
    }
}
