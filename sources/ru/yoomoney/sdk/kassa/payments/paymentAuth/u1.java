package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class u1 implements A1 {
    public final String a;
    public final C2326j b;

    public u1(String passphrase, C2326j data) {
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = passphrase;
        this.b = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u1)) {
            return false;
        }
        u1 u1Var = (u1) obj;
        return Intrinsics.areEqual(this.a, u1Var.a) && Intrinsics.areEqual(this.b, u1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "InputCodeProcess(passphrase=" + this.a + ", data=" + this.b + ")";
    }
}
