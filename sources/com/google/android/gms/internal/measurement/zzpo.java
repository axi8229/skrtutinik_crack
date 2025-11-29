package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzpo implements Supplier<zzpr> {
    private static zzpo zza = new zzpo();
    private final Supplier<zzpr> zzb = Suppliers.ofInstance(new zzpq());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpr get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpr) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpr) zza.get()).zzb();
    }
}
