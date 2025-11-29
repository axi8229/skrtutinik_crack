package com.group_ib.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* loaded from: classes3.dex */
public final class e1 implements d1, LocationListener {
    public final MobileSdkService a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public LocationManager f = null;

    public e1(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) throws JSONException {
        LocationManager locationManager;
        if (i == 16) {
            if (this.b) {
                this.c = false;
            } else {
                boolean zA = AbstractC0604j0.a(this.a, "android.permission.ACCESS_COARSE_LOCATION");
                this.c = zA;
                this.b = zA;
            }
            if (this.d) {
                this.e = false;
            } else {
                boolean zA2 = AbstractC0604j0.a(this.a, "android.permission.ACCESS_FINE_LOCATION");
                this.e = zA2;
                this.d = zA2;
            }
            if (this.b || this.d) {
                a("network", 60000L, this.c);
            }
            if (this.d) {
                a("gps", UtilsKt.UPDATE_INTERVAL, this.e);
                return;
            }
            return;
        }
        if (i == 32) {
            if ((this.d || this.b) && (locationManager = this.f) != null) {
                locationManager.removeUpdates(this);
                c1.a(4, 4, "LocationProvider", "Stop listening location provider(s)");
                return;
            }
            return;
        }
        if (i != 256) {
            return;
        }
        if (this.b) {
            this.c = false;
        } else {
            boolean zA3 = AbstractC0604j0.a(this.a, "android.permission.ACCESS_COARSE_LOCATION");
            this.c = zA3;
            this.b = zA3;
        }
        if (this.d) {
            this.e = false;
        } else {
            boolean zA4 = AbstractC0604j0.a(this.a, "android.permission.ACCESS_FINE_LOCATION");
            this.e = zA4;
            this.d = zA4;
        }
        if (this.c || this.e) {
            a("network", 60000L, true);
        }
        if (this.e) {
            a("gps", UtilsKt.UPDATE_INTERVAL, true);
        }
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) throws JSONException {
        if (location == null) {
            return;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("p", location.getProvider()).put("t", location.getTime()).put("lat", location.getLatitude()).put("lon", location.getLongitude()).put("acc", location.getAccuracy());
            if (location.hasAltitude()) {
                jSONObjectPut.put("alt", location.getAltitude());
            }
            if (location.hasSpeed()) {
                jSONObjectPut.put("speed", location.getSpeed());
            }
            if (location.hasBearing()) {
                jSONObjectPut.put("bearing", location.getBearing());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (location.hasVerticalAccuracy()) {
                    jSONObjectPut.put("alt_acc", location.getVerticalAccuracyMeters());
                }
                if (location.hasSpeedAccuracy()) {
                    jSONObjectPut.put("speed_acc", location.getSpeedAccuracyMetersPerSecond());
                }
                if (location.hasBearingAccuracy()) {
                    jSONObjectPut.put("bearing_acc", location.getBearingAccuracyDegrees());
                }
            }
            if (c1.b(5)) {
                c1.a(4, 4, "LocationProvider", "Location updated: " + jSONObjectPut.toString());
            }
            this.a.b(jSONObjectPut);
        } catch (Exception unused) {
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        if (str == null) {
            return;
        }
        c1.a(4, 4, "LocationProvider", "Provider '" + str + "' disabled");
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        if (str == null) {
            return;
        }
        c1.a(4, 4, "LocationProvider", "Provider '" + str + "' enabled");
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        if (str == null) {
            return;
        }
        c1.a(4, 4, "LocationProvider", "Provider '" + str + "' status changed to " + i);
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
        this.f = (LocationManager) this.a.getSystemService("location");
    }

    public final void a(String str, long j, boolean z) throws JSONException {
        LocationManager locationManager = this.f;
        if (locationManager == null) {
            return;
        }
        if (!locationManager.isProviderEnabled(str)) {
            c1.a(4, 4, "LocationProvider", "Location provider '" + str + "' is disabled");
            return;
        }
        c1.a(4, 4, "LocationProvider", "Start listening location provider '" + str + "'");
        if (z) {
            onLocationChanged(this.f.getLastKnownLocation(str));
        }
        this.f.requestLocationUpdates(str, j, 500.0f, this);
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
        LocationManager locationManager;
        if ((this.d || this.b) && (locationManager = this.f) != null) {
            locationManager.removeUpdates(this);
            c1.a(4, 4, "LocationProvider", "Stop listening location provider(s)");
        }
    }
}
