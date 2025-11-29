package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class Hh {
    private final C0958gm a;
    private final long b;
    private long c;
    private long d;
    private long e;

    Hh(TimeProvider timeProvider, C0958gm c0958gm) {
        this.b = timeProvider.currentTimeMillis();
        this.a = c0958gm;
    }

    void a() {
        this.c = this.a.b(this.b, TimeUnit.MILLISECONDS);
    }

    void b() {
        this.d = this.a.b(this.b, TimeUnit.MILLISECONDS);
    }

    void c() {
        this.e = this.a.b(this.b, TimeUnit.MILLISECONDS);
    }

    long d() {
        return this.c;
    }

    long e() {
        return this.d;
    }

    long f() {
        return this.e;
    }
}
