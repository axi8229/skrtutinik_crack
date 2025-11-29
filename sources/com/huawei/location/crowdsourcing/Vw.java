package com.huawei.location.crowdsourcing;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Vw {

    @SuppressLint({"StaticFieldLeak"})
    private static Context Vw = null;
    private static volatile boolean yn = false;
    private long E5;
    private C0085Vw FB;
    private final FB G3;
    private LW LW;
    private com.huawei.location.crowdsourcing.FB Ot;
    private double d2;
    private final List<com.huawei.location.crowdsourcing.common.yn> dC = Collections.synchronizedList(new ArrayList());
    private com.huawei.location.crowdsourcing.yn oc;
    private dC ut;
    private double zp;

    private class FB extends Handler {
        FB(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            int i = message.what;
            if (i == 1) {
                LogLocation.i("Crowdsourcing", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (obj instanceof Location) {
                    Vw.yn(Vw.this, (Location) obj);
                    return;
                } else {
                    LogLocation.e("Crowdsourcing", "handleMessage not location obj");
                    return;
                }
            }
            if (i == 0) {
                LogLocation.i("Crowdsourcing", "begin init");
                if (Vw.yn(Vw.this, getLooper())) {
                    LogLocation.i("Crowdsourcing", "init finished");
                    return;
                }
                LogLocation.e("Crowdsourcing", "init failed");
                Vw.yn(Vw.this);
                getLooper().quitSafely();
                return;
            }
            if (i != 2) {
                LogLocation.e("Crowdsourcing", "unknown msg:" + message.what);
                return;
            }
            if (Config.FB.yn.yn(com.huawei.location.crowdsourcing.common.util.dC.Vw(Vw.Vw()))) {
                LogLocation.i("Crowdsourcing", "check mcc success");
                return;
            }
            LogLocation.e("Crowdsourcing", "check mcc failed");
            Vw.yn(Vw.this);
            getLooper().quitSafely();
        }
    }

    private class LW extends BroadcastReceiver {
        private LW() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = new SafeIntent(intent).getAction();
            if (action == null) {
                LogLocation.e("Crowdsourcing", "get null action");
                return;
            }
            if (!action.equals("android.intent.action.SIM_STATE_CHANGED")) {
                LogLocation.e("Crowdsourcing", "receive unknown action,action:" + action);
                return;
            }
            LogLocation.d("Crowdsourcing", "onReceive action=" + action);
            Vw.this.G3.obtainMessage(2).sendToTarget();
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.Vw$Vw, reason: collision with other inner class name */
    private class C0085Vw implements LocationListener {
        private C0085Vw() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                LogLocation.e("Crowdsourcing", "location null");
                return;
            }
            SafeBundle safeBundle = new SafeBundle(location.getExtras());
            if (safeBundle.getBundle() != null && safeBundle.getInt("accuracyType") == 1 && ROMUtil.isHuaweiPlatformDevice()) {
                LogLocation.d("Crowdsourcing", "approximate not collect");
            } else {
                Vw.this.G3.obtainMessage(1, location).sendToTarget();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            LogLocation.d("Crowdsourcing", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            LogLocation.d("Crowdsourcing", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            LogLocation.d("Crowdsourcing", "onStatusChanged");
        }
    }

    private Vw(Looper looper) {
        this.G3 = new FB(looper);
    }

    static boolean FB(Vw vw) {
        vw.getClass();
        if (Build.VERSION.SDK_INT >= 29 && !PermissionUtil.checkSelfPermission(Vw, LocationConstant.BACKGROUND_PERMISSION)) {
            LogLocation.w("Crowdsourcing", "can not access background location");
        }
        return PermissionUtil.checkSelfPermission(Vw, "android.permission.ACCESS_FINE_LOCATION") && PermissionUtil.checkSelfPermission(Vw, "android.permission.ACCESS_COARSE_LOCATION");
    }

    static Context Vw() {
        return Vw;
    }

    static void yn(Vw vw) {
        vw.getClass();
        LogLocation.w("Crowdsourcing", "Stop");
        if (yn) {
            try {
                C0085Vw c0085Vw = vw.FB;
                if (c0085Vw != null) {
                    Object systemService = Vw.getSystemService("location");
                    if (systemService instanceof LocationManager) {
                        ((LocationManager) systemService).removeUpdates(c0085Vw);
                    } else {
                        LogLocation.e("Crowdsourcing", "not get LocationManager");
                    }
                    vw.FB = null;
                }
                LW lw = vw.LW;
                if (lw != null) {
                    Vw().unregisterReceiver(lw);
                    vw.LW = null;
                }
                Iterator<com.huawei.location.crowdsourcing.common.yn> it = vw.dC.iterator();
                while (it.hasNext()) {
                    it.next().yn();
                    vw.dC.clear();
                }
                com.huawei.location.crowdsourcing.FB fb = vw.Ot;
                if (fb != null) {
                    fb.Vw();
                    vw.Ot = null;
                }
            } catch (Exception unused) {
                LogLocation.e("Crowdsourcing", "Stop exception");
            }
        }
    }

    private boolean FB() {
        String str;
        LW lw = new LW();
        this.LW = lw;
        Vw().registerReceiver(lw, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        LogLocation.i("Crowdsourcing", "sim state change register success");
        C0085Vw c0085Vw = new C0085Vw();
        this.FB = c0085Vw;
        if (FB(this)) {
            Object systemService = Vw.getSystemService("location");
            if (systemService instanceof LocationManager) {
                try {
                    ((LocationManager) systemService).requestLocationUpdates("passive", 0L, 0.0f, c0085Vw);
                    LogLocation.i("Crowdsourcing", "location listener register success");
                    return true;
                } catch (IllegalArgumentException unused) {
                    str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                } catch (SecurityException unused2) {
                    str = "LocationManager requestLocationUpdates throw SecurityException";
                } catch (Exception unused3) {
                    str = "LocationManager requestLocationUpdates throw other exception";
                }
            } else {
                str = "not get LocationManager";
            }
        } else {
            str = "check permission failed";
        }
        LogLocation.e("Crowdsourcing", str);
        return false;
    }

    static void yn(Vw vw, Location location) throws IOException {
        vw.getClass();
        long jAbs = Math.abs(System.currentTimeMillis() - vw.E5);
        if (jAbs < Config.FB.yn.ut()) {
            LogLocation.d("Crowdsourcing", "not need collect, collect interval check failed. timeDiff:" + jAbs);
            return;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), vw.d2, vw.zp, fArr);
        float f = fArr[0];
        if (f < Config.FB.yn.zp()) {
            LogLocation.d("Crowdsourcing", "not need collect, collect distance check failed. distanceDiff:" + f);
            return;
        }
        LogLocation.d("Crowdsourcing", "collect");
        List<ScanResult> listVw = vw.ut.Vw();
        List<com.huawei.location.crowdsourcing.common.entity.yn> listVw2 = vw.oc.Vw();
        if (listVw == null && listVw2 == null) {
            LogLocation.d("Crowdsourcing", "no wifi and no cell, not collect");
            return;
        }
        vw.Ot.yn(location, listVw, listVw2);
        vw.E5 = System.currentTimeMillis();
        vw.d2 = location.getLatitude();
        vw.zp = location.getLongitude();
    }

    static boolean yn(Vw vw, Looper looper) {
        String str;
        String str2;
        vw.getClass();
        Config config = Config.FB.yn;
        vw.dC.add(config);
        if (!config.yn(Vw, looper)) {
            str2 = "config init failed";
        } else {
            if (!config.SI()) {
                dC dCVar = new dC(looper);
                vw.ut = dCVar;
                vw.dC.add(dCVar);
                com.huawei.location.crowdsourcing.yn ynVar = new com.huawei.location.crowdsourcing.yn();
                vw.oc = ynVar;
                vw.dC.add(ynVar);
                try {
                    com.huawei.location.crowdsourcing.FB fb = new com.huawei.location.crowdsourcing.FB(looper, Vw.getFilesDir().getCanonicalPath());
                    vw.Ot = fb;
                    vw.dC.add(fb);
                    vw.ut.FB();
                    vw.oc.getClass();
                    if (!PermissionUtil.checkSelfPermission(Vw(), "android.permission.ACCESS_FINE_LOCATION")) {
                        str = "cellCollector init failed";
                    } else {
                        if (vw.Ot.FB()) {
                            return vw.FB();
                        }
                        str = "recorder init failed";
                    }
                } catch (IOException unused) {
                    str = "get folder path failed";
                }
                LogLocation.e("Crowdsourcing", str);
                return false;
            }
            str2 = "switch is closed";
        }
        LogLocation.e("Crowdsourcing", str2);
        return false;
    }

    public static void yn(Context context) {
        if (yn) {
            LogLocation.d("Crowdsourcing", "double start");
            return;
        }
        if (context == null) {
            LogLocation.e("Crowdsourcing", "context is null");
            return;
        }
        synchronized (Vw.class) {
            try {
                if (yn) {
                    LogLocation.d("Crowdsourcing", "double start");
                    return;
                }
                LogLocation.i("Crowdsourcing", "start");
                Vw = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("Crowdsourcing");
                handlerThread.start();
                new Vw(handlerThread.getLooper()).G3.obtainMessage(0).sendToTarget();
                yn = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
