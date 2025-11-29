package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class Gn extends co {
    public final ErrorEntity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gn(ErrorEntity errorResponse) {
        super(0);
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.a = errorResponse;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Gn) && Intrinsics.areEqual(this.a, ((Gn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleCreateOtpSdkError(errorResponse=" + this.a + ')';
    }
}
