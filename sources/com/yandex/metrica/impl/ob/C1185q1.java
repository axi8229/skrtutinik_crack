package com.yandex.metrica.impl.ob;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* renamed from: com.yandex.metrica.impl.ob.q1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1185q1 implements InterfaceC1161p1 {
    private ICommonExecutor a;
    private InterfaceC1161p1 b;
    private final C0912f1 c;
    private boolean d;

    /* renamed from: com.yandex.metrica.impl.ob.q1$a */
    class a extends AbstractRunnableC0908em {
        final /* synthetic */ Bundle a;

        a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            C1185q1.this.b.b(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$b */
    class b extends AbstractRunnableC0908em {
        final /* synthetic */ Bundle a;

        b(Bundle bundle) {
            this.a = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            C1185q1.this.b.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$c */
    class c extends AbstractRunnableC0908em {
        final /* synthetic */ Configuration a;

        c(Configuration configuration) {
            this.a = configuration;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            C1185q1.this.b.onConfigurationChanged(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$d */
    class d extends AbstractRunnableC0908em {
        d() {
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            synchronized (C1185q1.this) {
                try {
                    if (C1185q1.this.d) {
                        C1185q1.this.c.e();
                        C1185q1.this.b.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$e */
    class e extends AbstractRunnableC0908em {
        final /* synthetic */ Intent a;
        final /* synthetic */ int b;

        e(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            C1185q1.this.b.a(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$f */
    class f extends AbstractRunnableC0908em {
        final /* synthetic */ Intent a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        f(Intent intent, int i, int i2) {
            this.a = intent;
            this.b = i;
            this.c = i2;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            C1185q1.this.b.a(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$g */
    class g extends AbstractRunnableC0908em {
        final /* synthetic */ Intent a;

        g(Intent intent) {
            this.a = intent;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            C1185q1.this.b.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$h */
    class h extends AbstractRunnableC0908em {
        final /* synthetic */ Intent a;

        h(Intent intent) {
            this.a = intent;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            C1185q1.this.b.c(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$i */
    class i extends AbstractRunnableC0908em {
        final /* synthetic */ Intent a;

        i(Intent intent) {
            this.a = intent;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() {
            C1185q1.this.b.b(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$j */
    class j extends AbstractRunnableC0908em {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ Bundle d;

        j(String str, int i, String str2, Bundle bundle) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws RemoteException {
            C1185q1.this.b.a(this.a, this.b, this.c, this.d);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$k */
    class k extends AbstractRunnableC0908em {
        final /* synthetic */ Bundle a;

        k(Bundle bundle) {
            this.a = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            C1185q1.this.b.reportData(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q1$l */
    class l extends AbstractRunnableC0908em {
        final /* synthetic */ int a;
        final /* synthetic */ Bundle b;

        l(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            C1185q1.this.b.a(this.a, this.b);
        }
    }

    public C1185q1(InterfaceC1161p1 interfaceC1161p1) {
        this(F0.g().q().c(), interfaceC1161p1, F0.g().h());
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void onConfigurationChanged(Configuration configuration) {
        this.a.execute(new c(configuration));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void reportData(Bundle bundle) {
        this.a.execute(new k(bundle));
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public synchronized void a() {
        this.d = true;
        this.a.execute(new d());
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void b(Intent intent) {
        this.a.execute(new i(intent));
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void c(Intent intent) {
        this.a.execute(new h(intent));
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void b() {
        this.a.removeAll();
        synchronized (this) {
            this.c.f();
            this.d = false;
        }
        this.b.b();
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent, int i2) {
        this.a.execute(new e(intent, i2));
    }

    C1185q1(ICommonExecutor iCommonExecutor, InterfaceC1161p1 interfaceC1161p1, C0912f1 c0912f1) {
        this.d = false;
        this.a = iCommonExecutor;
        this.b = interfaceC1161p1;
        this.c = c0912f1;
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent, int i2, int i3) {
        this.a.execute(new f(intent, i2, i3));
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent) {
        this.a.execute(new g(intent));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(String str, int i2, String str2, Bundle bundle) {
        this.a.execute(new j(str, i2, str2, bundle));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(int i2, Bundle bundle) {
        this.a.execute(new l(i2, bundle));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(Bundle bundle) {
        this.a.execute(new b(bundle));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(MetricaService.d dVar) {
        this.b.a(dVar);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void b(Bundle bundle) {
        this.a.execute(new a(bundle));
    }
}
