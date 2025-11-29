package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.ErrorEntity;

/* renamed from: npi.spay.ye, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2066ye extends Ae {
    public final ErrorEntity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2066ye(ErrorEntity sPayApiError) {
        super(0);
        Intrinsics.checkNotNullParameter(sPayApiError, "sPayApiError");
        this.a = sPayApiError;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2066ye) && Intrinsics.areEqual(this.a, ((C2066ye) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ErrorWithBnplEnabled(sPayApiError=" + this.a + ')';
    }
}
