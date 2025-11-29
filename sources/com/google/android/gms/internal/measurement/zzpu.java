package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzpu implements Supplier<zzpx> {
    private static zzpu zza = new zzpu();
    private final Supplier<zzpx> zzb = Suppliers.ofInstance(new zzpw());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpx get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpx) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpx) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpx) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzpx) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpx) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpx) zza.get()).zzf();
    }
}
