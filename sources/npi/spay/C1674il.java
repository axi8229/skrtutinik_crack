package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.ConfirmOtpRequestBody;

/* renamed from: npi.spay.il, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1674il {
    public final String a;
    public final ConfirmOtpRequestBody b;
    public final String c;
    public final long d;

    public C1674il(String authorization, ConfirmOtpRequestBody confirmOtpRequest, String mobilePhone, long j) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(confirmOtpRequest, "confirmOtpRequest");
        Intrinsics.checkNotNullParameter(mobilePhone, "mobilePhone");
        this.a = authorization;
        this.b = confirmOtpRequest;
        this.c = mobilePhone;
        this.d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1674il)) {
            return false;
        }
        C1674il c1674il = (C1674il) obj;
        return Intrinsics.areEqual(this.a, c1674il.a) && Intrinsics.areEqual(this.b, c1674il.b) && Intrinsics.areEqual(this.c, c1674il.c) && this.d == c1674il.d;
    }

    public final int hashCode() {
        return Long.hashCode(this.d) + AbstractC1553e.a(this.c, (this.b.hashCode() + (this.a.hashCode() * 31)) * 31, 31);
    }

    public final String toString() {
        return "ConfirmOtpCodeUseCaseRequestParams(authorization=" + this.a + ", confirmOtpRequest=" + this.b + ", mobilePhone=" + this.c + ", timerTime=" + this.d + ')';
    }
}
