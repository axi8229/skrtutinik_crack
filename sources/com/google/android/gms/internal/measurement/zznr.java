package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zznr implements Supplier<zznq> {
    private static zznr zza = new zznr();
    private final Supplier<zznq> zzb = Suppliers.ofInstance(new zznt());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznq get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznq) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznq) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznq) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zznq) zza.get()).zzd();
    }
}
