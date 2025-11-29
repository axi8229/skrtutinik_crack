package com.huawei.riemann.location;

import android.content.Context;
import com.huawei.location.activity.model.Vw;
import com.huawei.riemann.common.api.location.CityTileCallback;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.eph.Ephemeris;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;

/* loaded from: classes3.dex */
public class SdmLocationAlgoWrapper {
    public static final Object Vw = new Object();
    public static volatile SdmLocationAlgoWrapper yn;
    public boolean FB;

    public SdmLocationAlgoWrapper(Context context, String str) {
        this.FB = false;
        this.FB = Vw.Vw(context, "libSdm.so", str);
    }

    public static SdmLocationAlgoWrapper yn(Context context, String str) {
        if (yn == null) {
            synchronized (Vw) {
                try {
                    if (yn == null) {
                        yn = new SdmLocationAlgoWrapper(context, str);
                    }
                } finally {
                }
            }
        }
        return yn;
    }

    public native Pvt sdmProcess(Pvt pvt, GnssClock[] gnssClockArr, SatelliteMeasurement[] satelliteMeasurementArr);

    public native int sdmStart(DeviceInfo deviceInfo, CityTileCallback cityTileCallback, String str);

    public native int sdmStop();

    public native void sdmUpdateEphemeris(Ephemeris ephemeris);

    public native void sdmUpdateTileById(long j, byte[] bArr);
}
