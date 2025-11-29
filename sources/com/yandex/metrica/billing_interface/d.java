package com.yandex.metrica.billing_interface;

/* loaded from: classes3.dex */
public class d {
    public final e a;
    public final String b;
    public final int c;
    public final long d;
    public final String e;
    public final long f;
    public final c g;
    public final int h;
    public final c i;
    public final String j;
    public final String k;
    public final long l;
    public final boolean m;
    public final String n;

    public d(e eVar, String str, int i, long j, String str2, long j2, c cVar, int i2, c cVar2, String str3, String str4, long j3, boolean z, String str5) {
        this.a = eVar;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = str2;
        this.f = j2;
        this.g = cVar;
        this.h = i2;
        this.i = cVar2;
        this.j = str3;
        this.k = str4;
        this.l = j3;
        this.m = z;
        this.n = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.c != dVar.c || this.d != dVar.d || this.f != dVar.f || this.h != dVar.h || this.l != dVar.l || this.m != dVar.m || this.a != dVar.a || !this.b.equals(dVar.b) || !this.e.equals(dVar.e)) {
            return false;
        }
        c cVar = this.g;
        if (cVar == null ? dVar.g != null : !cVar.equals(dVar.g)) {
            return false;
        }
        c cVar2 = this.i;
        if (cVar2 == null ? dVar.i != null : !cVar2.equals(dVar.i)) {
            return false;
        }
        if (this.j.equals(dVar.j) && this.k.equals(dVar.k)) {
            return this.n.equals(dVar.n);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        long j = this.d;
        int iHashCode2 = (((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.e.hashCode()) * 31;
        long j2 = this.f;
        int i = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        c cVar = this.g;
        int iHashCode3 = (((i + (cVar != null ? cVar.hashCode() : 0)) * 31) + this.h) * 31;
        c cVar2 = this.i;
        int iHashCode4 = (((((iHashCode3 + (cVar2 != null ? cVar2.hashCode() : 0)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        long j3 = this.l;
        return ((((iHashCode4 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.m ? 1 : 0)) * 31) + this.n.hashCode();
    }

    public String toString() {
        return "ProductInfo{type=" + this.a + ", sku='" + this.b + "', quantity=" + this.c + ", priceMicros=" + this.d + ", priceCurrency='" + this.e + "', introductoryPriceMicros=" + this.f + ", introductoryPricePeriod=" + this.g + ", introductoryPriceCycles=" + this.h + ", subscriptionPeriod=" + this.i + ", signature='" + this.j + "', purchaseToken='" + this.k + "', purchaseTime=" + this.l + ", autoRenewing=" + this.m + ", purchaseOriginalJson='" + this.n + "'}";
    }
}
