package com.yandex.metrica.impl.ob;

import android.content.Context;

@Deprecated
/* loaded from: classes3.dex */
public class Nd extends Kd {
    private static final Rd h = new Rd("SERVICE_API_LEVEL", null);
    private static final Rd i = new Rd("CLIENT_API_LEVEL", null);
    private Rd f;
    private Rd g;

    public Nd(Context context) {
        super(context, null);
        this.f = new Rd(h.b());
        this.g = new Rd(i.b());
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_migrationpreferences";
    }

    public int f() {
        return this.b.getInt(this.f.a(), -1);
    }

    public Nd g() {
        a(this.g.a());
        return this;
    }

    @Deprecated
    public Nd h() {
        a(this.f.a());
        return this;
    }
}
