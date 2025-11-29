package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.SessionIdResponseBody;

/* loaded from: classes4.dex */
public final class Rn extends co {
    public final SessionIdResponseBody a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rn(SessionIdResponseBody sessionIdResponseBody) {
        super(0);
        Intrinsics.checkNotNullParameter(sessionIdResponseBody, "sessionIdResponseBody");
        this.a = sessionIdResponseBody;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Rn) && Intrinsics.areEqual(this.a, ((Rn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleSessionIdData(sessionIdResponseBody=" + this.a + ')';
    }
}
