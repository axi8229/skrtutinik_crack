package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.ym.MessageNano;
import com.huawei.hms.android.SystemUtils;

/* renamed from: com.yandex.metrica.impl.ob.dg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0877dg {
    public final String a;
    public final long b;
    public final long c;
    public final a d;

    /* renamed from: com.yandex.metrica.impl.ob.dg$a */
    public enum a {
        UNKNOWN(SystemUtils.UNKNOWN),
        GP("gpl"),
        HMS("hms-content-provider");

        public final String a;

        a(String str) {
            this.a = str;
        }
    }

    private C0877dg(byte[] bArr) throws InvalidProtocolBufferNanoException {
        C1270tf c1270tfA = C1270tf.a(bArr);
        this.a = c1270tfA.a;
        this.b = c1270tfA.c;
        this.c = c1270tfA.b;
        this.d = a(c1270tfA.d);
    }

    public static C0877dg a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        if (A2.a(bArr)) {
            return null;
        }
        return new C0877dg(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0877dg.class != obj.getClass()) {
            return false;
        }
        C0877dg c0877dg = (C0877dg) obj;
        return this.b == c0877dg.b && this.c == c0877dg.c && this.a.equals(c0877dg.a) && this.d == c0877dg.d;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        long j = this.b;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ReferrerInfo{installReferrer='" + this.a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + '}';
    }

    public byte[] a() {
        C1270tf c1270tf = new C1270tf();
        c1270tf.a = this.a;
        c1270tf.c = this.b;
        c1270tf.b = this.c;
        int iOrdinal = this.d.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 0;
            }
        }
        c1270tf.d = i;
        return MessageNano.toByteArray(c1270tf);
    }

    public C0877dg(String str, long j, long j2, a aVar) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = aVar;
    }

    private a a(int i) {
        if (i == 1) {
            return a.GP;
        }
        if (i != 2) {
            return a.UNKNOWN;
        }
        return a.HMS;
    }
}
