package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzjm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.1.2 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes2.dex */
public class AppMeasurementSdk {
    private final zzdy zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.1.2 */
    @KeepForSdk
    public static final class ConditionalUserProperty {

        @KeepForSdk
        public static final String ACTIVE = "active";

        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";

        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";

        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";

        @KeepForSdk
        public static final String NAME = "name";

        @KeepForSdk
        public static final String ORIGIN = "origin";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";

        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";

        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";

        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";

        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";

        @KeepForSdk
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.1.2 */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzjm {
        @Override // com.google.android.gms.measurement.internal.zzjm
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.1.2 */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzjl {
        @Override // com.google.android.gms.measurement.internal.zzjl
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zza.zza(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zza();
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zza(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context) {
        return zzdy.zza(context).zzb();
    }

    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzdy.zza(context, str, str2, str3, bundle).zzb();
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.zza.zzd();
    }

    @KeepForSdk
    public String getAppInstanceId() {
        return this.zza.zzf();
    }

    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.zza.zzg();
    }

    @KeepForSdk
    public String getCurrentScreenName() {
        return this.zza.zzh();
    }

    @KeepForSdk
    public String getGmpAppId() {
        return this.zza.zzi();
    }

    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public AppMeasurementSdk(zzdy zzdyVar) {
        this.zza = zzdyVar;
    }

    @KeepForSdk
    public void beginAdUnitExposure(String str) {
        this.zza.zzb(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(String str) {
        this.zza.zzc(str);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @KeepForSdk
    public void performAction(Bundle bundle) {
        this.zza.zza(bundle, false);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zza(onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @KeepForSdk
    public void setConsent(Bundle bundle) {
        this.zza.zzb(bundle);
    }

    @KeepForSdk
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zza(activity, str, str2);
    }

    public final void zza(boolean z) {
        this.zza.zza(z);
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zza(eventInterceptor);
    }

    @KeepForSdk
    public void setMeasurementEnabled(Boolean bool) {
        this.zza.zza(bool);
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z) {
        this.zza.zza(Boolean.valueOf(z));
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzb(onEventListener);
    }
}
