package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.k2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1705k2 extends AbstractC1855q2 {
    public final InterfaceC1850pm a;
    public final String b;
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1705k2(InterfaceC1850pm mode, String str, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.a = mode;
        this.b = str;
        this.c = z;
    }

    public final boolean a() {
        return this.c;
    }

    public final InterfaceC1850pm b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1705k2)) {
            return false;
        }
        C1705k2 c1705k2 = (C1705k2) obj;
        return Intrinsics.areEqual(this.a, c1705k2.a) && Intrinsics.areEqual(this.b, c1705k2.b) && this.c == c1705k2.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OrderScreenData(mode=");
        sb.append(this.a);
        sb.append(", uri=");
        sb.append(this.b);
        sb.append(", dropSelectedCardForBnpl=");
        return AbstractC1901s.a(sb, this.c, ')');
    }

    public /* synthetic */ C1705k2(InterfaceC1850pm interfaceC1850pm, String str, boolean z, int i) {
        this(interfaceC1850pm, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }
}
