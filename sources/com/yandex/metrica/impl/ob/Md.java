package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.C1230s;

@Deprecated
/* loaded from: classes3.dex */
public class Md extends Kd {
    private Rd f;
    private Rd g;
    private Rd h;
    private Rd i;
    private Rd j;
    private Rd k;
    private Rd l;
    private Rd m;
    private Rd n;
    private Rd o;
    private Rd p;
    private Rd q;
    private Rd r;
    private Rd s;
    private Rd t;
    private static final Rd u = new Rd("SESSION_SLEEP_START_", null);
    private static final Rd v = new Rd("SESSION_ID_", null);
    private static final Rd w = new Rd("SESSION_COUNTER_ID_", null);
    private static final Rd x = new Rd("SESSION_INIT_TIME_", null);
    private static final Rd y = new Rd("SESSION_ALIVE_TIME_", null);
    private static final Rd z = new Rd("SESSION_IS_ALIVE_REPORT_NEEDED_", null);
    private static final Rd A = new Rd("BG_SESSION_ID_", null);
    private static final Rd B = new Rd("BG_SESSION_SLEEP_START_", null);
    private static final Rd C = new Rd("BG_SESSION_COUNTER_ID_", null);
    private static final Rd D = new Rd("BG_SESSION_INIT_TIME_", null);
    private static final Rd E = new Rd("IDENTITY_SEND_TIME_", null);
    private static final Rd F = new Rd("USER_INFO_", null);
    private static final Rd G = new Rd("REFERRER_", null);

    @Deprecated
    public static final Rd H = new Rd("APP_ENVIRONMENT", null);

    @Deprecated
    public static final Rd I = new Rd("APP_ENVIRONMENT_REVISION", null);
    private static final Rd J = new Rd("APP_ENVIRONMENT_", null);
    private static final Rd K = new Rd("APP_ENVIRONMENT_REVISION_", null);

    public Md(Context context, String str) {
        super(context, str);
        this.f = new Rd(u.b(), c());
        this.g = new Rd(v.b(), c());
        this.h = new Rd(w.b(), c());
        this.i = new Rd(x.b(), c());
        this.j = new Rd(y.b(), c());
        this.k = new Rd(z.b(), c());
        this.l = new Rd(A.b(), c());
        this.m = new Rd(B.b(), c());
        this.n = new Rd(C.b(), c());
        this.o = new Rd(D.b(), c());
        this.p = new Rd(E.b(), c());
        this.q = new Rd(F.b(), c());
        this.r = new Rd(G.b(), c());
        this.s = new Rd(J.b(), c());
        this.t = new Rd(K.b(), c());
        a(-1);
        c(0);
        b(0);
    }

    public long a(long j) {
        return this.b.getLong(this.o.a(), j);
    }

    public long b(long j) {
        return this.b.getLong(this.n.a(), j);
    }

    public long c(long j) {
        return this.b.getLong(this.l.a(), j);
    }

    public long d(long j) {
        return this.b.getLong(this.m.a(), j);
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_boundentrypreferences";
    }

    public long e(long j) {
        return this.b.getLong(this.i.a(), j);
    }

    public long f(long j) {
        return this.b.getLong(this.h.a(), j);
    }

    public long g(long j) {
        return this.b.getLong(this.g.a(), j);
    }

    public long h(long j) {
        return this.b.getLong(this.f.a(), j);
    }

    public long i(long j) {
        return this.b.getLong(this.p.a(), j);
    }

    private void c(int i) {
        C0810b.a(this.b, this.f.a(), i);
    }

    public Boolean a(boolean z2) {
        return Boolean.valueOf(this.b.getBoolean(this.k.a(), z2));
    }

    public String b(String str) {
        return this.b.getString(this.q.a(), null);
    }

    public C1230s.a f() {
        synchronized (this) {
            try {
                if (!this.b.contains(this.s.a()) || !this.b.contains(this.t.a())) {
                    return null;
                }
                return new C1230s.a(this.b.getString(this.s.a(), "{}"), this.b.getLong(this.t.a(), 0L));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean g() {
        return this.b.contains(this.i.a()) || this.b.contains(this.j.a()) || this.b.contains(this.k.a()) || this.b.contains(this.f.a()) || this.b.contains(this.g.a()) || this.b.contains(this.h.a()) || this.b.contains(this.o.a()) || this.b.contains(this.m.a()) || this.b.contains(this.l.a()) || this.b.contains(this.n.a()) || this.b.contains(this.s.a()) || this.b.contains(this.q.a()) || this.b.contains(this.r.a()) || this.b.contains(this.p.a());
    }

    public void h() {
        this.b.edit().remove(this.o.a()).remove(this.n.a()).remove(this.l.a()).remove(this.m.a()).remove(this.i.a()).remove(this.h.a()).remove(this.g.a()).remove(this.f.a()).remove(this.k.a()).remove(this.j.a()).remove(this.q.a()).remove(this.s.a()).remove(this.t.a()).remove(this.r.a()).remove(this.p.a()).apply();
    }

    public Md i() {
        return (Md) a(this.r.a());
    }

    private void b(int i) {
        C0810b.a(this.b, this.h.a(), i);
    }

    public Md a(C1230s.a aVar) {
        synchronized (this) {
            a(this.s.a(), aVar.a);
            a(this.t.a(), Long.valueOf(aVar.b));
        }
        return this;
    }

    private void a(int i) {
        C0810b.a(this.b, this.j.a(), i);
    }
}
