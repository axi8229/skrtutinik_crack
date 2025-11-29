package bz;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.io.Serializable;

/* renamed from: bz.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0565x extends AbstractC0538n1 implements A0 {
    public final Context c;
    public final Z0 d;
    public final LocationManager e;
    public final zone.bi.mobile.fingerprint.api.b f;

    public C0565x(Context context, Z0 z0, LocationManager locationManager, zone.bi.mobile.fingerprint.api.b bVar) {
        super(zone.bi.mobile.fingerprint.api.f.HorizontalAccuracy);
        this.c = context;
        this.d = z0;
        this.e = locationManager;
        this.f = bVar;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        LocationManager locationManager;
        String str = (String) a(this.f.a);
        if (str != null && ((locationManager = this.e) == null || !AbstractC0547q1.a(locationManager))) {
            return str;
        }
        if (!K0.a(this.c, "android.permission.ACCESS_FINE_LOCATION")) {
            throw new e2("permission ACCESS_FINE_LOCATION was not granted");
        }
        LocationManager locationManager2 = this.e;
        if (locationManager2 == null) {
            throw new e2("mLocationManager == null");
        }
        Location locationB = AbstractC0547q1.b(locationManager2);
        if (locationB == null) {
            throw new e2("bestLocation == null");
        }
        String strValueOf = String.valueOf(Math.round(locationB.getAccuracy()));
        a(strValueOf);
        return strValueOf;
    }
}
