package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzmy;
import com.google.android.gms.measurement.internal.zznc;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements zznc {
    private zzmy<AppMeasurementService> zza;

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

    private final zzmy<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzmy<>(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // android.app.Service
    public final void onCreate() throws IllegalStateException {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() throws IllegalStateException {
        zza().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) throws IllegalStateException {
        zza().zzb(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zznc
    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzc(intent);
    }
}
