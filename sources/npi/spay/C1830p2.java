package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.p2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1830p2 extends AbstractC1855q2 {
    public final Xd a;
    public final Sg b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1830p2(Xd request, Sg actionOnSuccess) {
        super(0);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(actionOnSuccess, "actionOnSuccess");
        this.a = request;
        this.b = actionOnSuccess;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1830p2)) {
            return false;
        }
        C1830p2 c1830p2 = (C1830p2) obj;
        return Intrinsics.areEqual(this.a, c1830p2.a) && Intrinsics.areEqual(this.b, c1830p2.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "PerformCreateOTPRequest(request=" + this.a + ", actionOnSuccess=" + this.b + ')';
    }
}
