package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.request.PayOnlineRequestBody;

/* renamed from: npi.spay.pl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1849pl {
    public final String a;
    public final PayOnlineRequestBody b;

    public C1849pl(String authorization, PayOnlineRequestBody payOnlineRequestBody) {
        Intrinsics.checkNotNullParameter(authorization, "authorization");
        Intrinsics.checkNotNullParameter(payOnlineRequestBody, "payOnlineRequestBody");
        this.a = authorization;
        this.b = payOnlineRequestBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1849pl)) {
            return false;
        }
        C1849pl c1849pl = (C1849pl) obj;
        return Intrinsics.areEqual(this.a, c1849pl.a) && Intrinsics.areEqual(this.b, c1849pl.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GetPayOnlineUseCaseRequestParams(authorization=" + this.a + ", payOnlineRequestBody=" + this.b + ')';
    }
}
