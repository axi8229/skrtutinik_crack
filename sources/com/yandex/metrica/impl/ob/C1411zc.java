package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* renamed from: com.yandex.metrica.impl.ob.zc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1411zc implements LocationListener {
    private final Pc a;

    public C1411zc(Pc pc) {
        this.a = pc;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null) {
            this.a.a(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
