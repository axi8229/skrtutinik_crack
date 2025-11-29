package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes2.dex */
final class zzma extends zzmb {
    private final /* synthetic */ zzlv zza;

    @Override // com.google.android.gms.internal.measurement.zzmb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzlx(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzma(zzlv zzlvVar) {
        super(zzlvVar);
        this.zza = zzlvVar;
    }
}
