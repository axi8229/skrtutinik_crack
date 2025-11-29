package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public class R2 implements O0 {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile R2 f = null;
    private static volatile boolean g = false;
    private final Context a;
    private final Q2 b;
    private final FutureTask<T0> c;
    private final S0 d;
    private final Im e;

    class a implements Callable<T0> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public T0 call() throws Exception {
            return R2.a(R2.this);
        }
    }

    private R2(Context context, Q2 q2, Im im) {
        this(context, q2, q2.a(context, im), im);
    }

    public static R2 a(Context context) {
        if (f == null) {
            synchronized (R2.class) {
                try {
                    if (f == null) {
                        f = new R2(context.getApplicationContext(), new Q2(), P.g().d());
                        R2 r2 = f;
                        r2.e.b().execute(new S2(r2));
                    }
                } finally {
                }
            }
        }
        return f;
    }

    private static InterfaceC1111n1 f() {
        return i() ? f.g() : P.g().f();
    }

    private T0 g() {
        try {
            return this.c.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean h() {
        return g;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean i() {
        /*
            java.lang.Class<com.yandex.metrica.impl.ob.R2> r0 = com.yandex.metrica.impl.ob.R2.class
            monitor-enter(r0)
            com.yandex.metrica.impl.ob.R2 r1 = com.yandex.metrica.impl.ob.R2.f     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L21
            com.yandex.metrica.impl.ob.R2 r1 = com.yandex.metrica.impl.ob.R2.f     // Catch: java.lang.Throwable -> L1f
            java.util.concurrent.FutureTask<com.yandex.metrica.impl.ob.T0> r1 = r1.c     // Catch: java.lang.Throwable -> L1f
            boolean r1 = r1.isDone()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L21
            com.yandex.metrica.impl.ob.R2 r1 = com.yandex.metrica.impl.ob.R2.f     // Catch: java.lang.Throwable -> L1f
            com.yandex.metrica.impl.ob.T0 r1 = r1.g()     // Catch: java.lang.Throwable -> L1f
            com.yandex.metrica.impl.ob.k1 r1 = r1.d()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L21
            r1 = 1
            goto L22
        L1f:
            r1 = move-exception
            goto L24
        L21:
            r1 = 0
        L22:
            monitor-exit(r0)
            return r1
        L24:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.R2.i():boolean");
    }

    public static synchronized void j() {
        g = true;
    }

    public static R2 k() {
        return f;
    }

    public C1036k1 d() {
        return g().d();
    }

    public Eb e() {
        return this.d.d();
    }

    public static void b(boolean z) {
        f().a(z);
    }

    public static void c(boolean z) {
        f().setStatisticsSending(z);
    }

    R2(Context context, Q2 q2, S0 s0, Im im) {
        this.a = context;
        this.b = q2;
        this.d = s0;
        this.e = im;
        FutureTask<T0> futureTask = new FutureTask<>(new a());
        this.c = futureTask;
        im.b().execute(futureTask);
    }

    public void b(com.yandex.metrica.i iVar) {
        this.d.a(iVar, this);
    }

    public void c(com.yandex.metrica.e eVar) {
        g().c(eVar);
    }

    public void b(YandexMetricaConfig yandexMetricaConfig, com.yandex.metrica.i iVar) {
        g().a(yandexMetricaConfig, iVar);
    }

    public String c() {
        return g().c();
    }

    public void b(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        g().a(appMetricaDeviceIDListener);
    }

    @Override // com.yandex.metrica.impl.ob.O0
    public N0 b() {
        return g().b();
    }

    public static void a(Location location) {
        f().a(location);
    }

    public static void a(boolean z) {
        f().b(z);
    }

    public static void a(String str, String str2) {
        f().c(str, str2);
    }

    public static void a(String str) {
        f().setUserProfileID(str);
    }

    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        g().a(deferredDeeplinkParametersListener);
    }

    public void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        g().a(deferredDeeplinkListener);
    }

    public M0 a(com.yandex.metrica.e eVar) {
        return g().a(eVar);
    }

    public String a() {
        return g().a();
    }

    public void a(IIdentifierCallback iIdentifierCallback, List<String> list) {
        g().a(iIdentifierCallback, list);
    }

    public void a(Map<String, Object> map) {
        this.d.a(map);
    }

    static T0 a(R2 r2) {
        return r2.b.a(r2.a, r2.d);
    }
}
