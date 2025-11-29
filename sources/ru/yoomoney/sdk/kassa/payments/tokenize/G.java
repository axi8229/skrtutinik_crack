package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class G extends H {
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.i a;
    public final Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel, Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = tokenizeInputModel;
        this.b = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        G g = (G) obj;
        return Intrinsics.areEqual(this.a, g.a) && Intrinsics.areEqual(this.b, g.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "TokenizeError(tokenizeInputModel=" + this.a + ", error=" + this.b + ")";
    }
}
