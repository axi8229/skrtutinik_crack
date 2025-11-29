package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.PaymentTokenWithOrderIdRequestBody;

/* renamed from: npi.spay.j8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1686j8 {
    public final String a;
    public final PaymentTokenWithOrderIdRequestBody b;

    public C1686j8(String authorization, PaymentTokenWithOrderIdRequestBody paymentTokenWithOrderIdRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(paymentTokenWithOrderIdRequestBody, "paymentTokenWithOrderIdRequestBody");
        this.a = authorization;
        this.b = paymentTokenWithOrderIdRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1686j8)) {
            return false;
        }
        C1686j8 c1686j8 = (C1686j8) obj;
        return Intrinsics.areEqual(this.a, c1686j8.a) && Intrinsics.areEqual(this.b, c1686j8.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetPaymentTokenWithOrderIdUseCaseRequestParams(authorization=" + this.a + ", paymentTokenWithOrderIdRequestBody=" + this.b + ')';
    }
}
