package com.huawei.location.logic;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.callback.Ot;
import com.huawei.location.callback.oc;
import com.huawei.location.callback.ut;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.logic.d2;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class LW {
    private static volatile LW FB;
    private com.huawei.location.provider.yn E5 = new com.huawei.location.provider.yn();
    private dC LW;
    private Handler dC;
    private static final boolean yn = ROMUtil.isGmsRom();
    private static final byte[] Vw = new byte[0];

    class Vw implements Runnable {
        final /* synthetic */ com.huawei.location.callback.d2 yn;

        Vw(LW lw, com.huawei.location.callback.d2 d2Var) {
            this.yn = d2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.yn.yn(LocationUtil.isLocationEnabled(ContextUtil.getContext()), NetworkUtil.isNetworkAvailable(ContextUtil.getContext()));
        }
    }

    class yn implements LocationProviderCallback {
        yn() {
        }

        @Override // com.huawei.hms.location.LocationProviderCallback
        public void onLocationChanged(HwLocationResult hwLocationResult) {
            if (PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION") || PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                LW.yn(LW.this, hwLocationResult);
            } else {
                LogLocation.i("HwLocationManager", "dispatchCallback fail, location permission is denied");
            }
        }
    }

    private LW() {
        com.huawei.location.nlp.api.yn.yn().yn(new yn());
        com.huawei.location.crowdsourcing.Vw.yn(ContextUtil.getContext());
    }

    private void Vw(com.huawei.location.cache.Vw vw) {
        if (vw.dC() == null) {
            return;
        }
        if (yn) {
            this.E5.yn(vw);
        } else {
            com.huawei.location.nlp.api.yn.yn().yn(vw.dC());
        }
    }

    private com.huawei.location.callback.d2 yn(com.huawei.location.cache.Vw vw, oc ocVar) {
        if (yn) {
            Ot ot = new Ot(vw.dC(), ocVar);
            ot.Vw(yn(vw, ot));
            vw.yn(ot);
            com.huawei.location.cache.yn.Vw().yn(vw);
            this.E5.Vw(vw);
            return ot;
        }
        com.huawei.location.callback.zp zpVar = new com.huawei.location.callback.zp(vw.dC(), ocVar);
        zpVar.Vw(yn(vw, zpVar));
        vw.yn(zpVar);
        com.huawei.location.cache.yn.Vw().yn(vw);
        com.huawei.location.nlp.api.yn.yn().Vw(vw.dC());
        return zpVar;
    }

    public static LW yn() {
        if (FB == null) {
            synchronized (Vw) {
                try {
                    if (FB == null) {
                        FB = new LW();
                    }
                } finally {
                }
            }
        }
        return FB;
    }

    private void yn(com.huawei.location.callback.d2 d2Var) {
        if (this.dC == null) {
            HandlerThread handlerThread = new HandlerThread("FullSDK-hwLocationManager-HwLocationManager");
            handlerThread.start();
            this.dC = new Handler(handlerThread.getLooper());
        }
        this.dC.postDelayed(new Vw(this, d2Var), 100L);
    }

    static void yn(LW lw, HwLocationResult hwLocationResult) {
        lw.getClass();
        Iterator<Map.Entry<String, com.huawei.location.cache.Vw>> it = com.huawei.location.cache.yn.Vw().yn().entrySet().iterator();
        while (it.hasNext()) {
            com.huawei.location.cache.Vw value = it.next().getValue();
            if (value == null) {
                LogLocation.i("HwLocationManager", "dispatchCallback fail, wrapLocationRequest is null");
            } else if (value.yn() == null || TextUtils.isEmpty(value.d2()) || !com.huawei.location.activity.model.Vw.yn(value.dC())) {
                LogLocation.i("HwLocationManager", "dispatchCallback fail, request is invalid");
                it.remove();
                lw.yn(value);
            } else {
                int iFB = value.FB();
                if (iFB == 102 || iFB == 104 || iFB == 300 || iFB == 400 || iFB == 100) {
                    value.yn().LW(hwLocationResult);
                }
            }
        }
    }

    private boolean yn(int i) {
        return i == 300 || i == 102 || i == 104;
    }

    public synchronized void FB(com.huawei.location.cache.Vw vw, oc ocVar) {
        com.huawei.location.callback.d2 d2VarYn;
        if (com.huawei.location.cache.yn.Vw().yn(vw.d2())) {
            try {
                yn(vw.d2());
            } catch (LocationServiceException unused) {
                LogLocation.e("HwLocationManager", "requestLocationUpdatesEx throw locationServiceException");
            }
        }
        int iFB = vw.FB();
        RequestLocationUpdatesRequest requestLocationUpdatesRequestDC = vw.dC();
        LogLocation.i("HwLocationManager", "requestLocationUpdatesEx priority = " + iFB);
        if (iFB == 300) {
            d2VarYn = yn(vw, ocVar);
        } else {
            if (iFB != 200) {
                Vw(vw, ocVar);
                return;
            }
            com.huawei.location.callback.E5 e5 = new com.huawei.location.callback.E5(requestLocationUpdatesRequestDC, ocVar);
            e5.Vw(yn(vw, e5));
            vw.yn(e5);
            com.huawei.location.cache.yn.Vw().yn(vw);
            com.huawei.location.gnss.api.yn.yn().yn(requestLocationUpdatesRequestDC, e5);
            d2VarYn = e5;
        }
        d2VarYn.yn.yn();
        yn(d2VarYn);
        int iFB2 = vw.FB();
        if (this.LW == null) {
            this.LW = new dC();
        }
        if (yn(iFB2)) {
            this.LW.registerNetworkObserve();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.location.Location Vw() {
        /*
            r13 = this;
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()
            boolean r0 = com.huawei.location.lite.common.util.LocationUtil.isLocationEnabled(r0)
            java.lang.String r1 = "HwLocationManager"
            if (r0 != 0) goto L13
            java.lang.String r0 = "location unable"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r0)
            r0 = 0
            return r0
        L13:
            com.huawei.location.gnss.api.yn r0 = com.huawei.location.gnss.api.yn.yn()
            java.lang.String r2 = "gps"
            android.location.Location r0 = r0.yn(r2)
            com.huawei.location.gnss.api.yn r2 = com.huawei.location.gnss.api.yn.yn()
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.yn(r3)
            com.huawei.location.cache.yn r3 = com.huawei.location.cache.yn.Vw()
            android.location.Location r3 = r3.FB()
            if (r2 != 0) goto L37
            java.lang.String r2 = "native network is null,use cache network"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r2)
            goto L6e
        L37:
            if (r3 != 0) goto L3f
            java.lang.String r3 = "cacheLocation loacation is null,use native network"
            com.huawei.location.lite.common.log.LogLocation.i(r1, r3)
            goto L6f
        L3f:
            long r4 = r2.getElapsedRealtimeNanos()
            long r6 = r3.getElapsedRealtimeNanos()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "nativeLocTime:"
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = ",cacheLocTime:"
            r8.append(r9)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            com.huawei.location.lite.common.log.LogLocation.i(r1, r8)
            long r4 = r4 - r6
            r6 = 60000000000(0xdf8475800, double:2.96439387505E-313)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L6e
            goto L6f
        L6e:
            r2 = r3
        L6f:
            java.lang.String r3 = "return netBestLoc"
            if (r0 != 0) goto L77
            com.huawei.location.lite.common.log.LogLocation.i(r1, r3)
            return r2
        L77:
            java.lang.String r4 = "return nativeGPSLoc"
            if (r2 != 0) goto L7f
            com.huawei.location.lite.common.log.LogLocation.i(r1, r4)
            return r0
        L7f:
            long r5 = r0.getElapsedRealtimeNanos()
            long r7 = r2.getElapsedRealtimeNanos()
            long r9 = r5 - r7
            long r9 = java.lang.Math.abs(r9)
            r11 = 11000000000(0x28fa6ae00, double:5.4347221043E-314)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto Laa
            float r5 = r0.getAccuracy()
            float r6 = r2.getAccuracy()
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto La6
            com.huawei.location.lite.common.log.LogLocation.i(r1, r4)
            return r0
        La6:
            com.huawei.location.lite.common.log.LogLocation.i(r1, r3)
            return r2
        Laa:
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto Lb2
            com.huawei.location.lite.common.log.LogLocation.i(r1, r4)
            return r0
        Lb2:
            com.huawei.location.lite.common.log.LogLocation.i(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.logic.LW.Vw():android.location.Location");
    }

    public void yn(String str) throws LocationServiceException {
        com.huawei.location.cache.Vw Vw2 = com.huawei.location.cache.yn.Vw().Vw(str);
        if (Vw2 == null || TextUtils.isEmpty(Vw2.LW())) {
            throw new LocationServiceException(LocationStatusCode.NO_MATCHED_CALLBACK, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_CALLBACK));
        }
        yn(Vw2);
    }

    private boolean yn(com.huawei.location.cache.Vw vw, com.huawei.location.callback.d2 d2Var) {
        LocationRequest locationRequestVw = vw.Vw();
        if (locationRequestVw == null) {
            return false;
        }
        long maxWaitTime = locationRequestVw.getMaxWaitTime();
        if (maxWaitTime <= 0) {
            return false;
        }
        if (SystemClock.uptimeMillis() + maxWaitTime < 0) {
            throw new LocationServiceException(10101, com.huawei.location.constant.yn.yn(10101));
        }
        if (maxWaitTime / 2 < locationRequestVw.getInterval()) {
            return false;
        }
        LogLocation.i("HwLocationManager", "maxWaitTime is enable , add to MaxWaitTimeQueue");
        d2.Vw.yn.yn(d2Var, vw.E5(), locationRequestVw.getMaxWaitTime(), locationRequestVw);
        return true;
    }

    public synchronized void Vw(com.huawei.location.cache.Vw vw, oc ocVar) {
        com.huawei.location.callback.d2 utVar;
        if (com.huawei.location.cache.yn.Vw().yn(vw.d2())) {
            try {
                yn(vw.d2());
            } catch (LocationServiceException unused) {
                LogLocation.e("HwLocationManager", "requestLocationUpdates throw locationServiceException");
            }
        }
        RequestLocationUpdatesRequest requestLocationUpdatesRequestDC = vw.dC();
        if (TextUtils.equals(vw.LW(), "network")) {
            utVar = yn(vw, ocVar);
        } else if (TextUtils.equals(vw.LW(), "fused")) {
            if (yn) {
                utVar = new com.huawei.location.callback.dC(vw.dC(), ocVar);
                utVar.Vw(yn(vw, utVar));
                vw.yn(utVar);
                com.huawei.location.cache.yn.Vw().yn(vw);
                this.E5.Vw(vw);
            } else {
                utVar = new ut(vw.dC(), ocVar);
                utVar.Vw(yn(vw, utVar));
                vw.yn(utVar);
                com.huawei.location.cache.yn.Vw().yn(vw);
                com.huawei.location.nlp.api.yn.yn().Vw(vw.dC());
            }
            com.huawei.location.gnss.api.yn.yn().yn(vw.dC(), utVar);
        } else {
            if (!TextUtils.equals(vw.LW(), "passive")) {
                LogLocation.i("HwLocationManager", "end");
                return;
            }
            com.huawei.location.callback.zp zpVar = new com.huawei.location.callback.zp(requestLocationUpdatesRequestDC, ocVar);
            zpVar.Vw(yn(vw, zpVar));
            vw.yn(zpVar);
            com.huawei.location.cache.yn.Vw().yn(vw);
            com.huawei.location.gnss.api.yn.yn().yn(requestLocationUpdatesRequestDC, zpVar);
            utVar = zpVar;
        }
        ocVar.yn();
        yn(utVar);
        int iFB = vw.FB();
        if (this.LW == null) {
            this.LW = new dC();
        }
        if (yn(iFB)) {
            this.LW.registerNetworkObserve();
        }
    }

    private void yn(com.huawei.location.cache.Vw vw) {
        dC dCVar;
        RequestLocationUpdatesRequest requestLocationUpdatesRequestDC = vw.dC();
        d2.Vw.yn.yn(vw, requestLocationUpdatesRequestDC.getTid());
        String strLW = vw.LW();
        LogLocation.i("HwLocationManager", "handlerRemoveRequest, uuid is " + requestLocationUpdatesRequestDC.getUuid() + ", provider is " + strLW);
        if (TextUtils.equals(strLW, "network")) {
            Vw(vw);
        } else if (TextUtils.equals(strLW, "fused")) {
            com.huawei.location.gnss.api.yn.yn().yn(vw.yn());
            Vw(vw);
        } else {
            if (!TextUtils.equals(strLW, "passive") && !TextUtils.equals(strLW, "gps")) {
                LogLocation.i("HwLocationManager", "handlerRemoveRequest fail");
                return;
            }
            com.huawei.location.gnss.api.yn.yn().yn(vw.yn());
        }
        int iFB = vw.FB();
        if (this.LW != null && yn(iFB)) {
            this.LW.unRegisterNetworkObserve();
        }
        if (!com.huawei.location.cache.yn.Vw().yn().isEmpty() || (dCVar = this.LW) == null) {
            return;
        }
        dCVar.unRegisterAllObserve();
        this.LW = null;
    }
}
