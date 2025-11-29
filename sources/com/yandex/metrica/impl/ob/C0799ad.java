package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.impl.ob.C1175pf;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.ad, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0799ad {
    public C1175pf.b a(Hc hc) {
        C1175pf.b bVar = new C1175pf.b();
        Location locationC = hc.c();
        bVar.a = hc.b() == null ? bVar.a : hc.b().longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bVar.c = timeUnit.toSeconds(locationC.getTime());
        bVar.k = J1.a(hc.a);
        bVar.b = timeUnit.toSeconds(hc.e());
        bVar.l = timeUnit.toSeconds(hc.d());
        bVar.d = locationC.getLatitude();
        bVar.e = locationC.getLongitude();
        bVar.f = Math.round(locationC.getAccuracy());
        bVar.g = Math.round(locationC.getBearing());
        bVar.h = Math.round(locationC.getSpeed());
        bVar.i = (int) Math.round(locationC.getAltitude());
        String provider = locationC.getProvider();
        bVar.j = "gps".equals(provider) ? 1 : "network".equals(provider) ? 2 : "fused".equals(provider) ? 3 : 0;
        bVar.m = J1.a(hc.a());
        return bVar;
    }
}
