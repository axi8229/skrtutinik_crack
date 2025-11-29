package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public final class H8 extends M8 {
    public final FraudMonCheckResult b;

    public H8(FraudMonCheckResult fraudMonCheckResult) {
        super(fraudMonCheckResult, 0);
        this.b = fraudMonCheckResult;
    }

    @Override // npi.spay.M8
    public final FraudMonCheckResult a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H8) && Intrinsics.areEqual(this.b, ((H8) obj).b);
    }

    public final int hashCode() {
        FraudMonCheckResult fraudMonCheckResult = this.b;
        if (fraudMonCheckResult == null) {
            return 0;
        }
        return fraudMonCheckResult.hashCode();
    }

    public final String toString() {
        return "DenyBlockMode(fraudMonCheckResultParams=" + this.b + ')';
    }
}
