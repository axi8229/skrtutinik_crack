package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class B extends D {
    public final Amount a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Amount charge, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(charge, "charge");
        this.a = charge;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b = (B) obj;
        return Intrinsics.areEqual(this.a, b.a) && this.b == b.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "PaymentAuthRequired(charge=" + this.a + ", allowWalletLinking=" + this.b + ")";
    }
}
