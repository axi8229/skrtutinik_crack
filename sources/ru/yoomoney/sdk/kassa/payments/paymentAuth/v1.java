package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class v1 implements A1 {
    public final String a;
    public final C2326j b;

    public v1(String passphrase, C2326j data) {
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = passphrase;
        this.b = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return Intrinsics.areEqual(this.a, v1Var.a) && Intrinsics.areEqual(this.b, v1Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "InputCodeVerifyExceeded(passphrase=" + this.a + ", data=" + this.b + ")";
    }
}
