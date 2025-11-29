package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
final class zzll implements Runnable {
    private final /* synthetic */ zzlk zza;
    private final /* synthetic */ zzlk zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzlj zze;

    zzll(zzlj zzljVar, zzlk zzlkVar, zzlk zzlkVar2, long j, boolean z) {
        this.zza = zzlkVar;
        this.zzb = zzlkVar2;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
