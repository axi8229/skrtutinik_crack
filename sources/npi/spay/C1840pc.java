package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.pc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1840pc {
    public final C2097zk a;
    public final int b;
    public final String c;

    public C1840pc(C2097zk name, int i, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = name;
        this.b = i;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1840pc)) {
            return false;
        }
        C1840pc c1840pc = (C1840pc) obj;
        return Intrinsics.areEqual(this.a, c1840pc.a) && this.b == c1840pc.b && Intrinsics.areEqual(this.c, c1840pc.c) && Intrinsics.areEqual(null, null);
    }

    public final int hashCode() {
        int iHashCode = (Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        return (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
    }

    public final String toString() {
        return "UserData(name=" + this.a + ", icon=" + this.b + ", phone=" + this.c + ", email=null)";
    }
}
