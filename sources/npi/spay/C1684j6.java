package npi.spay;

/* renamed from: npi.spay.j6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1684j6 implements Zd {
    public final boolean a;

    public C1684j6(boolean z) {
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1684j6) && this.a == ((C1684j6) obj).a;
    }

    public final int hashCode() {
        boolean z = this.a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("IsResultViewEnabledByMerchant(resultViewNeeded="), this.a, ')');
    }
}
