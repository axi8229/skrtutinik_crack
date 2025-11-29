package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public final class Vi extends Zi {
    public final FraudMonCheckResult a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vi(FraudMonCheckResult fraudMonCheckResult) {
        super(0);
        Intrinsics.checkNotNullParameter(fraudMonCheckResult, "fraudMonCheckResult");
        this.a = fraudMonCheckResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Vi) && Intrinsics.areEqual(this.a, ((Vi) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DenyBlock(fraudMonCheckResult=" + this.a + ')';
    }
}
