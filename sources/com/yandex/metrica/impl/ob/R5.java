package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.X5;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class R5 implements U5<W5> {
    private final L3 a;
    private final C0792a6 b;
    private final C0892e6 c;
    private final Z5 d;
    private final M0 e;
    private final SystemTimeProvider f;

    public R5(L3 l3, C0792a6 c0792a6, C0892e6 c0892e6, Z5 z5, M0 m0, SystemTimeProvider systemTimeProvider) {
        this.a = l3;
        this.b = c0792a6;
        this.c = c0892e6;
        this.d = z5;
        this.e = m0;
        this.f = systemTimeProvider;
    }

    public V5 a(Object obj) {
        W5 w5 = (W5) obj;
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        L3 l3 = this.a;
        C0892e6 c0892e6 = this.c;
        long jA = this.b.a();
        C0892e6 c0892e6D = this.c.d(jA);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c0892e6D.e(timeUnit.toSeconds(w5.a)).a(w5.a).c(0L).a(true).b();
        this.a.i().a(jA, this.d.b(), timeUnit.toSeconds(w5.b));
        return new V5(l3, c0892e6, a(), new SystemTimeProvider());
    }

    public final V5 b() {
        if (this.c.h()) {
            return new V5(this.a, this.c, a(), this.f);
        }
        return null;
    }

    X5 a() {
        X5.b bVarD = new X5.b(this.d).a(this.c.i()).b(this.c.e()).a(this.c.c()).c(this.c.f()).d(this.c.g());
        bVarD.a = this.c.d();
        return new X5(bVarD);
    }
}
