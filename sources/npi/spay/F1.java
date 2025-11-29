package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.AuthResponseBody;

/* loaded from: classes4.dex */
public final class F1 extends AbstractC1855q2 {
    public final AuthResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F1(AuthResponseBody authResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(authResponseBody, "authResponseBody");
        this.a = authResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof F1) && Intrinsics.areEqual(this.a, ((F1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AuthResult(authResponseBody=" + this.a + ')';
    }
}
