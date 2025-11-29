package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class On extends co {
    public final Z6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public On(Z6 payStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(payStatus, "payStatus");
        this.a = payStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof On) && Intrinsics.areEqual(this.a, ((On) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HandlePayResult(payStatus=" + this.a + ')';
    }
}
