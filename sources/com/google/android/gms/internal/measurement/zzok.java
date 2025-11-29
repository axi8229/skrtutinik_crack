package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzok implements Supplier<zzon> {
    private static zzok zza = new zzok();
    private final Supplier<zzon> zzb = Suppliers.ofInstance(new zzom());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzon get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzon) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzon) zza.get()).zzb();
    }
}
