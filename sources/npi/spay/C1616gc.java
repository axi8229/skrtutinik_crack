package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.gc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1616gc {
    public final C2097zk a;
    public final Ak b;

    public C1616gc(C2097zk amount, Ak merchantName) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(merchantName, "merchantName");
        this.a = amount;
        this.b = merchantName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1616gc)) {
            return false;
        }
        C1616gc c1616gc = (C1616gc) obj;
        return Intrinsics.areEqual(this.a, c1616gc.a) && Intrinsics.areEqual(this.b, c1616gc.b);
    }

    public final int hashCode() {
        return this.b.a.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "OrderData(amount=" + this.a + ", merchantName=" + this.b + ')';
    }
}
