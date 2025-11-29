package ru.yoomoney.sdk.kassa.payments.navigation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends v {
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String confirmationUrl, String paymentId) {
        super(0);
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        this.a = confirmationUrl;
        this.b = paymentId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "BankList(confirmationUrl=" + this.a + ", paymentId=" + this.b + ")";
    }
}
