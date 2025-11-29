package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
class zzja implements zzjc {
    protected final zzhy zzu;

    @Override // com.google.android.gms.measurement.internal.zzjc
    public Context zza() {
        return this.zzu.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public zzab zzd() {
        return this.zzu.zzd();
    }

    public zzag zze() {
        return this.zzu.zzf();
    }

    public zzaz zzf() {
        return this.zzu.zzg();
    }

    public zzgh zzi() {
        return this.zzu.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public zzgo zzj() {
        return this.zzu.zzj();
    }

    public zzha zzk() {
        return this.zzu.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzjc
    public zzhv zzl() {
        return this.zzu.zzl();
    }

    public zzos zzq() {
        return this.zzu.zzt();
    }

    zzja(zzhy zzhyVar) {
        Preconditions.checkNotNull(zzhyVar);
        this.zzu = zzhyVar;
    }

    public void zzr() {
        this.zzu.zzl().zzr();
    }

    public void zzs() {
        this.zzu.zzy();
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }
}
