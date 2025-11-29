package com.huawei.riemann.gnsslocation.api.vdr;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.huawei.location.FB;
import com.huawei.riemann.gnsslocation.core.VdrLocationAlgoWrapper;
import com.huawei.riemann.gnsslocation.core.bean.DeviceInfo;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.huawei.riemann.gnsslocation.core.bean.sensor.MotionSensors;
import com.huawei.riemann.gnsslocation.core.yn;

/* loaded from: classes3.dex */
public class VdrLocationClient {
    public static final String TAG = "com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient";
    public yn mVdrLocManager;

    public VdrLocationClient(Context context, String str) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context can not be null");
            }
            this.mVdrLocManager = new yn(context.getApplicationContext(), str);
            Log.i(TAG, "VDR version time: 20211124");
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "vdr client error: " + e.getMessage());
        }
    }

    public Pvt process(Pvt pvt, GnssRawObservation[] gnssRawObservationArr, MotionSensors motionSensors, Pvt pvt2) {
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "proc manager null");
            return pvt;
        }
        Log.d("VdrLocationManager", "vdr process start");
        if (pvt == null) {
            Log.w("VdrLocationManager", "pvt null in proc");
        }
        if (gnssRawObservationArr == null) {
            Log.w("VdrLocationManager", "obs null in proc");
        }
        if (motionSensors == null) {
            Log.e("VdrLocationManager", "sensors null in proc");
            return null;
        }
        if (yn.yn == null || !VdrLocationAlgoWrapper.FB) {
            Log.e("VdrLocationManager", "wp is null in proc");
            return pvt;
        }
        GnssClock[] gnssClockArr = new GnssClock[0];
        SatelliteMeasurement[] satelliteMeasurementArr = new SatelliteMeasurement[0];
        if (gnssRawObservationArr != null) {
            gnssClockArr = new GnssClock[gnssRawObservationArr.length];
            satelliteMeasurementArr = new SatelliteMeasurement[gnssRawObservationArr.length];
            for (int i = 0; i < gnssRawObservationArr.length; i++) {
                GnssRawObservation gnssRawObservation = gnssRawObservationArr[i];
                if (gnssRawObservation == null) {
                    Log.w("VdrLocationManager", "rawMeasurements[" + i + "] is null");
                } else {
                    gnssClockArr[i] = gnssRawObservation.getGnssClock();
                    satelliteMeasurementArr[i] = gnssRawObservationArr[i].getSatelliteMeasurement();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("vdr process algo start: ");
        int i2 = ynVar.LW + 1;
        ynVar.LW = i2;
        sb.append(i2);
        Log.d("VdrLocationManager", sb.toString());
        Pvt pvtVdrProcess = yn.yn.vdrProcess(pvt, gnssClockArr, satelliteMeasurementArr, motionSensors, pvt2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vdr process algo finished: ");
        int i3 = ynVar.dC + 1;
        ynVar.dC = i3;
        sb2.append(i3);
        Log.d("VdrLocationManager", sb2.toString());
        if (ynVar.Vw == null) {
            Log.v("VdrLocationManager", "lpm is null in proc");
            return pvtVdrProcess;
        }
        Log.e("LogPersistenceManager", "log p helper null when proc");
        return pvtVdrProcess;
    }

    public int startLocation(DeviceInfo deviceInfo) {
        String str;
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "start n");
            return -1;
        }
        if (ynVar.FB) {
            str = "already started";
        } else {
            ynVar.FB = true;
            FB fb = ynVar.Vw;
            if (fb == null) {
                Log.v("VdrLocationManager", "lph is null");
            } else {
                fb.yn();
                Log.v("LogPersistenceManager", "log ph is null when start");
            }
            if (yn.yn != null && VdrLocationAlgoWrapper.FB) {
                yn.yn.vdrStart(deviceInfo, "");
                Log.d("VdrLocationManager", "start vdr location finished, transPath: ");
                return 0;
            }
            str = "start: wp is null";
        }
        Log.e("VdrLocationManager", str);
        return 0;
    }

    public void stopLocation() {
        String str;
        yn ynVar = this.mVdrLocManager;
        if (ynVar == null) {
            Log.e(TAG, "stop n");
            return;
        }
        if (ynVar.FB) {
            ynVar.FB = false;
            if (yn.yn != null && VdrLocationAlgoWrapper.FB) {
                yn.yn.vdrStop();
                FB fb = ynVar.Vw;
                if (fb == null) {
                    Log.v("VdrLocationManager", "lpm is null");
                    return;
                }
                if (fb.dC) {
                    fb.dC = false;
                    Handler handler = fb.LW;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    FB.yn ynVar2 = fb.FB;
                    if (ynVar2 != null) {
                        ynVar2.quitSafely();
                    }
                    fb.LW = null;
                    fb.FB = null;
                }
                Log.v("LogPersistenceManager", "log ph is null when stop");
                Log.d("VdrLocationManager", "stop vdr location finished");
                return;
            }
            str = "stop: wp is null";
        } else {
            str = "already stopped";
        }
        Log.e("VdrLocationManager", str);
    }

    public void updateEphemeris(Ephemeris ephemeris) {
        String str;
        if (this.mVdrLocManager == null) {
            Log.e(TAG, "no ephemeris data");
            return;
        }
        Log.d(TAG, "updateEphemeris start");
        yn ynVar = this.mVdrLocManager;
        ynVar.getClass();
        if (yn.yn == null || !VdrLocationAlgoWrapper.FB) {
            str = "update: wp is null";
        } else {
            yn.yn.vdrUpdateEphemeris(ephemeris);
            if (ynVar.Vw != null) {
                Log.e("LogPersistenceManager", "log p helper null when eph");
                Log.d("VdrLocationManager", "update ephemeris finished");
                return;
            }
            str = "lpm is null";
        }
        Log.e("VdrLocationManager", str);
    }
}
