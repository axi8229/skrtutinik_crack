package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.d2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1531d2 extends AbstractC1855q2 {
    public final AbstractC1535d6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1531d2(AbstractC1535d6 loadingStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(loadingStatus, "loadingStatus");
        this.a = loadingStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1531d2) && Intrinsics.areEqual(this.a, ((C1531d2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Loading(loadingStatus=" + this.a + ')';
    }
}
