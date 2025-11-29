package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.PaymentOrderRequestBody;

/* loaded from: classes4.dex */
public final class D0 {
    public final String a;
    public final PaymentOrderRequestBody b;

    public D0(String authorization, PaymentOrderRequestBody paymentOrderRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(paymentOrderRequestBody, "paymentOrderRequestBody");
        this.a = authorization;
        this.b = paymentOrderRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D0)) {
            return false;
        }
        D0 d0 = (D0) obj;
        return Intrinsics.areEqual(this.a, d0.a) && Intrinsics.areEqual(this.b, d0.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetPaymentOrderUseCaseRequestParams(authorization=" + this.a + ", paymentOrderRequestBody=" + this.b + ')';
    }
}
