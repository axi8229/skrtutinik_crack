package com.huawei.location.gnss.api;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class yn {
    private static volatile yn Vw;
    private static final byte[] yn = new byte[0];
    private com.huawei.location.gnss.sdm.Vw E5;
    private LocationManager FB;
    private List<LocationListener> LW = null;
    private HandlerThread dC;

    private yn() {
        HandlerThread handlerThread = new HandlerThread("Loc-GNSS");
        this.dC = handlerThread;
        handlerThread.start();
        Object systemService = ContextUtil.getContext().getSystemService("location");
        if (systemService instanceof LocationManager) {
            this.FB = (LocationManager) systemService;
        }
    }

    public static yn yn() {
        if (Vw == null) {
            synchronized (yn) {
                try {
                    if (Vw == null) {
                        Vw = new yn();
                    }
                } finally {
                }
            }
        }
        return Vw;
    }

    public synchronized Location yn(String str) {
        Location lastKnownLocation;
        try {
            lastKnownLocation = this.FB.getLastKnownLocation(str);
        } catch (SecurityException unused) {
            LogLocation.e("GnssClient", "getLastKnownLocation, security exception");
            lastKnownLocation = null;
        }
        return lastKnownLocation;
    }

    public synchronized void yn(LocationListener locationListener) {
        LogLocation.i("GnssClient", "removeLocationUpdates");
        if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            LogLocation.e("GnssClient", "checkSelfPermission fail");
            return;
        }
        List<LocationListener> list = this.LW;
        if (list == null || !list.remove(locationListener)) {
            this.FB.removeUpdates(locationListener);
        } else {
            this.E5.Vw(locationListener);
        }
    }

    public synchronized void yn(RequestLocationUpdatesRequest requestLocationUpdatesRequest, LocationListener locationListener) {
        String str;
        String str2;
        if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            LogLocation.e("GnssClient", "checkSelfPermission fail");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (!TextUtils.isEmpty(requestLocationUpdatesRequest.getTid()) && locationRequest != null) {
            LogLocation.i("GnssClient", "requestLocationUpdates, priority is " + locationRequest.getPriority() + ", interval is " + locationRequest.getInterval() + ", smallestDisplacement is " + locationRequest.getSmallestDisplacement());
            int priority = locationRequest.getPriority();
            String str3 = (priority == 100 || priority == 200 || priority == 400) ? "gps" : priority == 105 ? "passive" : "";
            if (TextUtils.isEmpty(str3)) {
                LogLocation.e("GnssClient", "priority is invalid");
                return;
            }
            if (str3.equals("gps")) {
                Map<String, String> extras = locationRequest.getExtras();
                if (extras == null ? false : "1".equals(extras.get("SuperGnssEnable"))) {
                    if (this.LW == null) {
                        this.LW = new ArrayList();
                    }
                    if (this.E5 == null) {
                        this.E5 = new com.huawei.location.gnss.sdm.Vw();
                    }
                    if (this.E5.yn(locationRequest.getInterval(), locationRequest.getSmallestDisplacement(), locationListener)) {
                        this.LW.remove(locationListener);
                        this.LW.add(locationListener);
                        return;
                    }
                }
            }
            if (this.dC == null) {
                HandlerThread handlerThread = new HandlerThread("Loc-GNSS");
                this.dC = handlerThread;
                handlerThread.start();
            }
            try {
                this.FB.requestLocationUpdates(str3, locationRequest.getInterval(), locationRequest.getSmallestDisplacement(), locationListener, this.dC.getLooper());
            } catch (IllegalArgumentException unused) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                LogLocation.e(str, str2);
                return;
            } catch (SecurityException unused2) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw SecurityException";
                LogLocation.e(str, str2);
                return;
            } catch (Exception unused3) {
                str = "GnssClient";
                str2 = "LocationManager requestLocationUpdates throw other exception";
                LogLocation.e(str, str2);
                return;
            }
            return;
        }
        LogLocation.e("GnssClient", "requestLocationUpdatesRequest is invalid");
    }
}
