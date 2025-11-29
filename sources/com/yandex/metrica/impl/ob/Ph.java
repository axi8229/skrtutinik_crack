package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Ph {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public Ph(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Ph.class != obj.getClass()) {
            return false;
        }
        Ph ph = (Ph) obj;
        return this.a == ph.a && this.b == ph.b && this.c == ph.c && this.d == ph.d;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.c;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.d;
        return i2 + ((int) ((j4 >>> 32) ^ j4));
    }

    public String toString() {
        return "CacheControl{cellsAroundTtl=" + this.a + ", wifiNetworksTtl=" + this.b + ", lastKnownLocationTtl=" + this.c + ", netInterfacesTtl=" + this.d + '}';
    }
}
