package com.huawei.location.sdm;

import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.CollectionsUtils;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.location.lite.common.util.SystemPropertiesUtil;
import com.huawei.riemann.common.api.location.SdmLocationClient;
import com.huawei.riemann.location.bean.DeviceInfo;
import com.huawei.riemann.location.bean.obs.GnssClock;
import com.huawei.riemann.location.bean.obs.GnssRawObservation;
import com.huawei.riemann.location.bean.obs.Pvt;
import com.huawei.riemann.location.bean.obs.SatelliteMeasurement;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.yandex.varioqub.config.model.ConfigValue;
import ru.yoomoney.sdk.yooprofiler.YooProfilerImpl;

/* loaded from: classes3.dex */
public class Sdm {
    private HandlerThread E5;
    private com.huawei.location.sdm.utils.yn EF;
    private FB FB;
    private com.huawei.location.sdm.yn LW;
    private com.huawei.location.tiles.callback.yn OB;
    private DeviceInfo Ot;
    private com.huawei.location.ephemeris.yn SI;
    private LocationManager Vw;
    private com.huawei.location.support.yn Wf;
    private HandlerThread d2;
    private Location dC;
    private SdmLocationClient ut;
    private Vw zp;
    private long yn = -1;
    private Config oc = null;
    private int G3 = 1;
    private Boolean Yx = Boolean.FALSE;
    private long h1 = 0;
    private long dW = 0;
    private GnssMeasurementsEvent.Callback Eu = new yn();

    private class FB extends Handler {
        public static final /* synthetic */ int $r8$clinit = 0;

        FB(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            int i = message.what;
            if (i == 1) {
                LogLocation.i("Sdm", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (obj instanceof Location) {
                    Sdm.yn(Sdm.this, (Location) obj);
                    return;
                }
                str2 = "handleMessage not location obj";
            } else {
                if (i != 3) {
                    yn ynVar = null;
                    if (i == 2) {
                        LogLocation.i("Sdm", "stop begin");
                        Object obj2 = message.obj;
                        if (!(obj2 instanceof com.huawei.location.sdm.yn)) {
                            LogLocation.e("Sdm", "handleMessage not SdmListener obj");
                            return;
                        }
                        if (((com.huawei.location.sdm.yn) obj2).equals(Sdm.this.LW)) {
                            Sdm.this.LW = null;
                            Sdm.this.Wf.Vw();
                            if (Sdm.this.ut != null) {
                                Sdm.this.ut.stopLocation();
                            }
                            LogLocation.i("Sdm", "The algorithm is disabled");
                            if (Sdm.this.zp != null) {
                                Vw vw = Sdm.this.zp;
                                Sdm.this.Vw.removeUpdates(vw);
                            }
                            Sdm.Vw(Sdm.this);
                            Sdm.this.G3 = 1;
                            Sdm.this.Yx = Boolean.FALSE;
                            Sdm.this.h1 = 0L;
                            Sdm.this.dW = 0L;
                        }
                        LogLocation.i("Sdm", "stop end");
                        return;
                    }
                    if (i != 4) {
                        LogLocation.e("Sdm", "unknown msg:" + message.what);
                        return;
                    }
                    LogLocation.i("Sdm", "add listener");
                    Object obj3 = message.obj;
                    if (!(obj3 instanceof com.huawei.location.sdm.yn)) {
                        LogLocation.e("Sdm", "handleMessage not SdmListener obj");
                        return;
                    }
                    com.huawei.location.sdm.yn ynVar2 = (com.huawei.location.sdm.yn) obj3;
                    if (Sdm.this.LW == null) {
                        Sdm sdm = Sdm.this;
                        sdm.zp = new Vw(sdm, ynVar);
                        Vw vw2 = Sdm.this.zp;
                        Looper looper = getLooper();
                        vw2.getClass();
                        try {
                            Sdm.this.Vw.requestLocationUpdates("gps", 1000L, 0.0f, vw2, looper);
                            LogLocation.i("Sdm", "location listener register success");
                        } catch (IllegalArgumentException unused) {
                            str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                            LogLocation.e("Sdm", str);
                            Sdm.FB(Sdm.this);
                            Sdm.this.LW = ynVar2;
                            LogLocation.i("Sdm", "add listener success");
                            return;
                        } catch (SecurityException unused2) {
                            str = "LocationManager requestLocationUpdates throw SecurityException";
                            LogLocation.e("Sdm", str);
                            Sdm.FB(Sdm.this);
                            Sdm.this.LW = ynVar2;
                            LogLocation.i("Sdm", "add listener success");
                            return;
                        } catch (Exception unused3) {
                            str = "LocationManager requestLocationUpdates throw other exception";
                            LogLocation.e("Sdm", str);
                            Sdm.FB(Sdm.this);
                            Sdm.this.LW = ynVar2;
                            LogLocation.i("Sdm", "add listener success");
                            return;
                        }
                        Sdm.FB(Sdm.this);
                        Sdm.this.LW = ynVar2;
                        LogLocation.i("Sdm", "add listener success");
                        return;
                    }
                    return;
                }
                LogLocation.i("Sdm", "handleMessage: LOCATION_PROCESS");
                Object obj4 = message.obj;
                if (obj4 instanceof GnssMeasurementsEvent) {
                    Sdm.yn(Sdm.this, (GnssMeasurementsEvent) obj4);
                    return;
                }
                str2 = "handleMessage not GnssMeasurementsEvent obj";
            }
            LogLocation.e("Sdm", str2);
        }
    }

    private class Vw implements LocationListener {
        private Vw() {
        }

        /* synthetic */ Vw(Sdm sdm, yn ynVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                LogLocation.e("Sdm", "location null");
                return;
            }
            if (Sdm.this.FB == null || Sdm.this.d2 == null || !Sdm.this.d2.isAlive()) {
                Sdm.this.d2 = new HandlerThread("Sdm");
                Sdm.this.d2.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                sdm.FB = sdm2.new FB(sdm2.d2.getLooper());
            }
            Sdm.this.FB.obtainMessage(1, location).sendToTarget();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            LogLocation.d("Sdm", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            LogLocation.d("Sdm", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            LogLocation.d("Sdm", "onStatusChanged");
        }
    }

    class yn extends GnssMeasurementsEvent.Callback {
        yn() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (System.currentTimeMillis() - Sdm.this.yn < 900) {
                LogLocation.i("Sdm", "do nothing because MeasurementsEvent is too fast");
                return;
            }
            Sdm.this.yn = System.currentTimeMillis();
            if (Sdm.this.FB == null || Sdm.this.d2 == null || !Sdm.this.d2.isAlive()) {
                Sdm.this.d2 = new HandlerThread("Sdm");
                Sdm.this.d2.start();
                Sdm sdm = Sdm.this;
                Sdm sdm2 = Sdm.this;
                sdm.FB = sdm2.new FB(sdm2.d2.getLooper());
            }
            Sdm.this.FB.obtainMessage(3, gnssMeasurementsEvent).sendToTarget();
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            LogLocation.i("Sdm", "GnssMeasurementsEvent onStatusChanged :" + i);
            super.onStatusChanged(i);
        }
    }

    public Sdm() {
        yn();
    }

    static void FB(Sdm sdm) {
        sdm.getClass();
        try {
            LogLocation.i("Sdm", "RegisterMeasurements:" + sdm.Vw.registerGnssMeasurementsCallback(sdm.Eu));
        } catch (Exception unused) {
            LogLocation.e("Sdm", "registerGnssMeasurements error.");
        }
    }

    static void Vw(Sdm sdm) {
        LocationManager locationManager = sdm.Vw;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(sdm.Eu);
        }
    }

    private void yn() {
        Config config = new Config();
        this.oc = config;
        if (config.E5()) {
            return;
        }
        this.oc = null;
    }

    static void yn(Sdm sdm, Location location) {
        sdm.getClass();
        if (location == null) {
            LogLocation.i("Sdm", "location is null");
            return;
        }
        if (sdm.dC == null || SystemClock.elapsedRealtime() - sdm.dW > YooProfilerImpl.TIMER_LIMIT || !sdm.Yx.booleanValue()) {
            com.huawei.location.sdm.yn ynVar = sdm.LW;
            if (ynVar != null) {
                ynVar.onLocationChanged(location);
            }
        } else {
            com.huawei.location.sdm.yn ynVar2 = sdm.LW;
            if (ynVar2 != null) {
                ynVar2.onLocationChanged(sdm.dC);
            }
        }
        sdm.dC = location;
        sdm.dW = SystemClock.elapsedRealtime();
        sdm.Yx = Boolean.FALSE;
    }

    public void remove(com.huawei.location.sdm.yn ynVar) {
        HandlerThread handlerThread;
        if (ynVar == null) {
            LogLocation.w("Sdm", "no has listener");
            return;
        }
        if (this.FB != null && (handlerThread = this.d2) != null && handlerThread.isAlive()) {
            FB fb = this.FB;
            int i = FB.$r8$clinit;
            fb.obtainMessage(2, ynVar).sendToTarget();
        }
        this.E5.quitSafely();
        this.E5 = null;
    }

    public void request(com.huawei.location.sdm.yn ynVar) {
        HandlerThread handlerThread;
        if (ynVar == null) {
            LogLocation.w("Sdm", "no has listener");
            return;
        }
        if (this.LW == null) {
            if (this.OB == null) {
                this.OB = new com.huawei.location.tiles.callback.yn(this.oc.FB(), this.oc.LW());
            }
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                this.Vw = (LocationManager) systemService;
            }
            if (this.SI == null) {
                this.SI = new com.huawei.location.ephemeris.yn();
            }
            if (this.Wf == null) {
                this.Wf = new com.huawei.location.support.yn();
            }
            if (this.EF == null) {
                this.EF = new com.huawei.location.sdm.utils.yn();
            }
            if (this.Ot == null) {
                DeviceInfo.Builder builderADeviceInfo = DeviceInfo.Builder.aDeviceInfo();
                builderADeviceInfo.withChipName(com.huawei.location.sdm.constant.yn.Vw(SystemPropertiesUtil.getPlatform()));
                builderADeviceInfo.withManufacturer(Build.MANUFACTURER);
                builderADeviceInfo.withSdkLevel(Build.VERSION.SDK_INT);
                this.Ot = builderADeviceInfo.build();
            }
            this.EF.yn();
            HandlerThread handlerThread2 = this.E5;
            if (handlerThread2 == null || !handlerThread2.isAlive()) {
                HandlerThread handlerThread3 = new HandlerThread("Location-SDM-SUPPORT");
                this.E5 = handlerThread3;
                handlerThread3.start();
            }
            this.Wf.yn(this.E5.getLooper(), this.SI, this.oc);
            if (this.FB == null || (handlerThread = this.d2) == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread4 = new HandlerThread("Sdm");
                this.d2 = handlerThread4;
                handlerThread4.start();
                this.FB = new FB(this.d2.getLooper());
            }
            this.FB.obtainMessage(4, ynVar).sendToTarget();
        }
    }

    public boolean support(long j, float f) {
        if (this.oc == null) {
            LogLocation.w("Sdm", "no config");
            return false;
        }
        if (j > DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM || f > 10.0f) {
            LogLocation.i("Sdm", "not support sdm, minTime:" + j + ",minDistance:" + f);
            return false;
        }
        String strYn = com.huawei.location.sdm.constant.yn.yn(SystemPropertiesUtil.getPlatform());
        boolean z = ROMUtil.getHuaweiPlatformROMType() != 3 ? !"".equals(strYn) && this.oc.yn(strYn, com.huawei.location.sdm.constant.Vw.yn(Build.VERSION.SDK_INT)) : false;
        LogLocation.i("Sdm", "SDM support:" + z + ",The phone ChipType:" + strYn + ",The phone OsVersion:" + com.huawei.location.sdm.constant.Vw.yn(Build.VERSION.SDK_INT));
        return z;
    }

    static void yn(Sdm sdm, GnssMeasurementsEvent gnssMeasurementsEvent) {
        Location location = sdm.dC;
        if (location == null) {
            LogLocation.e("Sdm", "location is null");
            return;
        }
        if (SystemClock.elapsedRealtime() - sdm.dW > 15000) {
            LogLocation.e("Sdm", "location is invalidation");
            sdm.dC = null;
            sdm.dW = 0L;
            return;
        }
        if (!sdm.Wf.yn(location.getLongitude(), location.getLatitude(), location.getSpeed())) {
            int i = sdm.G3 + 1;
            sdm.G3 = i;
            if (i != 1) {
                sdm.G3 = 2;
                return;
            }
            SdmLocationClient sdmLocationClient = sdm.ut;
            if (sdmLocationClient != null) {
                sdmLocationClient.stopLocation();
                sdm.h1 = 0L;
                return;
            }
            return;
        }
        if (sdm.ut == null && sdm.EF.Vw()) {
            sdm.ut = new SdmLocationClient(ContextUtil.getContext(), com.huawei.location.sdm.constant.FB.Vw);
        }
        SdmLocationClient sdmLocationClient2 = sdm.ut;
        if (sdmLocationClient2 == null) {
            LogLocation.i("Sdm", "SdmLocationClient init failed");
            return;
        }
        if (sdm.G3 == 0) {
            long j = sdm.h1;
            if (j == 0 || j != sdm.SI.FB()) {
                sdm.h1 = sdm.SI.FB();
                sdm.ut.updateEphemeris(sdm.SI.Vw());
            }
        } else {
            if (sdmLocationClient2.startLocation(sdm.Ot, sdm.OB) != 0) {
                return;
            }
            LogLocation.i("Sdm", "The algorithm is enabled");
            long j2 = sdm.h1;
            if (j2 == 0 || j2 != sdm.SI.FB()) {
                sdm.h1 = sdm.SI.FB();
                sdm.ut.updateEphemeris(sdm.SI.Vw());
            }
            sdm.G3 = 0;
        }
        sdm.dC = sdm.yn(gnssMeasurementsEvent, location);
        sdm.dW = SystemClock.elapsedRealtime();
    }

    private Location yn(GnssMeasurementsEvent gnssMeasurementsEvent, Location location) {
        GnssRawObservation[] gnssRawObservationArr;
        Pvt.Builder.aPvt();
        Pvt pvtBuild = Pvt.Builder.aPvt().withAccuracy(location.getAccuracy()).withAltitude(location.getAltitude()).withLatitude(location.getLatitude()).withBearing(location.getBearing()).withLongitude(location.getLongitude()).withSpeed(location.getSpeed()).withTime(location.getTime()).build();
        int i = 0;
        if (CollectionsUtils.isEmpty(gnssMeasurementsEvent.getMeasurements()) || gnssMeasurementsEvent.getClock() == null) {
            gnssRawObservationArr = new GnssRawObservation[0];
        } else {
            GnssClock gnssClockBuild = GnssClock.Builder.aGnssClock().withBiasNanos(gnssMeasurementsEvent.getClock().hasBiasNanos() ? gnssMeasurementsEvent.getClock().getBiasNanos() : 0.0d).withBiasUncertaintyNanos(gnssMeasurementsEvent.getClock().hasBiasUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getBiasUncertaintyNanos() : 0.0d).withDriftNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftNanosPerSecond() : 0.0d).withDriftUncertaintyNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftUncertaintyNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftUncertaintyNanosPerSecond() : 0.0d).withFullBiasNanos(gnssMeasurementsEvent.getClock().getFullBiasNanos()).withHardwareClockDiscontinuityCount(gnssMeasurementsEvent.getClock().getHardwareClockDiscontinuityCount()).withLeapSecond(gnssMeasurementsEvent.getClock().hasLeapSecond() ? gnssMeasurementsEvent.getClock().getLeapSecond() : 0).withTimeNanos(gnssMeasurementsEvent.getClock().getTimeNanos()).withTimeUncertaintyNanos(gnssMeasurementsEvent.getClock().hasTimeUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getTimeUncertaintyNanos() : 0.0d).withElapsedRealtimeMillis(Build.VERSION.SDK_INT >= 29 ? gnssMeasurementsEvent.getClock().getElapsedRealtimeNanos() : 0L).build();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[gnssMeasurementsEvent.getMeasurements().size()];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                SatelliteMeasurement.Builder builderWithSvid = SatelliteMeasurement.Builder.aSatelliteMeasurement().withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()).withCarrierCycles(gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L).withCarrierFrequencyHz(gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f).withCarrierPhase(gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : 0.0d).withCarrierPhaseUncertainty(gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : 0.0d).withCn0DbHz(gnssMeasurement.getCn0DbHz()).withConstellationType(gnssMeasurement.getConstellationType()).withSnrInDb(gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : 0.0d).withMultipathIndicator(gnssMeasurement.getMultipathIndicator()).withTimeOffsetNanos(gnssMeasurement.getTimeOffsetNanos()).withPseudorangeRateMetersPerSecond(gnssMeasurement.getPseudorangeRateMetersPerSecond()).withPseudorangeRateUncertaintyMetersPerSecond(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()).withReceivedSvTimeNanos(gnssMeasurement.getReceivedSvTimeNanos()).withReceivedSvTimeUncertaintyNanos(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()).withState(gnssMeasurement.getState()).withSvid(gnssMeasurement.getSvid());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    builderWithSvid.withAutomaticGainControlLevelInDb(gnssMeasurement.hasAutomaticGainControlLevelDb() ? gnssMeasurement.getAutomaticGainControlLevelDb() : 0.0d);
                } else {
                    builderWithSvid.withAutomaticGainControlLevelInDb(ConfigValue.DOUBLE_DEFAULT_VALUE);
                }
                if (i2 >= 30) {
                    builderWithSvid.withFullInterSignalBiasNanos(gnssMeasurement.hasFullInterSignalBiasNanos() ? gnssMeasurement.getFullInterSignalBiasNanos() : 0.0d);
                    builderWithSvid.withFullInterSignalBiasUncertaintyNanos(gnssMeasurement.hasFullInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getFullInterSignalBiasUncertaintyNanos() : 0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasNanos(gnssMeasurement.hasSatelliteInterSignalBiasNanos() ? gnssMeasurement.getSatelliteInterSignalBiasNanos() : 0.0d);
                    builderWithSvid.withSatelliteInterSignalBiasUncertaintyNanos(gnssMeasurement.hasSatelliteInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getSatelliteInterSignalBiasUncertaintyNanos() : 0.0d);
                } else {
                    builderWithSvid.withFullInterSignalBiasNanos(ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withFullInterSignalBiasUncertaintyNanos(ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withSatelliteInterSignalBiasNanos(ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withSatelliteInterSignalBiasUncertaintyNanos(ConfigValue.DOUBLE_DEFAULT_VALUE);
                }
                gnssRawObservationArr2[i] = GnssRawObservation.Builder.aGnssRawObservation().withSatelliteMeasurement(builderWithSvid.build()).withGnssClock(gnssClockBuild).build();
                i++;
            }
            gnssRawObservationArr = gnssRawObservationArr2;
        }
        if (!CollectionsUtil.isEmpty(gnssRawObservationArr) && gnssRawObservationArr.length >= 10) {
            Pvt pvtProcess = this.ut.process(pvtBuild, gnssRawObservationArr);
            if (pvtProcess.getErrCode() != 0) {
                this.Yx = Boolean.FALSE;
                LogLocation.i("Sdm", "pvt handle error,errorCode is :" + pvtProcess.getErrCode());
                return location;
            }
            this.Yx = Boolean.TRUE;
            location.setLongitude(pvtProcess.getLongitude());
            location.setLatitude(pvtProcess.getLatitude());
            location.setAccuracy(pvtProcess.getAccuracy());
            location.setBearing(pvtProcess.getBearing());
            location.setAltitude(pvtProcess.getAltitude());
            location.setSpeed(pvtProcess.getSpeed());
            Bundle extras = location.getExtras();
            SafeBundle safeBundle = new SafeBundle(extras);
            if (safeBundle.containsKey("LocationSource")) {
                safeBundle.putInt("LocationSource", extras.getInt("LocationSource") | 1);
            } else {
                safeBundle.putInt("LocationSource", 1);
            }
            location.setExtras(safeBundle.getBundle());
            LogLocation.i("Sdm", "processLocation success here, the location has been deflected");
        }
        return location;
    }
}
