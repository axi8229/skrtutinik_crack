package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.ci, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0854ci {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public C0854ci(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0854ci.class != obj.getClass()) {
            return false;
        }
        C0854ci c0854ci = (C0854ci) obj;
        return this.a == c0854ci.a && this.b == c0854ci.b && this.c == c0854ci.c && this.d == c0854ci.d;
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
        return "SdkFingerprintingConfig{minCollectingInterval=" + this.a + ", minFirstCollectingDelay=" + this.b + ", minCollectingDelayAfterLaunch=" + this.c + ", minRequestRetryInterval=" + this.d + '}';
    }
}
