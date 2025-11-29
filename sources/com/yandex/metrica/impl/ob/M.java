package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Map;

/* loaded from: classes3.dex */
public class M {
    private final C1225ri a;
    private final C1362xb b;
    private final Context c;

    public M(C1225ri c1225ri, C1362xb c1362xb, Context context) {
        this.a = c1225ri;
        this.b = c1362xb;
        this.c = context;
    }

    public L a(Map<String, String> map) {
        return new L(this.a.d(), this.b.a(this.c, new Fb()), map);
    }
}
