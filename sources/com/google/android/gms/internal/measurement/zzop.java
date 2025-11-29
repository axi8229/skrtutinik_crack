package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzop implements Supplier<zzoo> {
    private static zzop zza = new zzop();
    private final Supplier<zzoo> zzb = Suppliers.ofInstance(new zzor());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoo get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzoo) zza.get()).zza();
    }
}
