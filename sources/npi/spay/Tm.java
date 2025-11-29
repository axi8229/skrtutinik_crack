package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Tm {
    public final C2097zk a;
    public final C2097zk b;

    public Tm(C2097zk amount, C2097zk c2097zk) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.a = amount;
        this.b = c2097zk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tm)) {
            return false;
        }
        Tm tm = (Tm) obj;
        return Intrinsics.areEqual(this.a, tm.a) && Intrinsics.areEqual(this.b, tm.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C2097zk c2097zk = this.b;
        return iHashCode + (c2097zk == null ? 0 : c2097zk.hashCode());
    }

    public final String toString() {
        return "BnplPaymentItem(amount=" + this.a + ", details=" + this.b + ')';
    }
}
