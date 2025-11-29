package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g extends i {
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String confirmationUrl, String paymentId) {
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
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ContinueSBPConfirmation(confirmationUrl=" + this.a + ", paymentId=" + this.b + ")";
    }
}
