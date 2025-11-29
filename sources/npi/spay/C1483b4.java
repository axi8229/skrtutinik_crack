package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.PaymentBnplPlanRequestBody;

/* renamed from: npi.spay.b4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1483b4 {
    public final String a;
    public final PaymentBnplPlanRequestBody b;

    public C1483b4(String authorization, PaymentBnplPlanRequestBody paymentPlanBnplRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(paymentPlanBnplRequestBody, "paymentPlanBnplRequestBody");
        this.a = authorization;
        this.b = paymentPlanBnplRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1483b4)) {
            return false;
        }
        C1483b4 c1483b4 = (C1483b4) obj;
        return Intrinsics.areEqual(this.a, c1483b4.a) && Intrinsics.areEqual(this.b, c1483b4.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetPaymentPlanBnplUseCaseRequestParams(authorization=" + this.a + ", paymentPlanBnplRequestBody=" + this.b + ')';
    }
}
