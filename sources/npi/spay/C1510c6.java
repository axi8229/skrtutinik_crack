package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.c6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1510c6 extends AbstractC1535d6 {
    public final Bk a;

    public C1510c6(C2097zk c2097zk) {
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
        return (obj instanceof C1510c6) && Intrinsics.areEqual(this.a, ((C1510c6) obj).a);
    }

    public final int hashCode() {
        Bk bk = this.a;
        if (bk == null) {
            return 0;
        }
        return bk.hashCode();
    }

    public final String toString() {
        return "PaymentLoading(text=" + this.a + ')';
    }
}
