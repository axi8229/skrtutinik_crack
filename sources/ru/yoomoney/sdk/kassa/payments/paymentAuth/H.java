package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class H extends O {
    public final C2326j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(C2326j data) {
        super(0);
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H) && Intrinsics.areEqual(this.a, ((H) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "InputCode(data=" + this.a + ")";
    }
}
