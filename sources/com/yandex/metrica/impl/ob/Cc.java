package com.yandex.metrica.impl.ob;

import android.location.LocationManager;

/* loaded from: classes3.dex */
public class Cc {
    public final Sb a;
    public final LocationManager b;
    public final C1097mc c;

    Cc(Sb sb, C1178pi c1178pi, C1097mc c1097mc, LocationManager locationManager, Sc sc, Rb rb) {
        this.a = sb;
        this.c = c1097mc;
        this.b = locationManager;
    }

    public static Cc a(Nc nc, Sc sc, Rb rb, LocationManager locationManager) {
        return new Cc(nc.a, nc.b, nc.c, locationManager, sc, rb);
    }
}
