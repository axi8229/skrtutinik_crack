package com.huawei.location.vdr.data;

import android.annotation.SuppressLint;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.CollectionsUtils;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssClock;
import com.huawei.riemann.gnsslocation.core.bean.obs.GnssRawObservation;
import com.huawei.riemann.gnsslocation.core.bean.obs.SatelliteMeasurement;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class yn {
    private final GnssMeasurementsEvent.Callback E5 = new C0099yn();
    LocationManager FB;
    private com.huawei.location.vdr.listener.yn LW;
    Handler Vw;
    private long dC;
    HandlerThread yn;

    /* renamed from: com.huawei.location.vdr.data.yn$yn, reason: collision with other inner class name */
    class C0099yn extends GnssMeasurementsEvent.Callback {
        C0099yn() {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            yn.yn(yn.this, gnssMeasurementsEvent);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            LogLocation.i("GnssMeasurementsProvider", "GnssMeasurementsEvent onStatusChanged :" + i);
            super.onStatusChanged(i);
        }
    }

    static void yn(yn ynVar, GnssMeasurementsEvent gnssMeasurementsEvent) {
        GnssRawObservation[] gnssRawObservationArr;
        ynVar.getClass();
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (jElapsedRealtimeNanos - ynVar.dC < 600000) {
            LogLocation.d("GnssMeasurementsProvider", "The interval does not meet requirements,dropping this gnssRaw");
            return;
        }
        ynVar.dC = jElapsedRealtimeNanos;
        long millis = TimeUnit.NANOSECONDS.toMillis(jElapsedRealtimeNanos);
        int i = 0;
        if (CollectionsUtils.isEmpty(gnssMeasurementsEvent.getMeasurements()) || gnssMeasurementsEvent.getClock() == null) {
            gnssRawObservationArr = new GnssRawObservation[0];
        } else {
            GnssClock gnssClockBuild = GnssClock.Builder.aGnssClock().withBiasNanos(gnssMeasurementsEvent.getClock().hasBiasNanos() ? gnssMeasurementsEvent.getClock().getBiasNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE).withBiasUncertaintyNanos(gnssMeasurementsEvent.getClock().hasBiasUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getBiasUncertaintyNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE).withDriftNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftNanosPerSecond() : ConfigValue.DOUBLE_DEFAULT_VALUE).withDriftUncertaintyNanosPerSecond(gnssMeasurementsEvent.getClock().hasDriftUncertaintyNanosPerSecond() ? gnssMeasurementsEvent.getClock().getDriftUncertaintyNanosPerSecond() : ConfigValue.DOUBLE_DEFAULT_VALUE).withFullBiasNanos(gnssMeasurementsEvent.getClock().getFullBiasNanos()).withHardwareClockDiscontinuityCount(gnssMeasurementsEvent.getClock().getHardwareClockDiscontinuityCount()).withLeapSecond(gnssMeasurementsEvent.getClock().hasLeapSecond() ? gnssMeasurementsEvent.getClock().getLeapSecond() : 0).withTimeNanos(gnssMeasurementsEvent.getClock().getTimeNanos()).withTimeUncertaintyNanos(gnssMeasurementsEvent.getClock().hasTimeUncertaintyNanos() ? gnssMeasurementsEvent.getClock().getTimeUncertaintyNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE).withElapsedRealtimeMillis(Build.VERSION.SDK_INT >= 29 ? gnssMeasurementsEvent.getClock().getElapsedRealtimeNanos() : 0L).build();
            GnssRawObservation[] gnssRawObservationArr2 = new GnssRawObservation[gnssMeasurementsEvent.getMeasurements().size()];
            for (GnssMeasurement gnssMeasurement : gnssMeasurementsEvent.getMeasurements()) {
                SatelliteMeasurement.Builder builderWithSvid = SatelliteMeasurement.Builder.aSatelliteMeasurement().withBootTime(millis).withAccumulatedDeltaRangeMeters(gnssMeasurement.getAccumulatedDeltaRangeMeters()).withAccumulatedDeltaRangeState(gnssMeasurement.getAccumulatedDeltaRangeState()).withAccumulatedDeltaRangeUncertaintyMeters(gnssMeasurement.getAccumulatedDeltaRangeUncertaintyMeters()).withCarrierCycles(gnssMeasurement.hasCarrierCycles() ? gnssMeasurement.getCarrierCycles() : 0L).withCarrierFrequencyHz(gnssMeasurement.hasCarrierFrequencyHz() ? gnssMeasurement.getCarrierFrequencyHz() : 0.0f).withCarrierPhase(gnssMeasurement.hasCarrierPhase() ? gnssMeasurement.getCarrierPhase() : ConfigValue.DOUBLE_DEFAULT_VALUE).withCarrierPhaseUncertainty(gnssMeasurement.hasCarrierPhaseUncertainty() ? gnssMeasurement.getCarrierPhaseUncertainty() : ConfigValue.DOUBLE_DEFAULT_VALUE).withCn0DbHz(gnssMeasurement.getCn0DbHz()).withConstellationType(gnssMeasurement.getConstellationType()).withSnrInDb(gnssMeasurement.hasSnrInDb() ? gnssMeasurement.getSnrInDb() : ConfigValue.DOUBLE_DEFAULT_VALUE).withMultipathIndicator(gnssMeasurement.getMultipathIndicator()).withTimeOffsetNanos(gnssMeasurement.getTimeOffsetNanos()).withPseudorangeRateMetersPerSecond(gnssMeasurement.getPseudorangeRateMetersPerSecond()).withPseudorangeRateUncertaintyMetersPerSecond(gnssMeasurement.getPseudorangeRateUncertaintyMetersPerSecond()).withReceivedSvTimeNanos(gnssMeasurement.getReceivedSvTimeNanos()).withReceivedSvTimeUncertaintyNanos(gnssMeasurement.getReceivedSvTimeUncertaintyNanos()).withState(gnssMeasurement.getState()).withSvid(gnssMeasurement.getSvid());
                int i2 = Build.VERSION.SDK_INT;
                builderWithSvid.withAutomaticGainControlLevelInDb((i2 < 26 || !gnssMeasurement.hasAutomaticGainControlLevelDb()) ? ConfigValue.DOUBLE_DEFAULT_VALUE : gnssMeasurement.getAutomaticGainControlLevelDb());
                if (i2 >= 30) {
                    builderWithSvid.withFullInterSignalBiasNanos(gnssMeasurement.hasFullInterSignalBiasNanos() ? gnssMeasurement.getFullInterSignalBiasNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withFullInterSignalBiasUncertaintyNanos(gnssMeasurement.hasFullInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getFullInterSignalBiasUncertaintyNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withSatelliteInterSignalBiasNanos(gnssMeasurement.hasSatelliteInterSignalBiasNanos() ? gnssMeasurement.getSatelliteInterSignalBiasNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE);
                    builderWithSvid.withSatelliteInterSignalBiasUncertaintyNanos(gnssMeasurement.hasSatelliteInterSignalBiasUncertaintyNanos() ? gnssMeasurement.getSatelliteInterSignalBiasUncertaintyNanos() : ConfigValue.DOUBLE_DEFAULT_VALUE);
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
        if (gnssRawObservationArr.length < 10) {
            LogLocation.i("GnssMeasurementsProvider", "gnssRawObservations not enough, drop here. length is : " + gnssRawObservationArr.length);
            return;
        }
        com.huawei.location.vdr.listener.yn ynVar2 = ynVar.LW;
        if (ynVar2 != null) {
            ((LW) ynVar2).Vw(gnssRawObservationArr, jElapsedRealtimeNanos);
        } else {
            LogLocation.e("GnssMeasurementsProvider", "gnss listener is null!");
        }
    }

    public void Vw() {
        LocationManager locationManager = this.FB;
        if (locationManager != null) {
            locationManager.unregisterGnssMeasurementsCallback(this.E5);
        }
        this.LW = null;
        HandlerThread handlerThread = this.yn;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.Vw = null;
    }

    @SuppressLint({"MissingPermission"})
    public void yn() {
        boolean zRegisterGnssMeasurementsCallback;
        HandlerThread handlerThread = new HandlerThread("Loc-Vdr-gnssMeasure");
        this.yn = handlerThread;
        handlerThread.start();
        this.Vw = new Handler(this.yn.getLooper());
        try {
            Object systemService = ContextUtil.getContext().getSystemService("location");
            if (systemService instanceof LocationManager) {
                this.FB = (LocationManager) systemService;
                if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                    LogLocation.e("GnssMeasurementsProvider", "init fail because of checkSelfPermission fail");
                    return;
                }
                zRegisterGnssMeasurementsCallback = this.FB.registerGnssMeasurementsCallback(this.E5, this.Vw);
            } else {
                zRegisterGnssMeasurementsCallback = false;
            }
            LogLocation.i("GnssMeasurementsProvider", "RegisterMeasurements:" + zRegisterGnssMeasurementsCallback);
        } catch (Exception unused) {
            LogLocation.e("GnssMeasurementsProvider", "registerGnssMeasurements error.");
        }
    }

    public void yn(com.huawei.location.vdr.listener.yn ynVar) {
        this.LW = ynVar;
    }
}
