package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class B extends E {
    public final boolean a;
    public final Amount b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Amount amount, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.a = z;
        this.b = amount;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b = (B) obj;
        return this.a == b.a && Intrinsics.areEqual(this.b, b.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Start(linkWalletToApp=" + this.a + ", amount=" + this.b + ")";
    }
}
