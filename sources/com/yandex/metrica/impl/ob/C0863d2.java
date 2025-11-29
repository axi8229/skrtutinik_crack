package com.yandex.metrica.impl.ob;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;

/* renamed from: com.yandex.metrica.impl.ob.d2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0863d2 {
    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x001f), top: B:27:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[Catch: all -> 0x0024, TRY_ENTER, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x001f), top: B:27:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.yandex.metrica.impl.ob.C0838c2 a(android.content.Context r10) {
        /*
            r9 = this;
            r0 = 30
            r1 = 0
            boolean r0 = com.yandex.metrica.impl.ob.A2.a(r0)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto Le
            android.view.Display r0 = com.yandex.metrica.impl.ob.d2$$ExternalSyntheticApiModelOutline0.m(r10)     // Catch: java.lang.Throwable -> Le
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 != 0) goto L1d
            java.lang.String r0 = "window"
            java.lang.Object r0 = r10.getSystemService(r0)     // Catch: java.lang.Throwable -> L24
            android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch: java.lang.Throwable -> L24
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch: java.lang.Throwable -> L24
        L1d:
            if (r0 == 0) goto L24
            android.graphics.Point r0 = r9.a(r0)     // Catch: java.lang.Throwable -> L24
            goto L25
        L24:
            r0 = r1
        L25:
            if (r0 != 0) goto L28
            return r1
        L28:
            int r1 = r0.x
            int r2 = r0.y
            int r4 = java.lang.Math.max(r1, r2)
            int r1 = r0.x
            int r2 = r0.y
            int r5 = java.lang.Math.min(r1, r2)
            android.content.res.Resources r1 = r10.getResources()     // Catch: java.lang.Throwable -> L47
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()     // Catch: java.lang.Throwable -> L47
            int r2 = r1.densityDpi     // Catch: java.lang.Throwable -> L47
            float r1 = r1.density     // Catch: java.lang.Throwable -> L48
        L44:
            r7 = r1
            r6 = r2
            goto L4a
        L47:
            r2 = 0
        L48:
            r1 = 0
            goto L44
        L4a:
            com.yandex.metrica.impl.ob.c2 r1 = new com.yandex.metrica.impl.ob.c2
            com.yandex.metrica.b r8 = com.yandex.metrica.impl.ob.H1.a(r10, r0)
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C0863d2.a(android.content.Context):com.yandex.metrica.impl.ob.c2");
    }

    private Point a(Display display) {
        if (display != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
