package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class t1 implements A1 {
    public final C2326j a;

    public t1(C2326j data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t1) && Intrinsics.areEqual(this.a, ((t1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "InputCode(data=" + this.a + ")";
    }
}
