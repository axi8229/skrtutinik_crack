package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class I extends O {
    public final String a;
    public final C2326j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(String passphrase, C2326j data) {
        super(0);
        Intrinsics.checkNotNullParameter(passphrase, "passphrase");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = passphrase;
        this.b = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return false;
        }
        I i = (I) obj;
        return Intrinsics.areEqual(this.a, i.a) && Intrinsics.areEqual(this.b, i.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "InputCodeProcess(passphrase=" + this.a + ", data=" + this.b + ")";
    }
}
