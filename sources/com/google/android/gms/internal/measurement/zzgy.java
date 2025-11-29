package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzgy implements zzhh {
    private final SimpleArrayMap<String, SimpleArrayMap<String, String>> zza;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    @Override // com.google.android.gms.internal.measurement.zzhh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(android.net.Uri r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L8
            java.lang.String r3 = r2.toString()
            goto La
        L8:
            if (r3 == 0) goto Le
        La:
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.String>> r2 = r1.zza
            if (r2 != 0) goto L10
        Le:
            r2 = r0
            goto L16
        L10:
            java.lang.Object r2 = r2.get(r3)
            androidx.collection.SimpleArrayMap r2 = (androidx.collection.SimpleArrayMap) r2
        L16:
            if (r2 != 0) goto L19
            return r0
        L19:
            if (r4 == 0) goto L2a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
        L2a:
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgy.zza(android.net.Uri, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    zzgy(SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap) {
        this.zza = simpleArrayMap;
    }
}
