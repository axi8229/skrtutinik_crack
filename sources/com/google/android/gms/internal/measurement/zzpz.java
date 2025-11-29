package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzpz implements Supplier<zzpy> {
    private static zzpz zza = new zzpz();
    private final Supplier<zzpy> zzb = Suppliers.ofInstance(new zzqb());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpy get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpy) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpy) zza.get()).zzb();
    }
}
