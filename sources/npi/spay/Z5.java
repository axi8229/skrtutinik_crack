package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z5 extends AbstractC1535d6 {
    public final Bk a;

    public Z5(C2097zk c2097zk) {
        this.a = c2097zk;
    }

    @Override // npi.spay.AbstractC1535d6
    public final Bk a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Z5) && Intrinsics.areEqual(this.a, ((Z5) obj).a);
    }

    public final int hashCode() {
        Bk bk = this.a;
        if (bk == null) {
            return 0;
        }
        return bk.hashCode();
    }

    public final String toString() {
        return "FullEmissionLoading(text=" + this.a + ')';
    }
}
