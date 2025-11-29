package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public final class K8 extends M8 {
    public final FraudMonCheckResult b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K8(FraudMonCheckResult fraudMonCheckResultParams) {
        super(fraudMonCheckResultParams, 0);
        Intrinsics.checkNotNullParameter(fraudMonCheckResultParams, "fraudMonCheckResultParams");
        this.b = fraudMonCheckResultParams;
    }

    @Override // npi.spay.M8
    public final FraudMonCheckResult a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof K8) && Intrinsics.areEqual(this.b, ((K8) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "OtpReviewMode(fraudMonCheckResultParams=" + this.b + ')';
    }
}
