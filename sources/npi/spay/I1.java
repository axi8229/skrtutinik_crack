package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class I1 extends AbstractC1855q2 {
    public final ErrorEntity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I1(ErrorEntity errorResponse) {
        super(0);
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.a = errorResponse;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof I1) && Intrinsics.areEqual(this.a, ((I1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowCreateOtpSdkResultError(errorResponse=" + this.a + ')';
    }
}
