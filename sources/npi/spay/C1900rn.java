package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.rn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1900rn extends co {
    public final AbstractC1535d6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1900rn(AbstractC1535d6 paymentLoading) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentLoading, "paymentLoading");
        this.a = paymentLoading;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1900rn) && Intrinsics.areEqual(this.a, ((C1900rn) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowLoadingScreen(paymentLoading=" + this.a + ')';
    }
}
