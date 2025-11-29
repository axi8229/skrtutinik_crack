package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
final class zzkl implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjq zzb;

    zzkl(zzjq zzjqVar, long j) {
        this.zza = j;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzb(this.zza);
        this.zzb.zzo().zza(new AtomicReference<>());
    }
}
