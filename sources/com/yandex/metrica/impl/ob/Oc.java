package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationManager;

/* loaded from: classes3.dex */
public class Oc {
    private final LocationManager a;
    private final H2 b;
    private final Xj c = F0.g().v();

    public Oc(Context context) {
        this.a = (LocationManager) context.getSystemService("location");
        this.b = H2.a(context);
    }

    public LocationManager a() {
        return this.a;
    }

    public Xj b() {
        return this.c;
    }

    public H2 c() {
        return this.b;
    }
}
