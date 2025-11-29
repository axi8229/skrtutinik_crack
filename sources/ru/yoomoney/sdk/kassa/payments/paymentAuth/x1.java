package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class x1 implements A1 {
    public final C2326j a;
    public final Throwable b;

    public x1(C2326j data, Throwable error) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = data;
        this.b = error;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return Intrinsics.areEqual(this.a, x1Var.a) && Intrinsics.areEqual(this.b, x1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ProcessError(data=" + this.a + ", error=" + this.b + ")";
    }
}
