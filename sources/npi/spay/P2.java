package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P2 extends Z2 {
    public final InterfaceC1850pm a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2(InterfaceC1850pm mode, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P2)) {
            return false;
        }
        P2 p2 = (P2) obj;
        return Intrinsics.areEqual(this.a, p2.a) && this.b == p2.b && Intrinsics.areEqual(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (iHashCode + i) * 31;
    }

    public final String toString() {
        return "OrderScreenData(mode=" + this.a + ", noCardsAvailable=" + this.b + ", selectedCard=null)";
    }
}
