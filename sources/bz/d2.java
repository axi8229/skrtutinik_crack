package bz;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d2 extends AbstractC0538n1 implements S0, LocationListener {
    public final ArrayList c;
    public final Context d;
    public final Z0 e;
    public final zone.bi.mobile.fingerprint.api.b f;
    public final LocationManager g;

    public d2(Context context, Z0 z0, zone.bi.mobile.fingerprint.api.b bVar, LocationManager locationManager, O1 o1, J0 j0, M m, C0565x c0565x, C0529l c0529l, C0518h0 c0518h0, C0554t0 c0554t0, J j, W w) {
        super(zone.bi.mobile.fingerprint.api.f.GeoLocationInfo);
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.d = context;
        this.e = z0;
        this.f = bVar;
        this.g = locationManager;
        arrayList.add(o1);
        arrayList.add(j0);
        arrayList.add(m);
        arrayList.add(c0565x);
        arrayList.add(c0529l);
        arrayList.add(c0518h0);
        arrayList.add(c0554t0);
        arrayList.add(j);
        arrayList.add(w);
    }

    @Override // bz.S0
    public final R0 b() {
        return new a2(this);
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.e;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return new zone.bi.mobile.fingerprint.api.serialize.model.d(0);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() {
        boolean z;
        String str;
        zone.bi.mobile.fingerprint.api.serialize.model.d dVar = (zone.bi.mobile.fingerprint.api.serialize.model.d) super.i();
        Objects.requireNonNull(dVar);
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = new zone.bi.mobile.fingerprint.api.serialize.model.a();
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Object obj = (AbstractC0538n1) it.next();
            if ((obj instanceof M) && ((A0) obj).a(this.f.a) != null) {
                z = true;
                break;
            }
        }
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            AbstractC0538n1 abstractC0538n1 = (AbstractC0538n1) it2.next();
            zone.bi.mobile.fingerprint.api.f fVar = abstractC0538n1.a;
            String strName = fVar.name();
            try {
                Serializable serializableI = abstractC0538n1.i();
                if (serializableI != null) {
                    aVar.put(strName, serializableI);
                }
            } catch (AbstractC0543p0 e) {
                if (fVar.b) {
                    aVar.put(strName, e.a(fVar));
                } else {
                    aVar.remove(strName);
                }
            }
        }
        LocationManager locationManager = this.g;
        if ((locationManager == null || AbstractC0547q1.b(locationManager) == null) && !z) {
            Iterator it3 = this.c.iterator();
            while (it3.hasNext()) {
                AbstractC0538n1 abstractC0538n12 = (AbstractC0538n1) it3.next();
                if ((abstractC0538n12 instanceof J) && (str = (String) aVar.get(abstractC0538n12.a.name())) != null && str.equals("0")) {
                    aVar.put(abstractC0538n12.a.name(), "2");
                    LocationManager locationManager2 = this.g;
                    if (locationManager2 != null && locationManager2.isProviderEnabled("gps")) {
                        new a2(this).run();
                    }
                }
            }
        }
        dVar.add(aVar);
        return dVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
