package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends f {
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String paymentId, String confirmationUrl) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        this.a = paymentId;
        this.b = confirmationUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetConfirmationDetailsSuccess(paymentId=" + this.a + ", confirmationUrl=" + this.b + ")";
    }
}
