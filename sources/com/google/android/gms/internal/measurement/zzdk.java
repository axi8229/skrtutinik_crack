package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzdk extends zzdn {
    private final AtomicReference<Bundle> zza = new AtomicReference<>();
    private boolean zzb;

    public final Bundle zza(long j) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }

    public final Long zzb(long j) {
        return (Long) zza(zza(j), Long.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T zza(android.os.Bundle r3, java.lang.Class<T> r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L3e
            java.lang.String r1 = "r"
            java.lang.Object r3 = r3.get(r1)
            if (r3 == 0) goto L3e
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> L10
            return r3
        L10:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected object type. Expected, Received"
            r1.append(r2)
            java.lang.String r2 = ": %s, %s"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r3}
            java.lang.String r3 = java.lang.String.format(r1, r3)
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdk.zza(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final String zzc(long j) {
        return (String) zza(zza(j), String.class);
    }

    @Override // com.google.android.gms.internal.measurement.zzdo
    public final void zza(Bundle bundle) {
        synchronized (this.zza) {
            try {
                try {
                    this.zza.set(bundle);
                    this.zzb = true;
                } finally {
                    this.zza.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
