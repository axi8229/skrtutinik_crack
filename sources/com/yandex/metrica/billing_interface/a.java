package com.yandex.metrica.billing_interface;

/* loaded from: classes3.dex */
public class a {
    public final e a;
    public final String b;
    public final String c;
    public final long d;
    public long e;

    public a(e eVar, String str, String str2, long j, long j2) {
        this.a = eVar;
        this.b = str;
        this.c = str2;
        this.d = j;
        this.e = j2;
    }

    public String toString() {
        return "BillingInfo{type=" + this.a + "sku='" + this.b + "'purchaseToken='" + this.c + "'purchaseTime=" + this.d + "sendTime=" + this.e + "}";
    }
}
