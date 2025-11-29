package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;
import com.yandex.metrica.impl.ob.C1362xb;
import com.yandex.metrica.impl.ob.Z0;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public class P2 implements S0 {
    private final Context a;
    private final Handler b;
    private final Q c;
    private final C1362xb d;
    private final ICommonExecutor e;
    private final C1278u f;
    private volatile C1 g;
    private AbstractC1381y6 h;
    private final com.yandex.metrica.rtm.wrapper.e i;
    private final C0962h1 j;
    private boolean k;

    P2(Context context, Im im) {
        this(context.getApplicationContext(), im.b(), im.a());
    }

    private void e() {
        if (!Z0.a("com.yandex.metrica.CounterConfiguration")) {
            throw new Z0.a("\nClass com.yandex.metrica.CounterConfiguration isn't found.\nPerhaps this is due to obfuscation.\nIf you build your application with ProGuard,\nyou need to keep the Metrica for Apps.\nPlease try to use the following lines of code:\n##########################################\n-keep class com.yandex.metrica.** { *; }\n-dontwarn com.yandex.metrica.**\n##########################################");
        }
        this.e.execute(new Yl(this.a));
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public synchronized void a(com.yandex.metrica.i iVar, O0 o0) {
        try {
            if (!this.k) {
                Boolean bool = iVar.crashReporting;
                Boolean bool2 = Boolean.TRUE;
                if (bool == null) {
                    bool = bool2;
                }
                if (bool.booleanValue() && this.g == null) {
                    Xg xg = new Xg(this.i);
                    C6 c6 = new C6(this.a, new C1377y2(o0, "20799a27-fa80-4b36-b2db-0f8141f24180"), new M2(this), (com.yandex.metrica.c) null);
                    C6 c62 = new C6(this.a, new C1377y2(o0, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"), new N2(this), (com.yandex.metrica.c) null);
                    if (this.h == null) {
                        this.h = new C6(this.a, new C0987i1(o0, iVar), new O2(this), (com.yandex.metrica.c) null);
                    }
                    this.g = new C1(Thread.getDefaultUncaughtExceptionHandler(), Arrays.asList(xg, c6, c62, this.h), P.g().j(), new C0989i3(), new C1038k3());
                    Thread.setDefaultUncaughtExceptionHandler(this.g);
                }
                Boolean bool3 = iVar.appOpenTrackingEnabled;
                if (bool3 != null) {
                    bool2 = bool3;
                }
                if (bool2.booleanValue()) {
                    this.f.a();
                }
                this.k = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public ICommonExecutor b() {
        return this.e;
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public Handler c() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public Eb d() {
        return this.d;
    }

    private P2(Context context, IHandlerExecutor iHandlerExecutor, ICommonExecutor iCommonExecutor) {
        this(context, new C1362xb(new C1362xb.c(), new C1362xb.e(), new C1362xb.e(), iHandlerExecutor, "Client"), iHandlerExecutor, new Q(), new C1278u(iCommonExecutor), new Zg(), new C0962h1());
    }

    P2(Context context, C1362xb c1362xb, IHandlerExecutor iHandlerExecutor, Q q, C1278u c1278u, Zg zg, C0962h1 c0962h1) {
        this.k = false;
        this.a = context;
        this.e = iHandlerExecutor;
        this.f = c1278u;
        this.j = c0962h1;
        Vl.a(context);
        C0963h2.b();
        this.d = c1362xb;
        c1362xb.c(context);
        this.b = iHandlerExecutor.getHandler();
        this.c = q;
        q.a();
        this.i = zg.a(context);
        e();
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public void a(Map<String, Object> map) {
        this.j.a(map);
    }

    @Override // com.yandex.metrica.impl.ob.S0
    public C1278u a() {
        return this.f;
    }
}
