package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zzil implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzic zzb;

    zzil(zzic zzicVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zzr();
        this.zzb.zza.zzc(this.zza);
    }
}
