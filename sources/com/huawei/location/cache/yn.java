package com.huawei.location.cache;

import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class yn {
    private static volatile yn Vw;
    private static final byte[] yn = new byte[0];
    private ConcurrentHashMap<String, Vw> FB = new ConcurrentHashMap<>(11);
    private Location LW;

    private yn() {
    }

    public static yn Vw() {
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

    public Location FB() {
        if (this.LW == null) {
            LogLocation.i("RequestRecordCache", "cached lastLocation is null");
            return null;
        }
        if (SystemClock.elapsedRealtime() - (this.LW.getElapsedRealtimeNanos() / 1000000) <= 1200000) {
            LogLocation.i("RequestRecordCache", "cached lastLocation is in 20 minutes");
            return this.LW;
        }
        LogLocation.i("RequestRecordCache", "cached lastLocation is expired");
        this.LW = null;
        return null;
    }

    public void FB(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, uuid is null");
            return;
        }
        if (!this.FB.containsKey(str)) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, requestCache is not contains");
            return;
        }
        Vw vw = this.FB.get(str);
        if (vw == null) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, wrapLocationRequest is null");
            return;
        }
        RequestLocationUpdatesRequest requestLocationUpdatesRequestDC = vw.dC();
        if (requestLocationUpdatesRequestDC == null) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, requestLocationUpdatesRequest is null");
            return;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequestDC.getLocationRequest();
        if (locationRequest == null) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, locationRequest is null");
            return;
        }
        int numUpdates = locationRequest.getNumUpdates();
        if (numUpdates <= 1) {
            LogLocation.e("RequestRecordCache", "updateNumUpdate fail, numUpdate <= 1");
        } else {
            locationRequest.setNumUpdates(numUpdates - 1);
        }
    }

    public Vw Vw(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Vw(new RequestLocationUpdatesRequest());
        }
        if (!this.FB.containsKey(str)) {
            return new Vw(new RequestLocationUpdatesRequest());
        }
        Vw vw = this.FB.get(str);
        if (vw != null && vw.yn() != null) {
            vw.yn().yn();
        }
        return this.FB.remove(str);
    }

    public ConcurrentHashMap<String, Vw> yn() {
        return this.FB;
    }

    public void yn(Location location) {
        this.LW = location;
    }

    public void yn(Vw vw) {
        if (vw.yn() == null) {
            return;
        }
        this.FB.put(vw.d2(), vw);
        LogLocation.i("RequestRecordCache", "add requestCache end, uuid is " + vw.d2() + "," + this.FB.size());
    }

    public boolean yn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.FB.containsKey(str);
    }
}
