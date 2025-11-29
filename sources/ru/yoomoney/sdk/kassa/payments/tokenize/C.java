package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class C extends D {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.l a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(ru.yoomoney.sdk.kassa.payments.payment.tokenize.l tokenizeOutputModel, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenizeOutputModel, "tokenizeOutputModel");
        this.a = tokenizeOutputModel;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c = (C) obj;
        return Intrinsics.areEqual(this.a, c.a) && this.b == c.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "TokenizeComplete(tokenizeOutputModel=" + this.a + ", allowWalletLinking=" + this.b + ")";
    }
}
