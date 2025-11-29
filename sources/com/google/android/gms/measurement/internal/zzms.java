package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
final class zzms implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzmq zzb;

    zzms(zzmq zzmqVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zzmqVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzls.zza(this.zzb.zza, this.zza);
    }
}
