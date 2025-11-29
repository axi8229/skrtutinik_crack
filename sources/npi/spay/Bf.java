package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Bf {
    public final Ak a;
    public final String b;

    public Bf(Ak name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = name;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bf)) {
            return false;
        }
        Bf bf = (Bf) obj;
        return Intrinsics.areEqual(this.a, bf.a) && Intrinsics.areEqual(this.b, bf.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MerchantData(name=");
        sb.append(this.a);
        sb.append(", logo=");
        return Q1.a(sb, this.b, ')');
    }
}
