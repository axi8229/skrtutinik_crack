package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzph implements Supplier<zzpg> {
    private static zzph zza = new zzph();
    private final Supplier<zzpg> zzb = Suppliers.ofInstance(new zzpj());

    public static double zza() {
        return ((zzpg) zza.get()).zza();
    }

    public static long zzb() {
        return ((zzpg) zza.get()).zzb();
    }

    public static long zzc() {
        return ((zzpg) zza.get()).zzc();
    }

    public static long zzd() {
        return ((zzpg) zza.get()).zzd();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpg get() {
        return this.zzb.get();
    }

    public static String zze() {
        return ((zzpg) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpg) zza.get()).zzf();
    }
}
