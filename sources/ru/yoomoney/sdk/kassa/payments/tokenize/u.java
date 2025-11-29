package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class u extends z {
    public final Amount a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Amount charge) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        this.a = charge;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && Intrinsics.areEqual(this.a, ((u) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PaymentAuthRequired(charge=" + this.a + ")";
    }
}
