package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.xn, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2050xn extends co {
    public final InterfaceC1850pm a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2050xn(InterfaceC1850pm mode, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2050xn)) {
            return false;
        }
        C2050xn c2050xn = (C2050xn) obj;
        return Intrinsics.areEqual(this.a, c2050xn.a) && this.b == c2050xn.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShowOrderScreenEvent(mode=");
        sb.append(this.a);
        sb.append(", dropSelectedCardForBnpl=");
        return AbstractC1901s.a(sb, this.b, ')');
    }
}
