package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zznx implements Runnable {
    private final /* synthetic */ zzok zza;
    private final /* synthetic */ zznv zzb;

    zznx(zznv zznvVar, zzok zzokVar) {
        this.zza = zzokVar;
        this.zzb = zznvVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zznv.zza(this.zzb, this.zza);
        this.zzb.zzv();
    }
}
