package bz;

import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;

/* renamed from: bz.q1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0547q1 {
    public static boolean a(LocationManager locationManager) {
        if (!locationManager.isProviderEnabled("gps")) {
            return false;
        }
        try {
            return locationManager.getProvider("gps") != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static Location b(LocationManager locationManager) {
        Iterator<String> it = locationManager.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                location = lastKnownLocation;
            }
        }
        return location;
    }
}
