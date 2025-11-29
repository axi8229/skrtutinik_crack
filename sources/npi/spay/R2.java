package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R2 extends Z2 {
    public final Z6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R2(Z6 payStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(payStatus, "payStatus");
        this.a = payStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof R2) && Intrinsics.areEqual(this.a, ((R2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Pay(payStatus=" + this.a + ')';
    }
}
