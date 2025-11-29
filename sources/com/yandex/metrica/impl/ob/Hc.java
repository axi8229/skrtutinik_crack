package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.E;

/* loaded from: classes3.dex */
public class Hc {
    public final C1147oc.a a;
    private Long b;
    private long c;
    private long d;
    private Location e;
    private E.b.a f;

    public Hc(C1147oc.a aVar, long j, long j2, Location location, E.b.a aVar2, Long l) {
        this.a = aVar;
        this.b = l;
        this.c = j;
        this.d = j2;
        this.e = location;
        this.f = aVar2;
    }

    public E.b.a a() {
        return this.f;
    }

    public Long b() {
        return this.b;
    }

    public Location c() {
        return this.e;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.c;
    }

    public String toString() {
        return "LocationWrapper{collectionMode=" + this.a + ", mIncrementalId=" + this.b + ", mReceiveTimestamp=" + this.c + ", mReceiveElapsedRealtime=" + this.d + ", mLocation=" + this.e + ", mChargeType=" + this.f + '}';
    }
}
