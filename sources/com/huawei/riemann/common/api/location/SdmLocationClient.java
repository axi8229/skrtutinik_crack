package com.huawei.riemann.common.api.location;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.huawei.riemann.location.SdmLocationAlgoWrapper;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.location.yn;

/* loaded from: classes3.dex */
public class SdmLocationClient {
    public static final String TAG = "SdmLocationClient";
    public Context mContext;
    public com.huawei.riemann.location.yn mSdmLocManager;

    public SdmLocationClient(Context context, Intent intent, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new com.huawei.riemann.location.yn(applicationContext, intent, str);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage() != null ? e.getMessage() : "IllegalArgumentException2");
        }
    }

    public SdmLocationClient(Context context, Looper looper, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new com.huawei.riemann.location.yn(applicationContext, looper, str);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage() != null ? e.getMessage() : "IllegalArgumentException3");
        }
    }

    public SdmLocationClient(Context context, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext;
            this.mSdmLocManager = new com.huawei.riemann.location.yn(applicationContext, str);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage() != null ? e.getMessage() : "IllegalArgumentException1");
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr) {
        String str;
        String str2;
        com.huawei.riemann.location.yn ynVar = this.mSdmLocManager;
        if (ynVar == null) {
            Log.e(TAG, "proc n");
            return pvt;
        }
        if (pvt == null) {
            str2 = "pvt null";
        } else {
            if (gnssRawObservationArr != null) {
                SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
                if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                    str = "wp is null";
                } else {
                    GnssClock[] gnssClockArr = new GnssClock[gnssRawObservationArr.length];
                    SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
                    for (int i = 0; i < gnssRawObservationArr.length; i++) {
                        gnssClockArr[i] = gnssRawObservationArr[i].getGnssClock();
                        satelliteMeasurementArr[i] = gnssRawObservationArr[i].getSatelliteMeasurement();
                    }
                    pvt = ynVar.G3.sdmProcess(pvt, gnssClockArr, satelliteMeasurementArr);
                    Log.v("SdmLocationManager", "p lph null");
                    if (ynVar.zp != null) {
                        return pvt;
                    }
                    str = "p ops null";
                }
                Log.e("SdmLocationManager", str);
                return pvt;
            }
            str2 = "obs null";
        }
        Log.e("SdmLocationManager", str2);
        return null;
    }

    public int startLocation(DeviceInfo deviceInfo, CityTileCallback cityTileCallback) {
        String str;
        com.huawei.riemann.location.yn ynVar = this.mSdmLocManager;
        if (ynVar == null) {
            Log.e(TAG, "start n");
            return -1;
        }
        if (ynVar.dW) {
            str = "already started";
        } else {
            ynVar.yn(null);
            yn.LW lw = ynVar.zp;
            if (lw != null) {
                ynVar.h1 = cityTileCallback;
                ynVar.Yx = new yn.Vw(lw, cityTileCallback);
            } else {
                ynVar.Yx = new yn.Vw(new Handler(Looper.getMainLooper()), cityTileCallback);
            }
            Log.v("SdmLocationManager", "lph is null");
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
            if (sdmLocationAlgoWrapper != null && sdmLocationAlgoWrapper.FB) {
                sdmLocationAlgoWrapper.sdmStart(deviceInfo, ynVar.Yx, "");
                ynVar.dW = true;
                return 0;
            }
            str = "wp is null";
        }
        Log.e("SdmLocationManager", str);
        ynVar.dW = true;
        return 0;
    }

    public void stopLocation() {
        com.huawei.riemann.location.yn ynVar = this.mSdmLocManager;
        if (ynVar == null) {
            Log.e(TAG, "stop n");
            return;
        }
        if (ynVar.dW) {
            SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
            if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
                Log.e("SdmLocationManager", "wp is null");
            } else {
                sdmLocationAlgoWrapper.sdmStop();
            }
            ynVar.h1 = null;
            ynVar.Yx = null;
            if (ynVar.Ot) {
                yn.dC dCVar = ynVar.E5;
                if (dCVar != null) {
                    dCVar.removeCallbacksAndMessages(null);
                }
                yn.LW lw = ynVar.zp;
                if (lw != null) {
                    lw.removeCallbacksAndMessages(null);
                }
                yn.FB fb = ynVar.d2;
                if (fb != null) {
                    fb.quitSafely();
                }
                ynVar.E5 = null;
                ynVar.zp = null;
                ynVar.d2 = null;
            }
            ynVar.Ot = false;
            Log.v("SdmLocationManager", "lph is null");
        } else {
            Log.e("SdmLocationManager", "already stopped");
        }
        ynVar.dW = false;
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        com.huawei.riemann.location.yn ynVar = this.mSdmLocManager;
        if (ynVar == null) {
            Log.e(TAG, "eph n");
            return;
        }
        SdmLocationAlgoWrapper sdmLocationAlgoWrapper = ynVar.G3;
        if (sdmLocationAlgoWrapper == null || !sdmLocationAlgoWrapper.FB) {
            Log.e("SdmLocationManager", "wp is null");
            return;
        }
        Log.v("SdmLocationManager", "e lph null");
        if (ynVar.zp == null) {
            Log.e("SdmLocationManager", "e ops null");
        }
        ynVar.G3.sdmUpdateEphemeris(ephemeris);
    }
}
