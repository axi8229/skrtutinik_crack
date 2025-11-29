package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public final class I8 extends M8 {
    public final FraudMonCheckResult b;

    public I8(FraudMonCheckResult fraudMonCheckResult) {
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
        return (obj instanceof I8) && Intrinsics.areEqual(this.b, ((I8) obj).b);
    }

    public final int hashCode() {
        FraudMonCheckResult fraudMonCheckResult = this.b;
        if (fraudMonCheckResult == null) {
            return 0;
        }
        return fraudMonCheckResult.hashCode();
    }

    public final String toString() {
        return "DenyMode(fraudMonCheckResultParams=" + this.b + ')';
    }
}
