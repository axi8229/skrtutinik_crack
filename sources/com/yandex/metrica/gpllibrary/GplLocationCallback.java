package com.yandex.metrica.gpllibrary;

import android.location.LocationListener;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes3.dex */
class GplLocationCallback extends LocationCallback {
    private final LocationListener mLocationListener;

    GplLocationCallback(LocationListener locationListener) {
        this.mLocationListener = locationListener;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        this.mLocationListener.onLocationChanged(locationResult.getLastLocation());
    }
}
