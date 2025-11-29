package com.yandex.metrica.impl.ob;

import android.content.Context;

@Deprecated
/* loaded from: classes3.dex */
public class Od extends Kd {
    private static final Rd g = new Rd("PREF_KEY_OFFSET", null);
    private Rd f;

    public Od(Context context, String str) {
        super(context, str);
        this.f = new Rd(g.b(), null);
    }

    public long a(int i) {
        return this.b.getLong(this.f.a(), i);
    }

    @Override // com.yandex.metrica.impl.ob.Kd
    protected String d() {
        return "_servertimeoffset";
    }

    public void f() {
        a(this.f.a()).b();
    }
}
