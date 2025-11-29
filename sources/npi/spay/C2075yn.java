package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.AuthResponseBody;

/* renamed from: npi.spay.yn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2075yn extends co {
    public final AuthResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2075yn(AuthResponseBody authResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(authResponseBody, "authResponseBody");
        this.a = authResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2075yn) && Intrinsics.areEqual(this.a, ((C2075yn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleAuthData(authResponseBody=" + this.a + ')';
    }
}
