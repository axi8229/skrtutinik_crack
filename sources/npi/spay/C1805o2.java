package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.o2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1805o2 extends AbstractC1855q2 {
    public final Ae a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1805o2(Ae paymentTokenStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentTokenStatus, "paymentTokenStatus");
        this.a = paymentTokenStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1805o2) && Intrinsics.areEqual(this.a, ((C1805o2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PaymentTokenResult(paymentTokenStatus=" + this.a + ')';
    }
}
