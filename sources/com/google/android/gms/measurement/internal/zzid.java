package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
final class zzid implements Runnable {
    private final /* synthetic */ zzjo zza;
    private final /* synthetic */ zzhy zzb;

    zzid(zzhy zzhyVar, zzjo zzjoVar) {
        this.zza = zzjoVar;
        this.zzb = zzhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzhy.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
