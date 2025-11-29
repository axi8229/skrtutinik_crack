package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.zb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1410zb {
    private final C1290ub a;
    private final C1290ub b;
    private final C1290ub c;

    public C1410zb() {
        this(new C1290ub(), new C1290ub(), new C1290ub());
    }

    public C1290ub a() {
        return this.a;
    }

    public C1290ub b() {
        return this.b;
    }

    public C1290ub c() {
        return this.c;
    }

    public String toString() {
        return "AdvertisingIdsHolder{mGoogle=" + this.a + ", mHuawei=" + this.b + ", yandex=" + this.c + '}';
    }

    public C1410zb(C1290ub c1290ub, C1290ub c1290ub2, C1290ub c1290ub3) {
        this.a = c1290ub;
        this.b = c1290ub2;
        this.c = c1290ub3;
    }
}
