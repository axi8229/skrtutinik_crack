package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.vdr.VdrManager;
import com.huawei.location.vdr.control.VDRControl;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class i1 extends h1 implements IVdrLocationListener {
    private AtomicBoolean e;
    private VdrManager f;
    private long g;
    private final String h;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLocationLog.i(i1.this.a(), ((n0) i1.this).a, "new thread to judge vdr config");
            if (new VDRControl().isSupport(i1.this.h)) {
                i1.this.f = VdrManager.getInstance();
                i1.this.f.registerVdrLocationLis(i1.this);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ LocationResult a;

        b(LocationResult locationResult) {
            this.a = locationResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            i1.this.a(this.a);
            ((j1) i1.this).b.c().onLocationResult(this.a);
        }
    }

    public i1(String str, String str2, String str3, k0 k0Var, Looper looper, String str4, String str5) throws ApiException {
        super(str, str2, str3, k0Var, looper, str4);
        this.e = new AtomicBoolean(false);
        this.h = str5;
    }

    private boolean a(Location location) {
        if (location == null) {
            return false;
        }
        return a(new SafeBundle(location.getExtras()).getInt("SourceType", -1));
    }

    public static HWLocation b(Location location) {
        if (location == null) {
            return null;
        }
        HWLocation hWLocation = new HWLocation();
        hWLocation.setTime(location.getTime());
        int i = Build.VERSION.SDK_INT;
        hWLocation.setElapsedRealtimeNanos(location.getElapsedRealtimeNanos());
        hWLocation.setLatitude(location.getLatitude());
        hWLocation.setLongitude(location.getLongitude());
        hWLocation.setAltitude(location.getAltitude());
        hWLocation.setProvider(location.getProvider());
        hWLocation.setSpeed(location.getSpeed());
        hWLocation.setBearing(location.getBearing());
        hWLocation.setAccuracy(location.getAccuracy());
        if (i >= 26) {
            hWLocation.setVerticalAccuracyMeters(location.getVerticalAccuracyMeters());
            hWLocation.setSpeedAccuracyMetersPerSecond(location.getSpeedAccuracyMetersPerSecond());
            hWLocation.setBearingAccuracyDegrees(location.getBearingAccuracyDegrees());
        }
        HashMap map = new HashMap();
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey("LocationSource")) {
            map.put("LocationSource", extras.get("LocationSource"));
        }
        hWLocation.setExtraInfo(map);
        return hWLocation;
    }

    @Override // com.huawei.hms.locationSdk.h1, com.huawei.hms.locationSdk.j1
    protected String a() {
        return "RequestLocationExVdrUpdatesTaskApiCall";
    }

    @Override // com.huawei.hms.locationSdk.j1
    protected void b(LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            HMSLocationLog.e(a(), ((n0) this).a, "locationResult is null or locationResult.getLastHWLocation is null");
            return;
        }
        VdrManager vdrManager = this.f;
        if (vdrManager == null || !vdrManager.isVdrIntervalStart()) {
            a(locationResult);
            ((j1) this).b.c().onLocationResult(locationResult);
            return;
        }
        HMSLocationLog.d(a(), ((n0) this).a, "vdr sync location");
        if (a(locationResult.getLastLocation())) {
            this.g = locationResult.getLastLocation().getElapsedRealtimeNanos();
            ((j1) this).b.c().onLocationResult(locationResult);
        }
        this.f.syncLocation(locationResult.getLastLocation());
    }

    @Override // com.huawei.hms.locationSdk.j1
    protected void b(boolean z) {
        super.b(z);
        if (z) {
            if (this.e.get()) {
                HMSLocationLog.i(a(), ((n0) this).a, "vdr has been judged, do not new thread here");
                return;
            } else {
                this.e.set(true);
                ExecutorUtil.getInstance().execute(new a());
                return;
            }
        }
        VdrManager vdrManager = this.f;
        if (vdrManager != null) {
            vdrManager.unRegisterVdrLocationLis(((j1) this).b.h());
            this.f = null;
        }
    }

    @Override // com.huawei.location.vdr.listener.IVdrLocationListener
    public String getUuid() {
        return ((j1) this).b.h();
    }

    @Override // com.huawei.location.vdr.listener.IVdrLocationListener
    public void onVdrLocationChanged(Location location) {
        HMSLocationLog.i(a(), ((n0) this).a, "onVdrLocationChanged");
        if (location != null && location.getElapsedRealtimeNanos() - this.g >= TimeUnit.MILLISECONDS.toNanos(((j1) this).b.d().getFastestInterval() + 100)) {
            HWLocation hWLocationB = b(location);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(hWLocationB);
            ((j1) this).d.post(new b(LocationResult.create(arrayList)));
        }
    }
}
