package npi.spay;

/* renamed from: npi.spay.v6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1983v6 extends AbstractC2008w6 {
    public final boolean a;

    public C1983v6(boolean z) {
        super(z);
        this.a = z;
    }

    @Override // npi.spay.AbstractC2008w6
    public final boolean a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1983v6) && this.a == ((C1983v6) obj).a;
    }

    public final int hashCode() {
        boolean z = this.a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("IsEnabledByUser(value="), this.a, ')');
    }
}
