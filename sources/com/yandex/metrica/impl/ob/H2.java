package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class H2 {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile H2 l;
    private static final Object m = new Object();
    private final Context a;
    private final WifiManager b;
    private C1388yd c;
    private Ed d;
    private C0958gm e;
    private InterfaceC1082lm<Context, Intent, Void> f;
    private C1178pi g;
    private final InterfaceC1412zd h;
    private final InterfaceC1412zd i;
    private final I2 j;
    private final J2 k;

    private H2(Context context, WifiManager wifiManager, Ed ed) {
        this(context, wifiManager, ed, new C1388yd(ed.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.yandex.metrica.impl.ob.F2> c() {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.H2.c():java.util.List");
    }

    public static H2 a(Context context) {
        if (l == null) {
            synchronized (m) {
                try {
                    if (l == null) {
                        Context applicationContext = context.getApplicationContext();
                        l = new H2(applicationContext, (WifiManager) applicationContext.getApplicationContext().getSystemService("wifi"), new Ed());
                    }
                } finally {
                }
            }
        }
        return l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.yandex.metrica.impl.ob.F2> b() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.yandex.metrica.impl.ob.yd r0 = r2.c     // Catch: java.lang.Throwable -> L2d
            android.content.Context r1 = r2.a     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.c(r1)     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto Ld
            r0 = 0
            goto L25
        Ld:
            android.net.wifi.WifiManager r0 = r2.b     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L1c
            boolean r0 = r0.isWifiEnabled()     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 != 0) goto L20
            goto L21
        L20:
            r1 = r0
        L21:
            boolean r0 = r1.booleanValue()     // Catch: java.lang.Throwable -> L2d
        L25:
            if (r0 != 0) goto L2f
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r2)
            return r0
        L2d:
            r0 = move-exception
            goto L35
        L2f:
            java.util.List r0 = r2.c()     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r2)
            return r0
        L35:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.H2.b():java.util.List");
    }

    private H2(Context context, WifiManager wifiManager, Ed ed, C1388yd c1388yd) {
        this(context, wifiManager, ed, new C0958gm(), c1388yd, new G1(), new I2(), F0.g().h().d());
    }

    public void a(C1178pi c1178pi) {
        this.g = c1178pi;
        this.d.a(c1178pi);
        this.c.a(this.d.a());
        if (c1178pi.d() != null) {
            I2 i2 = this.j;
            Ph phD = c1178pi.d();
            i2.a.a(phD.b, i2.a(phD));
        }
    }

    H2(Context context, WifiManager wifiManager, Ed ed, C0958gm c0958gm, C1388yd c1388yd, G1 g1, I2 i2, J2 j2) {
        this.a = context;
        this.b = wifiManager;
        this.d = ed;
        this.c = c1388yd;
        this.h = g1.d(c1388yd);
        this.i = g1.e(c1388yd);
        this.e = c0958gm;
        this.j = i2;
        this.k = j2;
    }

    public void a(boolean z) {
        this.d.a(z);
        this.c.a(this.d.a());
    }

    @SuppressLint({"MissingPermission"})
    public synchronized boolean a(CountDownLatch countDownLatch, V v) {
        Boolean boolValueOf;
        try {
            if (!this.i.a(this.a)) {
                return false;
            }
            if (this.f == null) {
                this.f = new G2(this, v, countDownLatch);
            }
            this.k.a(this.f);
            WifiManager wifiManager = this.b;
            if (wifiManager != null) {
                try {
                    boolValueOf = Boolean.valueOf(wifiManager.startScan());
                } catch (Throwable unused) {
                }
            } else {
                boolValueOf = null;
            }
            return Boolean.TRUE.equals(boolValueOf);
        } catch (Throwable th) {
            throw th;
        }
    }

    public I2 a() {
        return this.j;
    }
}
