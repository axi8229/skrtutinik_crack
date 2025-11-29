package bz;

/* loaded from: classes.dex */
public final class E extends R0 {
    public final /* synthetic */ F a;

    public E(F f) {
        this.a = f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r1.a(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r1 = r7.a.e;
        r2 = zone.bi.mobile.fingerprint.api.f.GoogleServicesDeviceId;
        r3 = r0.getString(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (r3 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        r1.getClass();
        r4 = new bz.C0572z0(r3);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r7 = this;
            bz.F r0 = r7.a     // Catch: java.lang.Throwable -> L57
            android.content.Context r0 = r0.d     // Catch: java.lang.Throwable -> L57
            android.content.ContentResolver r1 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = bz.F.g     // Catch: java.lang.Throwable -> L57
            android.net.Uri r2 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L57
            bz.F r0 = r7.a     // Catch: java.lang.Throwable -> L57
            java.lang.String[] r5 = r0.c     // Catch: java.lang.Throwable -> L57
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L57
        L19:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L48
            r1 = 0
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = bz.F.f     // Catch: java.lang.Throwable -> L42
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L19
            bz.F r1 = r7.a     // Catch: java.lang.Throwable -> L42
            bz.Z0 r1 = r1.e     // Catch: java.lang.Throwable -> L42
            zone.bi.mobile.fingerprint.api.f r2 = zone.bi.mobile.fingerprint.api.f.GoogleServicesDeviceId     // Catch: java.lang.Throwable -> L42
            r3 = 1
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L42
            if (r3 == 0) goto L44
            r1.getClass()     // Catch: java.lang.Throwable -> L42
            bz.z0 r4 = new bz.z0     // Catch: java.lang.Throwable -> L42
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L42
            goto L45
        L42:
            r1 = move-exception
            goto L4c
        L44:
            r4 = 0
        L45:
            r1.a(r2, r4)     // Catch: java.lang.Throwable -> L42
        L48:
            r0.close()     // Catch: java.lang.Throwable -> L57
            goto L57
        L4c:
            if (r0 == 0) goto L56
            r0.close()     // Catch: java.lang.Throwable -> L52
            goto L56
        L52:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L57
        L56:
            throw r1     // Catch: java.lang.Throwable -> L57
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.E.run():void");
    }
}
