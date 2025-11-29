package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class L extends O {
    public final C2326j a;
    public final Throwable b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(C2326j data, Throwable error) {
        super(0);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = data;
        this.b = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L)) {
            return false;
        }
        L l = (L) obj;
        return Intrinsics.areEqual(this.a, l.a) && Intrinsics.areEqual(this.b, l.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ProcessError(data=" + this.a + ", error=" + this.b + ")";
    }
}
