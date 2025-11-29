package bz;

import android.content.Context;
import android.location.LocationManager;
import com.huawei.location.nlp.network.OnlineLocationService;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class J extends AbstractC0538n1 {
    public final Context c;
    public final LocationManager d;

    public J(Context context, LocationManager locationManager) {
        super(zone.bi.mobile.fingerprint.api.f.Status);
        this.c = context;
        this.d = locationManager;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        if (!K0.a(this.c, "android.permission.ACCESS_FINE_LOCATION") && !K0.a(this.c, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "1";
        }
        LocationManager locationManager = this.d;
        if (locationManager != null) {
            try {
                locationManager.isProviderEnabled("gps");
                if (this.d.getProvider("gps") != null) {
                    return "0";
                }
            } catch (Exception unused) {
            }
        }
        return OnlineLocationService.SRC_DEFAULT;
    }
}
