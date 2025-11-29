package com.yandex.metrica.impl.ob;

import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.di, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0879di {
    public final long a;
    public final String b;
    public final List<Integer> c;
    public final List<Integer> d;
    public final long e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;

    public C0879di(long j, String str, List<Integer> list, List<Integer> list2, long j2, int i, long j3, long j4, long j5, long j6) {
        this.a = j;
        this.b = str;
        this.c = A2.c(list);
        this.d = A2.c(list2);
        this.e = j2;
        this.f = i;
        this.g = j3;
        this.h = j4;
        this.i = j5;
        this.j = j6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0879di.class != obj.getClass()) {
            return false;
        }
        C0879di c0879di = (C0879di) obj;
        if (this.a == c0879di.a && this.e == c0879di.e && this.f == c0879di.f && this.g == c0879di.g && this.h == c0879di.h && this.i == c0879di.i && this.j == c0879di.j && this.b.equals(c0879di.b) && this.c.equals(c0879di.c)) {
            return this.d.equals(c0879di.d);
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = ((((((((int) (j ^ (j >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long j2 = this.e;
        int i = (((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f) * 31;
        long j3 = this.g;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.h;
        int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.i;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.j;
        return i4 + ((int) ((j6 >>> 32) ^ j6));
    }

    public String toString() {
        return "SocketConfig{secondsToLive=" + this.a + ", token='" + this.b + "', ports=" + this.c + ", portsHttp=" + this.d + ", firstDelaySeconds=" + this.e + ", launchDelaySeconds=" + this.f + ", openEventIntervalSeconds=" + this.g + ", minFailedRequestIntervalSeconds=" + this.h + ", minSuccessfulRequestIntervalSeconds=" + this.i + ", openRetryIntervalSeconds=" + this.j + '}';
    }
}
