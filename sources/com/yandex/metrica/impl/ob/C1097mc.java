package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.mc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1097mc {
    public final long a;
    public final float b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final Xb m;
    public final Xb n;
    public final Xb o;
    public final Xb p;
    public final C0848cc q;

    public C1097mc(long j, float f, int i, int i2, long j2, int i3, boolean z, long j3, boolean z2, boolean z3, boolean z4, boolean z5, Xb xb, Xb xb2, Xb xb3, Xb xb4, C0848cc c0848cc) {
        this.a = j;
        this.b = f;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
        this.g = z;
        this.h = j3;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = z5;
        this.m = xb;
        this.n = xb2;
        this.o = xb3;
        this.p = xb4;
        this.q = c0848cc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1097mc.class != obj.getClass()) {
            return false;
        }
        C1097mc c1097mc = (C1097mc) obj;
        if (this.a != c1097mc.a || Float.compare(c1097mc.b, this.b) != 0 || this.c != c1097mc.c || this.d != c1097mc.d || this.e != c1097mc.e || this.f != c1097mc.f || this.g != c1097mc.g || this.h != c1097mc.h || this.i != c1097mc.i || this.j != c1097mc.j || this.k != c1097mc.k || this.l != c1097mc.l) {
            return false;
        }
        Xb xb = this.m;
        if (xb == null ? c1097mc.m != null : !xb.equals(c1097mc.m)) {
            return false;
        }
        Xb xb2 = this.n;
        if (xb2 == null ? c1097mc.n != null : !xb2.equals(c1097mc.n)) {
            return false;
        }
        Xb xb3 = this.o;
        if (xb3 == null ? c1097mc.o != null : !xb3.equals(c1097mc.o)) {
            return false;
        }
        Xb xb4 = this.p;
        if (xb4 == null ? c1097mc.p != null : !xb4.equals(c1097mc.p)) {
            return false;
        }
        C0848cc c0848cc = this.q;
        C0848cc c0848cc2 = c1097mc.q;
        return c0848cc != null ? c0848cc.equals(c0848cc2) : c0848cc2 == null;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        float f = this.b;
        int iFloatToIntBits = (((((i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.c) * 31) + this.d) * 31;
        long j2 = this.e;
        int i2 = (((((iFloatToIntBits + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f) * 31) + (this.g ? 1 : 0)) * 31;
        long j3 = this.h;
        int i3 = (((((((((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31;
        Xb xb = this.m;
        int iHashCode = (i3 + (xb != null ? xb.hashCode() : 0)) * 31;
        Xb xb2 = this.n;
        int iHashCode2 = (iHashCode + (xb2 != null ? xb2.hashCode() : 0)) * 31;
        Xb xb3 = this.o;
        int iHashCode3 = (iHashCode2 + (xb3 != null ? xb3.hashCode() : 0)) * 31;
        Xb xb4 = this.p;
        int iHashCode4 = (iHashCode3 + (xb4 != null ? xb4.hashCode() : 0)) * 31;
        C0848cc c0848cc = this.q;
        return iHashCode4 + (c0848cc != null ? c0848cc.hashCode() : 0);
    }

    public String toString() {
        return "LocationArguments{updateTimeInterval=" + this.a + ", updateDistanceInterval=" + this.b + ", recordsCountToForceFlush=" + this.c + ", maxBatchSize=" + this.d + ", maxAgeToForceFlush=" + this.e + ", maxRecordsToStoreLocally=" + this.f + ", collectionEnabled=" + this.g + ", lbsUpdateTimeInterval=" + this.h + ", lbsCollectionEnabled=" + this.i + ", passiveCollectionEnabled=" + this.j + ", allCellsCollectingEnabled=" + this.k + ", connectedCellCollectingEnabled=" + this.l + ", wifiAccessConfig=" + this.m + ", lbsAccessConfig=" + this.n + ", gpsAccessConfig=" + this.o + ", passiveAccessConfig=" + this.p + ", gplConfig=" + this.q + '}';
    }
}
