package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Xc implements J0 {
    private final C0895e9 a;
    private final C1353x2 b;
    private Xb c;
    private final H2 d;
    private final TimeProvider e;
    private final a f;
    private final Wc g;

    static class a {
        a() {
        }
    }

    public Xc(Context context, Xb xb) {
        this(xb, H2.a(context));
    }

    public void a(Xb xb) {
        if (A2.a(this.c, xb)) {
            return;
        }
        this.c = xb;
        if (xb == null || !xb.a.a) {
            return;
        }
        this.g.a(this.d.b());
    }

    public void b() {
        Xb xb = this.c;
        if (xb == null || xb.b == null || !this.b.b(this.a.f(0L), this.c.b.b, "last wifi scan attempt time")) {
            return;
        }
        this.f.getClass();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (this.d.a(countDownLatch, this.g)) {
            this.a.k(this.e.currentTimeSeconds());
            try {
                countDownLatch.await(5L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
    }

    private Xc(Xb xb, H2 h2) {
        this(h2, F0.g().s(), new C1353x2(), new SystemTimeProvider(), new a(), xb, new Wc(null, h2.a()));
    }

    @Override // com.yandex.metrica.impl.ob.J0
    public void a() {
        Xb xb = this.c;
        if (xb == null || !xb.a.a) {
            return;
        }
        this.g.a(this.d.b());
    }

    Xc(H2 h2, C0895e9 c0895e9, C1353x2 c1353x2, TimeProvider timeProvider, a aVar, Xb xb, Wc wc) {
        this.d = h2;
        this.a = c0895e9;
        this.b = c1353x2;
        this.f = aVar;
        this.c = xb;
        this.e = timeProvider;
        this.g = wc;
    }
}
