package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.lk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1080lk {
    private final C0820b9 a;
    private long b;

    C1080lk(C0820b9 c0820b9) {
        this.a = c0820b9;
        this.b = c0820b9.c(-1L);
    }

    long a() {
        C0820b9 c0820b9 = this.a;
        long j = this.b + 1;
        this.b = j;
        c0820b9.f(j);
        return this.b;
    }
}
