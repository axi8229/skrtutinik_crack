package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;

/* loaded from: classes3.dex */
class Tc extends Dc<Xb> {
    private final LocationManager f;
    private final String g;

    Tc(Context context, Looper looper, LocationManager locationManager, InterfaceC1412zd interfaceC1412zd, String str, LocationListener locationListener) {
        super(context, locationListener, interfaceC1412zd, looper);
        this.f = locationManager;
        this.g = str;
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    @SuppressLint({"MissingPermission"})
    public void b() {
        Location lastKnownLocation;
        if (this.b.a(this.a)) {
            LocationManager locationManager = this.f;
            if (locationManager != null) {
                try {
                    lastKnownLocation = locationManager.getLastKnownLocation(this.g);
                } catch (Throwable unused) {
                }
            } else {
                lastKnownLocation = null;
            }
            this.c.onLocationChanged(lastKnownLocation);
        }
    }

    public boolean c() {
        if (!this.b.a(this.a)) {
            return false;
        }
        String str = this.g;
        long j = Dc.e;
        LocationListener locationListener = this.c;
        Looper looper = this.d;
        LocationManager locationManager = this.f;
        if (locationManager == null) {
            return false;
        }
        try {
            locationManager.requestLocationUpdates(str, j, 0.0f, locationListener, looper);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    public /* bridge */ /* synthetic */ boolean a(Xb xb) {
        return c();
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    public void a() {
        LocationManager locationManager = this.f;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.c);
            } catch (Throwable unused) {
            }
        }
    }
}
