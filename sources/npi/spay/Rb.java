package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.PaymentTokenWithPurchaseRequestBody;

/* loaded from: classes4.dex */
public final class Rb {
    public final String a;
    public final PaymentTokenWithPurchaseRequestBody b;

    public Rb(String authorization, PaymentTokenWithPurchaseRequestBody paymentTokenWithPurchaseRequest) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(paymentTokenWithPurchaseRequest, "paymentTokenWithPurchaseRequest");
        this.a = authorization;
        this.b = paymentTokenWithPurchaseRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rb)) {
            return false;
        }
        Rb rb = (Rb) obj;
        return Intrinsics.areEqual(this.a, rb.a) && Intrinsics.areEqual(this.b, rb.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetPaymentTokenWithPurchaseUseCaseRequestParams(authorization=" + this.a + ", paymentTokenWithPurchaseRequest=" + this.b + ')';
    }
}
