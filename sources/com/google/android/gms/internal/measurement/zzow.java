package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzow implements Supplier<zzoz> {
    private static zzow zza = new zzow();
    private final Supplier<zzoz> zzb = Suppliers.ofInstance(new zzoy());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoz get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzoz) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzoz) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzoz) zza.get()).zzc();
    }
}
