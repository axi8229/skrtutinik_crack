package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.TimeProvider;

/* loaded from: classes3.dex */
public class X0 {
    private final TimeProvider a;
    private final C1353x2 b;
    private final C0895e9 c;
    private long d;
    private Zh e;
    private final M0 f;

    X0(C0895e9 c0895e9, Zh zh, TimeProvider timeProvider, C1353x2 c1353x2, M0 m0) {
        this.c = c0895e9;
        this.e = zh;
        this.d = c0895e9.d(0L);
        this.a = timeProvider;
        this.b = c1353x2;
        this.f = m0;
    }

    public void a() {
        Zh zh = this.e;
        if (zh == null || !this.b.b(this.d, zh.a, "should send EVENT_IDENTITY_LIGHT")) {
            return;
        }
        this.f.b();
        long jCurrentTimeSeconds = this.a.currentTimeSeconds();
        this.d = jCurrentTimeSeconds;
        this.c.i(jCurrentTimeSeconds);
    }

    public void a(Zh zh) {
        this.e = zh;
    }
}
