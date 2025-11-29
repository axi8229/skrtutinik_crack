package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class En extends co {
    public final AbstractC1687j9 a;
    public final long b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public En(AbstractC1687j9 result, long j) {
        super(0);
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof En)) {
            return false;
        }
        En en = (En) obj;
        return Intrinsics.areEqual(this.a, en.a) && this.b == en.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "HandleConfirmOtpResult(result=" + this.a + ", timerTime=" + this.b + ')';
    }
}
