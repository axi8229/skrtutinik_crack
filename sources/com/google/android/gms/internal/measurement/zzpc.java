package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzpc implements Supplier<zzpf> {
    private static zzpc zza = new zzpc();
    private final Supplier<zzpf> zzb = Suppliers.ofInstance(new zzpe());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpf get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpf) zza.get()).zza();
    }
}
