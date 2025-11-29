package ru.yoomoney.sdk.kassa.payments.payment.selectOption;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class a {
    public final T a;
    public final Q b;
    public final boolean c;

    public a(T paymentOption, Q q, boolean z) {
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
        this.b = q;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Q q = this.b;
        return Boolean.hashCode(this.c) + ((iHashCode + (q == null ? 0 : q.hashCode())) * 31);
    }

    public final String toString() {
        return "SelectedPaymentMethodOutputModel(paymentOption=" + this.a + ", instrument=" + this.b + ", walletLinkingPossible=" + this.c + ")";
    }
}
