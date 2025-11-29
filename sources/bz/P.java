package bz;

import android.content.Context;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;

/* loaded from: classes.dex */
public final class P extends AbstractC0538n1 {
    public static final String d = AbstractC0569y0.a(new byte[]{-89, 25, -116, -94, -111, 46, 64, -59, 125, 96, 58, 98, -90, -13, -108, -28, 77, 22, 108, 104, -47, -100, -43, -89, -81, 51, -41, ByteSourceJsonBootstrapper.UTF8_BOM_3, -68, 119, -77, 108});
    public static final String e = AbstractC0569y0.a(new byte[]{-97, -95, -92, -101, -20, -62, 97, 26, 86, ByteSourceJsonBootstrapper.UTF8_BOM_3, -31, 12, 91, -127, -87, 87});
    public final Context c;

    public P(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.Debugger);
        this.c = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
    
        if (java.lang.Integer.decode(r4.substring(r6.length() + 1).trim()).intValue() <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        r1 = true;
     */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h() throws java.io.IOException {
        /*
            r8 = this;
            android.content.Context r0 = r8.c
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.flags
            r0 = r0 & 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            boolean r3 = android.os.Debug.isDebuggerConnected()
            if (r3 == 0) goto L19
            r0 = r0 | 2
        L19:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L78
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L78
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L78
            java.lang.String r6 = bz.P.d     // Catch: java.lang.Throwable -> L78
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L78
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L78
            r5 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L78
        L2c:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L67
            int r5 = r4.length()     // Catch: java.lang.Throwable -> L65
            java.lang.String r6 = bz.P.e     // Catch: java.lang.Throwable -> L65
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L65
            if (r5 <= r7) goto L2c
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = r4.substring(r1, r5)     // Catch: java.lang.Throwable -> L65
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L2c
            int r5 = r6.length()     // Catch: java.lang.Throwable -> L65
            int r5 = r5 + r2
            java.lang.String r4 = r4.substring(r5)     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L65
            java.lang.Integer r4 = java.lang.Integer.decode(r4)     // Catch: java.lang.Throwable -> L65
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L65
            if (r4 <= 0) goto L67
            r1 = r2
            goto L67
        L65:
            r1 = move-exception
            goto L6f
        L67:
            r3.close()     // Catch: java.lang.Throwable -> L6a
        L6a:
            if (r1 == 0) goto L78
            r0 = r0 | 4
            goto L78
        L6f:
            r3.close()     // Catch: java.lang.Throwable -> L73
            goto L77
        L73:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L78
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78 java.lang.Throwable -> L78
        L78:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.P.h():java.io.Serializable");
    }
}
