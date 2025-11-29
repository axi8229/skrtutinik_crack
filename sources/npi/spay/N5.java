package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class N5 extends C2083z6 {
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final Integer n;
    public final String o;
    public final Integer p;
    public final Bk q;
    public final String r;
    public final String s;
    public final boolean t;
    public final Integer u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N5(int i, int i2, int i3, int i4, Integer num, String number, Integer num2, Bk title, String name, String str, boolean z, Integer num3) {
        super(title, name, i4, num, number, num2, str, false, null, 384);
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(name, "name");
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        this.n = num;
        this.o = number;
        this.p = num2;
        this.q = title;
        this.r = name;
        this.s = str;
        this.t = z;
        this.u = num3;
    }

    @Override // npi.spay.C2083z6
    public final Integer a() {
        return this.p;
    }

    @Override // npi.spay.C2083z6
    public final String b() {
        return this.r;
    }

    @Override // npi.spay.C2083z6
    public final String c() {
        return this.o;
    }

    @Override // npi.spay.C2083z6
    public final int d() {
        return this.m;
    }

    @Override // npi.spay.C2083z6
    public final boolean e() {
        return this.t;
    }

    @Override // npi.spay.C2083z6
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M3)) {
            return false;
        }
        M3 m3 = (M3) obj;
        return this.j == m3.j && this.m == m3.m && Intrinsics.areEqual(this.n, m3.n) && Intrinsics.areEqual(this.o, m3.o) && Intrinsics.areEqual(this.p, m3.p) && Intrinsics.areEqual(this.q, m3.q) && Intrinsics.areEqual(this.r, m3.r) && Intrinsics.areEqual(this.s, m3.s) && Intrinsics.areEqual(this.u, m3.u);
    }

    @Override // npi.spay.C2083z6
    public final Integer f() {
        return this.n;
    }

    @Override // npi.spay.C2083z6
    public final Integer g() {
        return this.u;
    }

    @Override // npi.spay.C2083z6
    public final Bk h() {
        return this.q;
    }

    @Override // npi.spay.C2083z6
    public final int hashCode() {
        int i = ((this.j * 31) + this.m) * 31;
        Integer num = this.n;
        int iA = AbstractC1553e.a(this.o, (i + (num != null ? num.intValue() : 0)) * 31, 31);
        Integer num2 = this.p;
        int iA2 = AbstractC1553e.a(this.r, (this.q.hashCode() + ((iA + (num2 != null ? num2.intValue() : 0)) * 31)) * 31, 31);
        String str = this.s;
        int iHashCode = (iA2 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num3 = this.u;
        return iHashCode + (num3 != null ? num3.hashCode() : 0);
    }

    @Override // npi.spay.C2083z6
    public final String toString() {
        return "DisabledBankCard(paymentId=" + this.j + ", backgroundColor=" + this.k + ", statusImage=" + this.l + ", numberResId=" + this.m + ", pluralsResId=" + this.n + ", number='" + this.o + "', cardsCount=" + this.p + ", title=" + this.q + ", name='" + this.r + "', cardLogo=" + this.s + ", precalculatedBonuses='" + this.u + "')";
    }
}
