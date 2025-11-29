package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zznm implements Supplier<zznp> {
    private static zznm zza = new zznm();
    private final Supplier<zznp> zzb = Suppliers.ofInstance(new zzno());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznp get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznp) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznp) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznp) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zznp) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zznp) zza.get()).zze();
    }
}
