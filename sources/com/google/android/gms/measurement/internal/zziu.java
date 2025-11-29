package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zziu implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzic zzc;

    zziu(zzic zzicVar, zzbf zzbfVar, zzo zzoVar) {
        this.zza = zzbfVar;
        this.zzb = zzoVar;
        this.zzc = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
