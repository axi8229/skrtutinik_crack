package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Kd {
    public final long a;
    public final String b;

    public Kd(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Kd)) {
            return false;
        }
        Kd kd = (Kd) obj;
        return this.a == kd.a && Intrinsics.areEqual(this.b, kd.b);
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BnplSum(sum=");
        sb.append(this.a);
        sb.append(", currency=");
        return Q1.a(sb, this.b, ')');
    }
}
