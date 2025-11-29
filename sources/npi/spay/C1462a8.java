package npi.spay;

/* renamed from: npi.spay.a8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1462a8 {
    public final boolean a;

    public C1462a8(boolean z) {
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1462a8) && this.a == ((C1462a8) obj).a;
    }

    public final int hashCode() {
        boolean z = this.a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("BnplGraphSection(isCurrentPayment="), this.a, ')');
    }
}
