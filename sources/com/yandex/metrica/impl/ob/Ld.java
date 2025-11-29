package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class Ld extends Kd {
    private static final Rd l = new Rd("UUID", null);
    private static final Rd m = new Rd("DEVICEID_3", null);
    private static final Rd n = new Rd("AD_URL_GET", null);
    private static final Rd o = new Rd("AD_URL_REPORT", null);
    private static final Rd p = new Rd("HOST_URL", null);
    private static final Rd q = new Rd("SERVER_TIME_OFFSET", null);
    private static final Rd r = new Rd("CLIDS", null);
    private Rd f;
    private Rd g;
    private Rd h;
    private Rd i;
    private Rd j;
    private Rd k;

    public Ld(Context context) {
        super(context, null);
        this.f = new Rd(l.b());
        this.g = new Rd(m.b());
        this.h = new Rd(n.b());
        this.i = new Rd(o.b());
        new Rd(p.b());
        this.j = new Rd(q.b());
        this.k = new Rd(r.b());
    }

    public long a(long j) {
        return this.b.getLong(this.j.b(), j);
    }

    public String b(String str) {
        return this.b.getString(this.h.a(), null);
    }

    public String c(String str) {
        return this.b.getString(this.i.a(), null);
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_startupinfopreferences";
    }

    public String d(String str) {
        return this.b.getString(this.k.a(), null);
    }

    public String e(String str) {
        return this.b.getString(this.g.a(), null);
    }

    public String f(String str) {
        return this.b.getString(this.f.a(), null);
    }

    public Map<String, ?> g() {
        return this.b.getAll();
    }

    public Ld f() {
        return (Ld) e();
    }
}
