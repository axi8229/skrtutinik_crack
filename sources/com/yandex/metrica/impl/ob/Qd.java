package com.yandex.metrica.impl.ob;

import android.content.Context;

@Deprecated
/* loaded from: classes3.dex */
public class Qd extends Kd {
    private Rd f;

    public Qd(Context context, String str) {
        super(context, null);
        this.f = new Rd("LOCATION_TRACKING_ENABLED");
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_serviceproviderspreferences";
    }

    public boolean f() {
        return this.b.getBoolean(this.f.a(), false);
    }

    public void g() {
        a(this.f.a()).b();
    }
}
