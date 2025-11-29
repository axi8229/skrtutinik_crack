package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.impl.ob.M3;

/* renamed from: com.yandex.metrica.impl.ob.a4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0790a4 {
    private final C0845c9 a;
    private final C0819b8 b;
    private C0817b6 c;
    private L7 d;
    private final Dm e;
    private final C0967h6 f;
    private final C1230s g;
    private final O3 h;
    private a i;
    private final TimeProvider j;
    private final int k;
    private long l;
    private long m;
    private int n;

    /* renamed from: com.yandex.metrica.impl.ob.a4$a */
    public interface a {
    }

    public C0790a4(C0845c9 c0845c9, C0819b8 c0819b8, C0817b6 c0817b6, L7 l7, C1230s c1230s, Dm dm, C0967h6 c0967h6, int i, a aVar, O3 o3, TimeProvider timeProvider) {
        this.a = c0845c9;
        this.b = c0819b8;
        this.c = c0817b6;
        this.d = l7;
        this.g = c1230s;
        this.e = dm;
        this.f = c0967h6;
        this.k = i;
        this.h = o3;
        this.j = timeProvider;
        this.i = aVar;
        this.l = c0845c9.b(0L);
        this.m = c0845c9.l();
        this.n = c0845c9.i();
    }

    public void a(C0836c0 c0836c0) {
        this.c.c(c0836c0);
    }

    public void b(C0836c0 c0836c0) {
        a(c0836c0, this.c.b(c0836c0));
    }

    public void c(C0836c0 c0836c0) {
        a(c0836c0, this.c.b(c0836c0));
        int i = this.k;
        this.n = i;
        this.a.a(i).d();
    }

    public void d(C0836c0 c0836c0) {
        a(c0836c0, this.c.b(c0836c0));
        long jCurrentTimeSeconds = this.j.currentTimeSeconds();
        this.l = jCurrentTimeSeconds;
        this.a.c(jCurrentTimeSeconds).d();
    }

    public void e(C0836c0 c0836c0) {
        a(c0836c0, this.c.b(c0836c0));
        long jCurrentTimeSeconds = this.j.currentTimeSeconds();
        this.m = jCurrentTimeSeconds;
        this.a.e(jCurrentTimeSeconds).d();
    }

    public void f(C0836c0 c0836c0) {
        a(c0836c0, this.c.f(c0836c0));
    }

    public void a(C0836c0 c0836c0, C0842c6 c0842c6) {
        if (TextUtils.isEmpty(c0836c0.p())) {
            c0836c0.e(this.a.n());
        }
        c0836c0.i().putAll(this.f.a());
        c0836c0.d(this.a.m());
        c0836c0.a(Integer.valueOf(this.b.e()));
        this.d.a(this.e.a(c0836c0).a(c0836c0), c0836c0.o(), c0842c6, this.g.a(), this.h);
        ((M3.a) this.i).a.g();
    }

    public void b() {
        int i = this.k;
        this.n = i;
        this.a.a(i).d();
    }

    public boolean c() {
        return this.n < this.k;
    }

    public boolean d() {
        return this.j.currentTimeSeconds() - this.l > Y5.a;
    }

    public long a() {
        return this.m;
    }
}
