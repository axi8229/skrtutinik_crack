package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class G1 extends AbstractC1855q2 {
    public final ErrorEntity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G1(ErrorEntity sPayApiError) {
        super(0);
        Intrinsics.checkNotNullParameter(sPayApiError, "sPayApiError");
        this.a = sPayApiError;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof G1) && Intrinsics.areEqual(this.a, ((G1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowConfirmOtpCodeResultError(sPayApiError=" + this.a + ')';
    }
}
