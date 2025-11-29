package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Jd {
    public final Bk a;
    public final long b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public Jd(Bk title, long j, String currency, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.a = title;
        this.b = j;
        this.c = currency;
        this.d = z;
        this.e = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Jd)) {
            return false;
        }
        Jd jd = (Jd) obj;
        return Intrinsics.areEqual(this.a, jd.a) && this.b == jd.b && Intrinsics.areEqual(this.c, jd.c) && this.d == jd.d && this.e == jd.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iA = AbstractC1553e.a(this.c, (Long.hashCode(this.b) + (this.a.hashCode() * 31)) * 31, 31);
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        boolean z2 = this.e;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BnplGraphStep(title=");
        sb.append(this.a);
        sb.append(", amount=");
        sb.append(this.b);
        sb.append(", currency=");
        sb.append(this.c);
        sb.append(", isBold=");
        sb.append(this.d);
        sb.append(", isLast=");
        return AbstractC1901s.a(sb, this.e, ')');
    }
}
