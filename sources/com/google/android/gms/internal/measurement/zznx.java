package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zznx implements Supplier<zznw> {
    private static zznx zza = new zznx();
    private final Supplier<zznw> zzb = Suppliers.ofInstance(new zznz());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznw get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznw) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznw) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznw) zza.get()).zzc();
    }
}
