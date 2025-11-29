package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Nn extends co {
    public final Zi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Nn(Zi fraudMonReviewState) {
        super(0);
        Intrinsics.checkNotNullParameter(fraudMonReviewState, "fraudMonReviewState");
        this.a = fraudMonReviewState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Nn) && Intrinsics.areEqual(this.a, ((Nn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandleFraudMonCheckResult(fraudMonReviewState=" + this.a + ')';
    }
}
