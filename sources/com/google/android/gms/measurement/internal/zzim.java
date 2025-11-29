package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zzim implements Runnable {
    private final /* synthetic */ zzae zza;
    private final /* synthetic */ zzic zzb;

    zzim(zzic zzicVar, zzae zzaeVar) {
        this.zza = zzaeVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zza(this.zza);
        } else {
            this.zzb.zza.zzb(this.zza);
        }
    }
}
