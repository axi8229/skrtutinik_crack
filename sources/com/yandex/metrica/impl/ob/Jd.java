package com.yandex.metrica.impl.ob;

import android.content.Context;

@Deprecated
/* loaded from: classes3.dex */
public class Jd extends Kd {
    public static final /* synthetic */ int j = 0;
    private final Rd f;
    private final Rd g;
    private final Rd h;
    private final Rd i;

    public Jd(Context context, String str) {
        super(context, str);
        this.f = new Rd("init_event_pref_key", c());
        this.g = new Rd("init_event_pref_key");
        this.h = new Rd("first_event_pref_key", c());
        this.i = new Rd("fitst_event_description_key", c());
    }

    private void a(Rd rd) {
        this.b.edit().remove(rd.a()).apply();
    }

    @Deprecated
    public String b(String str) {
        return this.b.getString(this.g.a(), null);
    }

    public String c(String str) {
        return this.b.getString(this.h.a(), null);
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_initpreferences";
    }

    public String d(String str) {
        return this.b.getString(this.f.a(), null);
    }

    @Deprecated
    public void f() {
        a(this.g);
    }

    public void g() {
        a(this.i);
    }

    public void h() {
        a(this.h);
    }

    public void i() {
        a(this.f);
    }

    public void j() {
        a(this.f.a(), "DONE").b();
    }
}
