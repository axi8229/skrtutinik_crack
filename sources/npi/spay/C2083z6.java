package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.z6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2083z6 {
    public final Bk a;
    public final String b;
    public final int c;
    public final Integer d;
    public final String e;
    public final Integer f;
    public final String g;
    public final boolean h;
    public final Integer i;

    public C2083z6(Bk title, String name, int i, Integer num, String number, Integer num2, String str, boolean z, Integer num3) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = title;
        this.b = name;
        this.c = i;
        this.d = num;
        this.e = number;
        this.f = num2;
        this.g = str;
        this.h = z;
        this.i = num3;
    }

    public Integer a() {
        return this.f;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2083z6)) {
            return false;
        }
        C2083z6 c2083z6 = (C2083z6) obj;
        return Intrinsics.areEqual(h(), c2083z6.h()) && Intrinsics.areEqual(b(), c2083z6.b()) && d() == c2083z6.d() && Intrinsics.areEqual(f(), c2083z6.f()) && Intrinsics.areEqual(c(), c2083z6.c()) && Intrinsics.areEqual(a(), c2083z6.a()) && Intrinsics.areEqual(this.g, c2083z6.g) && Intrinsics.areEqual(g(), c2083z6.g());
    }

    public Integer f() {
        return this.d;
    }

    public Integer g() {
        return this.i;
    }

    public Bk h() {
        return this.a;
    }

    public int hashCode() {
        int iD = (d() + ((b().hashCode() + (h().hashCode() * 31)) * 31)) * 31;
        Integer numF = f();
        int iHashCode = (c().hashCode() + ((iD + (numF != null ? numF.intValue() : 0)) * 31)) * 31;
        Integer numA = a();
        int iIntValue = (iHashCode + (numA != null ? numA.intValue() : 0)) * 31;
        String str = this.g;
        int iHashCode2 = (iIntValue + (str != null ? str.hashCode() : 0)) * 31;
        Integer numG = g();
        return iHashCode2 + (numG != null ? numG.hashCode() : 0);
    }

    public String toString() {
        return "CardPresentationData(title=" + h() + ", name='" + b() + "', numberResId=" + d() + ", pluralsResId=" + f() + ", number='" + c() + "', cardsCount=" + a() + ", image=" + this.g + ", precalculateBonuses=" + g() + ')';
    }

    public /* synthetic */ C2083z6(Bk bk, String str, int i, Integer num, String str2, Integer num2, String str3, boolean z, Integer num3, int i2) {
        this(bk, str, i, (i2 & 8) != 0 ? null : num, str2, (i2 & 32) != 0 ? null : num2, str3, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? null : num3);
    }
}
