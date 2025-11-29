package ru.yoomoney.sdk.kassa.payments.confirmation.sbp;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.model.W;
import ru.yoomoney.sdk.kassa.payments.model.t0;

/* loaded from: classes5.dex */
public final class e extends f {
    public final String a;
    public final String b;
    public final W c;
    public final t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String confirmationUrl, String paymentId, W status, t0 t0Var) {
        super(0);
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(status, "status");
        this.a = confirmationUrl;
        this.b = paymentId;
        this.c = status;
        this.d = t0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31)) * 31;
        t0 t0Var = this.d;
        return iHashCode + (t0Var == null ? 0 : t0Var.hashCode());
    }

    public final String toString() {
        return "GetPaymentDetailsSuccess(confirmationUrl=" + this.a + ", paymentId=" + this.b + ", status=" + this.c + ", userPaymentProcess=" + this.d + ")";
    }
}
