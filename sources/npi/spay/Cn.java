package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class Cn extends co {
    public final ErrorEntity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cn(ErrorEntity errorResponse) {
        super(0);
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.a = errorResponse;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cn) && Intrinsics.areEqual(this.a, ((Cn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleConfirmOtpError(errorResponse=" + this.a + ')';
    }
}
