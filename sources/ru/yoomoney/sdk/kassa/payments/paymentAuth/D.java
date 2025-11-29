package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* loaded from: classes5.dex */
public final class D extends E {
    public final C2326j a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(C2326j authTypeState) {
        super(0);
        Intrinsics.checkNotNullParameter(authTypeState, "authTypeState");
        this.a = authTypeState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof D) && Intrinsics.areEqual(this.a, ((D) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "StartSuccess(authTypeState=" + this.a + ")";
    }
}
