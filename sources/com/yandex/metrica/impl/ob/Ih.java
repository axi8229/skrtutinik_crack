package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Ih {
    private long a;
    private long b;
    private final TimeProvider c;
    private final C0958gm d;

    Ih() {
        this(new SystemTimeProvider(), new C0958gm());
    }

    synchronized double a() {
        return this.d.b(this.b, TimeUnit.MILLISECONDS);
    }

    synchronized double b() {
        return this.d.b(this.a, TimeUnit.MILLISECONDS);
    }

    synchronized void c() {
        this.b = this.c.currentTimeMillis();
    }

    synchronized void d() {
        this.a = this.c.currentTimeMillis();
    }

    synchronized void e() {
        this.b = 0L;
    }

    Ih(TimeProvider timeProvider, C0958gm c0958gm) {
        this.c = timeProvider;
        this.d = c0958gm;
    }
}
