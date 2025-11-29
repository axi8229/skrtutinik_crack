package com.yandex.metrica.impl.ob;

import android.location.Location;

/* loaded from: classes3.dex */
public class Yb extends V {
    private final C1363xc b;

    public Yb(V v, C1363xc c1363xc) {
        super(v);
        this.b = c1363xc;
    }

    @Override // com.yandex.metrica.impl.ob.V
    public void b(Object obj) {
        Location location = (Location) obj;
        if (location != null) {
            this.b.b((C1363xc) location);
        }
    }
}
