package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes2.dex */
final class zzlx implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzlv zzc;

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        Object[] objArr = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (zzlz) objArr[i];
    }

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    private zzlx(zzlv zzlvVar) {
        this.zzc = zzlvVar;
        this.zza = zzlvVar.zzb;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= this.zzc.zzb) || zza().hasNext();
    }
}
