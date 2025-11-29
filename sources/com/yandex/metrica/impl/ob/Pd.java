package com.yandex.metrica.impl.ob;

import android.content.Context;

@Deprecated
/* loaded from: classes3.dex */
public class Pd extends Kd {
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
    static final Rd p = new Rd("PREF_KEY_DEVICE_ID_", null);
    static final Rd q = new Rd("PREF_KEY_UID_", null);
    private static final Rd r = new Rd("PREF_KEY_HOST_URL_", null);
    private static final Rd s = new Rd("PREF_KEY_REPORT_URL_", null);
    private static final Rd t = new Rd("PREF_KEY_GET_AD_URL", null);
    private static final Rd u = new Rd("PREF_KEY_REPORT_AD_URL", null);
    private static final Rd v = new Rd("PREF_KEY_STARTUP_OBTAIN_TIME_", null);
    private static final Rd w = new Rd("PREF_KEY_STARTUP_ENCODED_CLIDS_", null);
    private static final Rd x = new Rd("PREF_KEY_DISTRIBUTION_REFERRER_", null);
    static final Rd y = new Rd("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_", null);
    static final Rd z = new Rd("PREF_KEY_PINNING_UPDATE_URL", null);
    private static final Rd A = new Rd("PREF_KEY_EASY_COLLECTING_ENABLED_", null);

    public Pd(Context context) {
        this(context, null);
    }

    public long a(long j) {
        return this.b.getLong(this.l.a(), j);
    }

    public String b(String str) {
        return this.b.getString(this.f.a(), null);
    }

    public String c(String str) {
        return this.b.getString(this.m.a(), null);
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_startupserviceinfopreferences";
    }

    public String d(String str) {
        return this.b.getString(this.j.a(), null);
    }

    public String e(String str) {
        return this.b.getString(this.h.a(), null);
    }

    public String f(String str) {
        return this.b.getString(this.k.a(), null);
    }

    public String g(String str) {
        return this.b.getString(this.i.a(), null);
    }

    public String h(String str) {
        return this.b.getString(this.g.a(), null);
    }

    public Pd i(String str) {
        return (Pd) a(this.f.a(), str);
    }

    public Pd j(String str) {
        return (Pd) a(this.g.a(), str);
    }

    public Pd(Context context, String str) {
        super(context, str);
        this.f = new Rd(p.b());
        this.g = new Rd(q.b(), c());
        this.h = new Rd(r.b(), c());
        this.i = new Rd(s.b(), c());
        this.j = new Rd(t.b(), c());
        this.k = new Rd(u.b(), c());
        this.l = new Rd(v.b(), c());
        this.m = new Rd(w.b(), c());
        this.n = new Rd(x.b(), c());
        this.o = new Rd(A.b(), c());
    }

    public static void b(Context context) {
        C0810b.a(context, "_startupserviceinfopreferences").edit().remove(p.b()).apply();
    }

    public void f() {
        a(this.f.a()).a(this.g.a()).a(this.h.a()).a(this.i.a()).a(this.j.a()).a(this.k.a()).a(this.l.a()).a(this.o.a()).a(this.m.a()).a(this.n.b()).a(y.b()).a(z.b()).b();
    }
}
