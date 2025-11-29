package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W1 extends AbstractC1855q2 {
    public final M8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W1(M8 fraudMonResultMode) {
        super(0);
        Intrinsics.checkNotNullParameter(fraudMonResultMode, "fraudMonResultMode");
        this.a = fraudMonResultMode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W1) && Intrinsics.areEqual(this.a, ((W1) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "FraudMonReview(fraudMonResultMode=" + this.a + ')';
    }
}
