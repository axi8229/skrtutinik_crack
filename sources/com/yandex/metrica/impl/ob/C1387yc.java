package com.yandex.metrica.impl.ob;

import android.location.Location;

/* renamed from: com.yandex.metrica.impl.ob.yc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1387yc {
    private C1097mc a;
    private V b;
    private Location c = null;
    private long d;
    private C1353x2 e;
    private Sc f;
    private Rb g;

    C1387yc(C1097mc c1097mc, V v, Location location, long j, C1353x2 c1353x2, Sc sc, Rb rb) {
        this.a = c1097mc;
        this.b = v;
        this.d = j;
        this.e = c1353x2;
        this.f = sc;
        this.g = rb;
    }

    private boolean b(Location location) {
        C1097mc c1097mc;
        if (location == null || (c1097mc = this.a) == null) {
            return false;
        }
        if (this.c != null) {
            boolean zA = this.e.a(this.d, c1097mc.a, "isSavedLocationOutdated");
            boolean z = location.distanceTo(this.c) > this.a.b;
            boolean z2 = this.c == null || location.getTime() - this.c.getTime() >= 0;
            if ((!zA && !z) || !z2) {
                return false;
            }
        }
        return true;
    }

    public void a(Location location) {
        if (b(location)) {
            this.c = location;
            this.d = System.currentTimeMillis();
            this.b.a(location);
            this.f.a();
            this.g.a();
        }
    }

    public void a(C1097mc c1097mc) {
        this.a = c1097mc;
    }
}
