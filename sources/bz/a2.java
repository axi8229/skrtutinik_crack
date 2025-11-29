package bz;

import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.DeviceOrientationRequest;

/* loaded from: classes.dex */
public final class a2 extends R0 {
    public final /* synthetic */ d2 a;

    public a2(d2 d2Var) {
        this.a = d2Var;
    }

    public final void a(zone.bi.mobile.fingerprint.api.c cVar) {
        LocationManager locationManager;
        try {
            locationManager = (LocationManager) this.a.d.getSystemService("location");
        } catch (Exception unused) {
            if (cVar == null) {
                return;
            }
        } catch (Throwable th) {
            if (cVar != null) {
                zone.bi.mobile.fingerprint.api.f fVar = this.a.a;
                cVar.a();
            }
            throw th;
        }
        if (locationManager != null && K0.a(this.a.d, "android.permission.ACCESS_FINE_LOCATION") && K0.a(this.a.d, "android.permission.ACCESS_COARSE_LOCATION")) {
            boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("passive");
            boolean zIsProviderEnabled3 = locationManager.isProviderEnabled("network");
            if (zIsProviderEnabled || zIsProviderEnabled3 || zIsProviderEnabled2) {
                if (zIsProviderEnabled) {
                    locationManager.requestLocationUpdates("gps", DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, 10000.0f, this.a);
                }
                if (zIsProviderEnabled2) {
                    locationManager.requestLocationUpdates("passive", DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, 10000.0f, this.a);
                }
                if (zIsProviderEnabled3) {
                    locationManager.requestLocationUpdates("network", DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, 10000.0f, this.a);
                }
            }
            if (cVar == null) {
                return;
            }
            zone.bi.mobile.fingerprint.api.f fVar2 = this.a.a;
            cVar.a();
            return;
        }
        if (cVar != null) {
            zone.bi.mobile.fingerprint.api.f fVar3 = this.a.a;
            cVar.a();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        final zone.bi.mobile.fingerprint.api.c cVar = null;
        new Handler(Looper.getMainLooper()).post(new Runnable(cVar) { // from class: bz.a2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(null);
            }
        });
    }
}
