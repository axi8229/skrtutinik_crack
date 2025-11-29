package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W2 extends Z2 {
    public final AbstractC1535d6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W2(AbstractC1535d6 loadingStatus) {
        super(0);
        Intrinsics.checkNotNullParameter(loadingStatus, "loadingStatus");
        this.a = loadingStatus;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W2) && Intrinsics.areEqual(this.a, ((W2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ShowLoading(loadingStatus=" + this.a + ')';
    }
}
