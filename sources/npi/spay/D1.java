package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class D1 extends AbstractC1855q2 {
    public final InterfaceC1850pm a;
    public final Eg b;
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D1(InterfaceC1850pm mode, Eg eg, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
        this.b = eg;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D1)) {
            return false;
        }
        D1 d1 = (D1) obj;
        return Intrinsics.areEqual(this.a, d1.a) && Intrinsics.areEqual(this.b, d1.b) && this.c == d1.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Eg eg = this.b;
        int iHashCode2 = (iHashCode + (eg == null ? 0 : eg.hashCode())) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AskForFullEmission(mode=");
        sb.append(this.a);
        sb.append(", authResult=");
        sb.append(this.b);
        sb.append(", isTokenRenewNeeded=");
        return AbstractC1901s.a(sb, this.c, ')');
    }
}
