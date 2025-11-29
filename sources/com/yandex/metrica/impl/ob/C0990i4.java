package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;

/* renamed from: com.yandex.metrica.impl.ob.i4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0990i4 {
    private final String a;
    private final String b;
    private final Integer c;
    private final String d;
    private final CounterConfiguration.b e;

    public C0990i4(String str, String str2, Integer num, String str3, CounterConfiguration.b bVar) {
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = bVar;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Integer c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public CounterConfiguration.b e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0990i4.class != obj.getClass()) {
            return false;
        }
        C0990i4 c0990i4 = (C0990i4) obj;
        String str = this.a;
        if (str == null ? c0990i4.a != null : !str.equals(c0990i4.a)) {
            return false;
        }
        if (!this.b.equals(c0990i4.b)) {
            return false;
        }
        Integer num = this.c;
        if (num == null ? c0990i4.c != null : !num.equals(c0990i4.c)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? c0990i4.d == null : str2.equals(c0990i4.d)) {
            return this.e == c0990i4.e;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ClientDescription{mApiKey='" + this.a + "', mPackageName='" + this.b + "', mProcessID=" + this.c + ", mProcessSessionID='" + this.d + "', mReporterType=" + this.e + '}';
    }

    public static C0990i4 a(C1402z3 c1402z3) {
        return new C0990i4(c1402z3.b().a(), c1402z3.a().f(), c1402z3.a().g(), c1402z3.a().h(), c1402z3.b().k());
    }
}
