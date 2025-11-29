package com.huawei.location.vdr;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.vdr.data.LW;
import com.huawei.location.vdr.listener.FB;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import com.huawei.location.vdr.listener.Vw;
import com.huawei.riemann.gnsslocation.api.vdr.VdrLocationClient;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.obs.Pvt;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class VdrManager implements Vw, FB {
    private static final String EPH_THREAD_NAME = "Loc-Vdr-EphUpdate";
    private static final long EPH_UPDATE_TIME = 30;
    private static final long SYNC_LOCATION_UPDATE_TIME = 200;
    private static final String TAG = "VdrManager";
    private static final byte[] VDR_SYNC_LOCK = new byte[0];
    private static volatile VdrManager instance;
    private Ephemeris currentEphemeris;
    private long ephExpiredTime = 0;
    private com.huawei.location.vdr.data.ephemeris.yn ephProvider;
    private final AtomicBoolean isVdrStart;
    private volatile long lastSyncTime;
    private final AtomicBoolean updateEphemeris;
    private LW vdrDataManager;
    private VdrLocationClient vdrLocationClient;

    class yn implements Runnable {
        yn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(VdrManager.EPH_THREAD_NAME + hashCode());
            VdrManager vdrManager = VdrManager.this;
            vdrManager.currentEphemeris = vdrManager.ephProvider.Vw();
            if (VdrManager.this.currentEphemeris != null) {
                VdrManager vdrManager2 = VdrManager.this;
                vdrManager2.ephExpiredTime = vdrManager2.ephProvider.FB();
                VdrManager.this.updateEphemeris.set(true);
            }
        }
    }

    private VdrManager() {
        LogLocation.i(TAG, "VdrManager init");
        this.isVdrStart = new AtomicBoolean(false);
        this.updateEphemeris = new AtomicBoolean(false);
    }

    private boolean checkAndUpdateEphemeris() {
        com.huawei.location.vdr.data.ephemeris.Vw vw = new com.huawei.location.vdr.data.ephemeris.Vw(System.currentTimeMillis());
        updateEphemeris(vw.Vw());
        if (this.updateEphemeris.get() && this.currentEphemeris != null) {
            LogLocation.i(TAG, "updateEphemeris GpsEphemeris:" + GsonUtil.getInstance().toJson(this.currentEphemeris.getGpsEphemeris()));
            this.vdrLocationClient.updateEphemeris(this.currentEphemeris);
            this.updateEphemeris.set(false);
        }
        return vw.Vw() < this.ephExpiredTime;
    }

    private boolean checkFirstRequestDataIsValid(com.huawei.location.vdr.data.FB fb) {
        return (fb.Vw() == null || fb.yn() == null || fb.FB() == null) ? false : true;
    }

    private void clearVdr() {
        LW lw = this.vdrDataManager;
        if (lw != null) {
            lw.Vw();
            this.vdrDataManager = null;
        }
        VdrLocationClient vdrLocationClient = this.vdrLocationClient;
        if (vdrLocationClient != null) {
            vdrLocationClient.stopLocation();
            this.vdrLocationClient = null;
        }
    }

    public static VdrManager getInstance() {
        if (instance == null) {
            synchronized (VDR_SYNC_LOCK) {
                try {
                    if (instance == null) {
                        instance = new VdrManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void handlerNativeLocationToVdr() {
        LogLocation.i(TAG, "vdr process fail, return native location here");
        LW lw = this.vdrDataManager;
        if (lw == null || lw.yn() == null) {
            return;
        }
        com.huawei.location.vdr.listener.LW.yn().yn(this.vdrDataManager.yn());
    }

    private void handlerVdrLocation(com.huawei.location.vdr.data.FB fb) {
        Location locationVw = fb.Vw();
        Pvt pvtBuild = locationVw != null ? Pvt.Builder.aPvt().withAccuracy(locationVw.getAccuracy()).withAltitude(locationVw.getAltitude()).withLatitude(locationVw.getLatitude()).withLongitude(locationVw.getLongitude()).withBearing(locationVw.getBearing()).withSpeed(locationVw.getSpeed()).withTime(locationVw.getTime()).build() : null;
        LogLocation.d(TAG, "process vdr start");
        Pvt pvtProcess = this.vdrLocationClient.process(pvtBuild, fb.yn(), fb.FB(), null);
        if (pvtProcess == null || pvtProcess.getLatitude() == ConfigValue.DOUBLE_DEFAULT_VALUE || pvtProcess.getLongitude() == ConfigValue.DOUBLE_DEFAULT_VALUE) {
            handlerNativeLocationToVdr();
            return;
        }
        LogLocation.i(TAG, "process vdr end, errorCode is: " + pvtProcess.getErrCode());
        com.huawei.location.vdr.listener.LW lwYn = com.huawei.location.vdr.listener.LW.yn();
        if (locationVw == null) {
            locationVw = new Location("GPS");
        }
        locationVw.setTime(System.currentTimeMillis());
        locationVw.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        locationVw.setLongitude(pvtProcess.getLongitude());
        locationVw.setLatitude(pvtProcess.getLatitude());
        locationVw.setAltitude(pvtProcess.getAltitude());
        locationVw.setAccuracy(pvtProcess.getAccuracy());
        locationVw.setBearing(pvtProcess.getBearing());
        locationVw.setSpeed(pvtProcess.getSpeed());
        Bundle extras = locationVw.getExtras();
        SafeBundle safeBundle = new SafeBundle(extras);
        if (pvtProcess.getErrCode() == 1) {
            if (safeBundle.containsKey("LocationSource")) {
                safeBundle.putInt("LocationSource", extras.getInt("LocationSource") | 2);
            } else {
                safeBundle.putInt("LocationSource", 2);
            }
        }
        locationVw.setExtras(safeBundle.getBundle());
        lwYn.yn(locationVw);
    }

    private void initVdrDataManager() {
        LW lw = new LW();
        this.vdrDataManager = lw;
        lw.yn(this);
        this.ephProvider = new com.huawei.location.vdr.data.ephemeris.yn();
    }

    private void loadVdrFile() {
        new com.huawei.location.vdr.file.yn().yn(this);
    }

    private synchronized void processVdrData(com.huawei.location.vdr.data.FB fb) {
        if (com.huawei.location.vdr.listener.LW.yn().Vw()) {
            LogLocation.e(TAG, "vdr listener is null");
            return;
        }
        if (this.vdrLocationClient == null) {
            LogLocation.e(TAG, "vdrLocationClient init failed");
            handlerNativeLocationToVdr();
            return;
        }
        if (fb == null) {
            LogLocation.e(TAG, "vdr data is null");
            handlerNativeLocationToVdr();
            return;
        }
        if (!checkAndUpdateEphemeris()) {
            LogLocation.i(TAG, "checkAndUpdateEphemeris failed,stop algo");
            if (this.isVdrStart.get()) {
                this.vdrLocationClient.stopLocation();
            }
            this.isVdrStart.set(false);
            handlerNativeLocationToVdr();
            return;
        }
        if (!this.isVdrStart.get()) {
            if (!checkFirstRequestDataIsValid(fb)) {
                LogLocation.d(TAG, "first requestData is not valid,dropping it!");
                handlerNativeLocationToVdr();
                return;
            }
            int iStartLocation = this.vdrLocationClient.startLocation(com.huawei.location.activity.model.Vw.Vw());
            LogLocation.i(TAG, "processGnssLocation startLocation status:" + iStartLocation);
            if (iStartLocation != 0) {
                this.isVdrStart.set(false);
                handlerNativeLocationToVdr();
                return;
            }
            this.isVdrStart.set(true);
        }
        handlerVdrLocation(fb);
    }

    private void startVdrAlgo() throws IOException {
        VdrLocationClient vdrLocationClient = new VdrLocationClient(ContextUtil.getContext(), com.huawei.location.vdr.util.FB.Vw);
        this.vdrLocationClient = vdrLocationClient;
        this.isVdrStart.set(vdrLocationClient.startLocation(com.huawei.location.activity.model.Vw.Vw()) == 0);
        Ephemeris ephemerisYn = this.ephProvider.yn();
        if (ephemerisYn != null) {
            this.ephExpiredTime = this.ephProvider.FB();
            LogLocation.i(TAG, "updateEphemeris GpsEphemeris:" + GsonUtil.getInstance().toJson(ephemerisYn.getGpsEphemeris()));
            this.vdrLocationClient.updateEphemeris(ephemerisYn);
        }
    }

    private void updateEphemeris(long j) {
        LogLocation.i(TAG, "currentGpsTime is : " + j + ", ephExpiredTime is : " + this.ephExpiredTime);
        if (j + EPH_UPDATE_TIME < this.ephExpiredTime) {
            return;
        }
        ExecutorUtil.getInstance().execute(new yn());
    }

    @Override // com.huawei.location.vdr.listener.FB
    public synchronized void handleLoadResult(boolean z) {
        if (z) {
            initVdrDataManager();
            startVdrAlgo();
        }
    }

    public boolean isVdrIntervalStart() {
        return this.vdrDataManager != null;
    }

    @Override // com.huawei.location.vdr.listener.Vw
    public synchronized void onVdrDataReceived(com.huawei.location.vdr.data.FB fb) {
        processVdrData(fb);
    }

    public synchronized void registerVdrLocationLis(IVdrLocationListener iVdrLocationListener) {
        com.huawei.location.vdr.listener.LW.yn().Vw(iVdrLocationListener);
        if (!isVdrIntervalStart()) {
            loadVdrFile();
        }
    }

    public synchronized void syncLocation(Location location) {
        LogLocation.d(TAG, "ElapsedRealtimeNanos time is: " + location.getElapsedRealtimeNanos() + ", lastSyncTime is: " + this.lastSyncTime);
        if (location.getElapsedRealtimeNanos() - this.lastSyncTime < SYNC_LOCATION_UPDATE_TIME) {
            return;
        }
        LW lw = this.vdrDataManager;
        if (lw != null) {
            lw.yn(location);
            this.lastSyncTime = location.getElapsedRealtimeNanos();
        }
    }

    public synchronized void unRegisterVdrLocationLis(String str) {
        com.huawei.location.vdr.listener.LW.yn().yn(str);
        if (com.huawei.location.vdr.listener.LW.yn().Vw()) {
            clearVdr();
            LogLocation.i(TAG, "stop vdr manager");
        }
    }
}
