package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzns implements Supplier<zznv> {
    private static zzns zza = new zzns();
    private final Supplier<zznv> zzb = Suppliers.ofInstance(new zznu());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznv get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznv) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznv) zza.get()).zzb();
    }
}
