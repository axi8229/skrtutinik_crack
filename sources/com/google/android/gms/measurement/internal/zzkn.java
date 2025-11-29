package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
final class zzkn implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzjq zzb;

    zzkn(zzjq zzjqVar, Bundle bundle) {
        this.zza = bundle;
        this.zzb = zzjqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzjq.zza(this.zzb, this.zza);
    }
}
