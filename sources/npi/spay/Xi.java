package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

/* loaded from: classes4.dex */
public final class Xi extends Zi {
    public final FraudMonCheckResult a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xi(FraudMonCheckResult fraudMonCheckResult) {
        super(0);
        Intrinsics.checkNotNullParameter(fraudMonCheckResult, "fraudMonCheckResult");
        this.a = fraudMonCheckResult;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Xi) && Intrinsics.areEqual(this.a, ((Xi) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "OtpReview(fraudMonCheckResult=" + this.a + ')';
    }
}
