package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;

/* loaded from: classes4.dex */
public final class J1 extends AbstractC1855q2 {
    public final PaymentPlanBnplResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J1(PaymentPlanBnplResponseBody bnplResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(bnplResponseBody, "bnplResponseBody");
        this.a = bnplResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof J1) && Intrinsics.areEqual(this.a, ((J1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "BnplResult(bnplResponseBody=" + this.a + ')';
    }
}
