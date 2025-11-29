package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.AuthWithOrderIdRequestBody;

/* renamed from: npi.spay.n1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1779n1 {
    public final String a;
    public final AuthWithOrderIdRequestBody b;

    public C1779n1(String authorization, AuthWithOrderIdRequestBody authWithOrderIdRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(authWithOrderIdRequestBody, "authWithOrderIdRequestBody");
        this.a = authorization;
        this.b = authWithOrderIdRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1779n1)) {
            return false;
        }
        C1779n1 c1779n1 = (C1779n1) obj;
        return Intrinsics.areEqual(this.a, c1779n1.a) && Intrinsics.areEqual(this.b, c1779n1.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetAuthWithOrderIdUseCaseRequestParams(authorization=" + this.a + ", authWithOrderIdRequestBody=" + this.b + ')';
    }
}
