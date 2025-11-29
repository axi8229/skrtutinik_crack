package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.1.2 */
/* loaded from: classes.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzb;
    final Map<String, Object> zza;
    private final AppMeasurementSdk zzc;

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!com.google.firebase.analytics.connector.internal.zzb.zzf(str) || zza(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zzc;
        Object zzeVar = AppMeasurement.FIAM_ORIGIN.equals(str) ? new zze(appMeasurementSdk, analyticsConnectorListener) : "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
        if (zzeVar == null) {
            return null;
        }
        this.zza.put(str, zzeVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle(this) { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
            private final /* synthetic */ AnalyticsConnectorImpl zzb;

            {
                this.zzb = this;
            }
        };
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (zzb == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, new Executor() { // from class: com.google.firebase.analytics.connector.zza
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new EventHandler() { // from class: com.google.firebase.analytics.connector.zzb
                                @Override // com.google.firebase.events.EventHandler
                                public final void handle(Event event) {
                                    AnalyticsConnectorImpl.zza(event);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        zzb = new AnalyticsConnectorImpl(zzdy.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzc.getUserProperties(null, null, z);
    }

    private AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zzc = appMeasurementSdk;
        this.zza = new ConcurrentHashMap();
    }

    static /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzb)).zzc.zza(z);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.zzb.zzf(str) && com.google.firebase.analytics.connector.internal.zzb.zza(str2, bundle) && com.google.firebase.analytics.connector.internal.zzb.zzb(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.zzb.zza(str, str2, bundle);
            this.zzc.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.zzb.zzf(str) && com.google.firebase.analytics.connector.internal.zzb.zza(str, str2)) {
            this.zzc.setUserProperty(str, str2, obj);
        }
    }

    private final boolean zza(String str) {
        return (str.isEmpty() || !this.zza.containsKey(str) || this.zza.get(str) == null) ? false : true;
    }
}
