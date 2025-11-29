package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r implements t {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.i a;

    public r(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel) {
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        this.a = tokenizeInputModel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && Intrinsics.areEqual(this.a, ((r) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Tokenize(tokenizeInputModel=" + this.a + ")";
    }
}
