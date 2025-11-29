package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.successResponse.PaymentTokenResponseBody;

/* renamed from: npi.spay.ze, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2091ze extends Ae {
    public final PaymentTokenResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2091ze(PaymentTokenResponseBody paymentTokenResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentTokenResponseBody, "paymentTokenResponseBody");
        this.a = paymentTokenResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2091ze) && Intrinsics.areEqual(this.a, ((C2091ze) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(paymentTokenResponseBody=" + this.a + ')';
    }
}
