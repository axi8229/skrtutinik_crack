package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.fm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0933fm implements Q0 {
    private volatile long a;
    private C0895e9 b;
    private TimeProvider c;

    /* renamed from: com.yandex.metrica.impl.ob.fm$b */
    private static class b {
        static C0933fm a = new C0933fm();
    }

    public static C0933fm c() {
        return b.a;
    }

    @Override // com.yandex.metrica.impl.ob.Q0
    public synchronized long a() {
        return this.a;
    }

    public synchronized void b() {
        this.b.c(false);
        this.b.d();
    }

    public synchronized void d() {
        C0895e9 c0895e9S = F0.g().s();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.b = c0895e9S;
        this.a = c0895e9S.b(0);
        this.c = systemTimeProvider;
    }

    public synchronized boolean e() {
        return this.b.a(true);
    }

    private C0933fm() {
    }

    public synchronized void a(long j, Long l) {
        try {
            this.a = (j - this.c.currentTimeMillis()) / 1000;
            boolean z = true;
            if (this.b.a(true)) {
                if (l != null) {
                    long jAbs = Math.abs(j - this.c.currentTimeMillis());
                    C0895e9 c0895e9 = this.b;
                    if (jAbs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                        z = false;
                    }
                    c0895e9.c(z);
                } else {
                    this.b.c(false);
                }
            }
            this.b.l(this.a);
            this.b.d();
        } catch (Throwable th) {
            throw th;
        }
    }
}
