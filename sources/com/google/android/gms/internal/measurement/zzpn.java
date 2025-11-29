package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzpn implements Supplier<zzpm> {
    private static zzpn zza = new zzpn();
    private final Supplier<zzpm> zzb = Suppliers.ofInstance(new zzpp());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpm get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpm) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpm) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpm) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzpm) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpm) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpm) zza.get()).zzf();
    }

    public static boolean zzg() {
        return ((zzpm) zza.get()).zzg();
    }

    public static boolean zzh() {
        return ((zzpm) zza.get()).zzh();
    }

    public static boolean zzi() {
        return ((zzpm) zza.get()).zzi();
    }

    public static boolean zzj() {
        return ((zzpm) zza.get()).zzj();
    }

    public static boolean zzk() {
        return ((zzpm) zza.get()).zzk();
    }

    public static boolean zzl() {
        return ((zzpm) zza.get()).zzl();
    }
}
