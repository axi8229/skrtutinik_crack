package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.SessionIdWithOrderIdRequestBody;

/* loaded from: classes4.dex */
public final class Ye {
    public final String a;
    public final SessionIdWithOrderIdRequestBody b;

    public Ye(String authorization, SessionIdWithOrderIdRequestBody sessionIdWithOrderIdRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(sessionIdWithOrderIdRequestBody, "sessionIdWithOrderIdRequestBody");
        this.a = authorization;
        this.b = sessionIdWithOrderIdRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ye)) {
            return false;
        }
        Ye ye = (Ye) obj;
        return Intrinsics.areEqual(this.a, ye.a) && Intrinsics.areEqual(this.b, ye.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetSessionIdWithOrderIdUseCaseRequestParams(authorization=" + this.a + ", sessionIdWithOrderIdRequestBody=" + this.b + ')';
    }
}
