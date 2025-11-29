package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzgl {
    private static zzgk zza;

    public static synchronized zzgk zza() {
        try {
            if (zza == null) {
                zza(new zzgn());
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    private static synchronized void zza(zzgk zzgkVar) {
        if (zza != null) {
            throw new IllegalStateException("init() already called");
        }
        zza = zzgkVar;
    }
}
