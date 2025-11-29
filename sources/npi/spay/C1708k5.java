package npi.spay;

/* renamed from: npi.spay.k5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1708k5 extends AbstractC1733l5 {
    public final boolean a;

    public C1708k5(boolean z) {
        super(0);
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1708k5) && this.a == ((C1708k5) obj).a;
    }

    public final int hashCode() {
        boolean z = this.a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("UpdateCheckBoxAgreementStatus(isChecked="), this.a, ')');
    }
}
