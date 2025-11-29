package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.CreateOtpSdkRequestBody;

/* loaded from: classes4.dex */
public final class Xd {
    public final String a;
    public final CreateOtpSdkRequestBody b;

    public Xd(String authorization, CreateOtpSdkRequestBody createOtpSdkRequest) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(createOtpSdkRequest, "createOtpSdkRequest");
        this.a = authorization;
        this.b = createOtpSdkRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Xd)) {
            return false;
        }
        Xd xd = (Xd) obj;
        return Intrinsics.areEqual(this.a, xd.a) && Intrinsics.areEqual(this.b, xd.b);
    }

    public final int hashCode() {
        return Long.hashCode(45000L) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "CreateOtpSdkUseCaseParams(authorization=" + this.a + ", createOtpSdkRequest=" + this.b + ", timerTime=45000)";
    }
}
