package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C1178pi;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.r1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1208r1 implements InterfaceC1161p1 {
    private final C0888e2 A;
    private C1178pi a;
    private boolean b;
    private final Context c;
    private volatile MetricaService.d d;
    private final Eh e;
    private X0 f;
    private final B0 g;
    private C1014j4 h;
    private final A1 i;
    private Vc j;
    private C0895e9 k;
    private L1 l;
    private final E0 m;
    private final C1409za n;
    private final C1063l3 o;
    private Y6 p;
    private final InterfaceC1141o6 q;
    private final B7 r;
    private final C1326w s;
    private final ICommonExecutor t;
    private final C1376y1 u;
    private InterfaceC1107mm<String> v;
    private InterfaceC1107mm<File> w;
    private InterfaceC0893e7<String> x;
    private ICommonExecutor y;
    private M1 z;

    /* renamed from: com.yandex.metrica.impl.ob.r1$a */
    class a implements InterfaceC1107mm<File> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(File file) {
            C1208r1.this.a(file);
        }
    }

    public C1208r1(Context context, MetricaService.d dVar) {
        this(context, dVar, new C1164p4(context));
    }

    static void d(C1208r1 c1208r1) {
        if (c1208r1.a != null) {
            F0.g().o().a(c1208r1.a);
        }
    }

    static void f(C1208r1 c1208r1) {
        c1208r1.e.b();
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void onConfigurationChanged(Configuration configuration) {
        C0937g1.a(this.c).b(configuration);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void reportData(Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        this.f.a();
        this.l.a(C0836c0.a(bundle), bundle);
    }

    private C1208r1(Context context, MetricaService.d dVar, C1164p4 c1164p4) {
        this(context, dVar, new C1014j4(context, c1164p4), new A1(), new B0(), new E0(), new C1409za(context), C1063l3.a(), new Eh(context), F0.g().b(), F0.g().h().c(), B7.a(), F0.g().q().e(), F0.g().q().a(), new C1376y1(), F0.g().n());
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a() {
        if (this.b) {
            C0937g1.a(this.c).b(this.c.getResources().getConfiguration());
        } else {
            this.k = F0.g().s();
            this.m.a(this.c);
            F0.g().x();
            C0933fm.c().d();
            this.j = new Vc(C1315vc.a(this.c), H2.a(this.c), this.k);
            this.a = new C1178pi.b(this.c).a();
            F0.g().t().getClass();
            this.i.b(new C1304v1(this));
            this.i.c(new C1328w1(this));
            this.i.a(new C1352x1(this));
            this.o.a(this, C1187q3.class, C1163p3.a(new C1256t1(this)).a(new C1232s1(this)).a());
            F0.g().r().a(this.c, this.a);
            this.f = new X0(this.k, this.a.t(), new SystemTimeProvider(), new C1353x2(), C1152oh.a());
            C1178pi c1178pi = this.a;
            if (c1178pi != null) {
                this.e.b(c1178pi);
            }
            a(this.a);
            C1376y1 c1376y1 = this.u;
            Context context = this.c;
            C1014j4 c1014j4 = this.h;
            c1376y1.getClass();
            this.l = new L1(context, c1014j4, F0.g().q().e(), new B0());
            YandexMetrica.getReporter(this.c, "20799a27-fa80-4b36-b2db-0f8141f24180");
            File fileA = this.g.a(this.c, "appmetrica_crashes");
            if (fileA != null) {
                C1376y1 c1376y12 = this.u;
                InterfaceC1107mm<File> interfaceC1107mm = this.w;
                c1376y12.getClass();
                this.p = new Y6(fileA, interfaceC1107mm);
                this.t.execute(new RunnableC1285u6(this.c, fileA, this.w));
                this.p.a();
            }
            if (A2.a(21)) {
                C1376y1 c1376y13 = this.u;
                L1 l1 = this.l;
                c1376y13.getClass();
                this.x = new C1262t7(new C1310v7(l1));
                this.v = new C1280u1(this);
                if (this.r.b()) {
                    this.x.a();
                    this.y.executeDelayed(new F7(), 1L, TimeUnit.MINUTES);
                }
            }
            F0.g().f().a(this.a);
            this.b = true;
        }
        if (A2.a(21)) {
            this.q.a(this.v);
        }
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void b(Intent intent) throws NumberFormatException {
        this.i.b(intent);
        if (intent != null) {
            String action = intent.getAction();
            Uri data = intent.getData();
            String encodedAuthority = data == null ? null : data.getEncodedAuthority();
            if ("com.yandex.metrica.IMetricaService".equals(action) && data != null && data.getPath().equals("/client")) {
                int i = Integer.parseInt(data.getQueryParameter("pid"));
                this.h.a(encodedAuthority, i, data.getQueryParameter("psid"));
                this.s.a(i);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void c(Intent intent) {
        this.i.c(intent);
    }

    private Integer c(Bundle bundle) {
        A3 a3;
        bundle.setClassLoader(A3.class.getClassLoader());
        String str = A3.c;
        try {
            a3 = (A3) bundle.getParcelable("PROCESS_CFG_OBJ");
        } catch (Throwable unused) {
            a3 = null;
        }
        if (a3 == null) {
            return null;
        }
        return a3.g();
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void b() {
        if (A2.a(21)) {
            this.q.b(this.v);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void b(Bundle bundle) {
        Integer numC = c(bundle);
        if (numC != null) {
            this.s.c(numC.intValue());
        }
    }

    C1208r1(Context context, MetricaService.d dVar, C1014j4 c1014j4, A1 a1, B0 b0, E0 e0, C1409za c1409za, C1063l3 c1063l3, Eh eh, C1326w c1326w, InterfaceC1141o6 interfaceC1141o6, B7 b7, ICommonExecutor iCommonExecutor, ICommonExecutor iCommonExecutor2, C1376y1 c1376y1, C0888e2 c0888e2) {
        this.b = false;
        this.w = new a();
        this.c = context;
        this.d = dVar;
        this.h = c1014j4;
        this.i = a1;
        this.g = b0;
        this.m = e0;
        this.n = c1409za;
        this.o = c1063l3;
        this.e = eh;
        this.s = c1326w;
        this.t = iCommonExecutor;
        this.y = iCommonExecutor2;
        this.u = c1376y1;
        this.q = interfaceC1141o6;
        this.r = b7;
        this.z = new M1(this, context);
        this.A = c0888e2;
    }

    private void b(Intent intent, int i) {
        if (intent != null) {
            intent.getExtras().setClassLoader(CounterConfiguration.class.getClassLoader());
            if (intent.getData() != null) {
                Bundle extras = intent.getExtras();
                C1402z3 c1402z3 = new C1402z3(extras);
                if (!C1402z3.a(c1402z3, this.c)) {
                    C0836c0 c0836c0A = C0836c0.a(extras);
                    if (!((c0836c0A.a == null) | (EnumC0787a1.EVENT_TYPE_UNDEFINED.b() == c0836c0A.e))) {
                        try {
                            this.l.a(C0990i4.a(c1402z3), c0836c0A, new D3(c1402z3));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        this.d.a(i);
    }

    static void b(C1208r1 c1208r1, C1178pi c1178pi) {
        Vc vc = c1208r1.j;
        if (vc != null) {
            vc.a(c1178pi);
        }
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent, int i) {
        b(intent, i);
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent, int i, int i2) {
        b(intent, i2);
    }

    @Override // com.yandex.metrica.impl.ob.B1
    public void a(Intent intent) {
        this.i.a(intent);
    }

    static void a(C1208r1 c1208r1, C1178pi c1178pi) {
        c1208r1.a = c1178pi;
        Vc vc = c1208r1.j;
        if (vc != null) {
            vc.a(c1178pi);
        }
        c1208r1.f.a(c1208r1.a.t());
        c1208r1.n.a(c1178pi);
        c1208r1.e.b(c1178pi);
    }

    static void a(C1208r1 c1208r1, Intent intent) {
        c1208r1.e.a();
        c1208r1.A.a(Tl.f(intent.getStringExtra("screen_size")));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    @Deprecated
    public void a(String str, int i, String str2, Bundle bundle) {
        bundle.setClassLoader(CounterConfiguration.class.getClassLoader());
        this.l.a(new C0836c0(str2, str, i), bundle);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(int i, Bundle bundle) {
        this.z.a(i, bundle);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(Bundle bundle) {
        Integer numC = c(bundle);
        if (numC != null) {
            this.s.b(numC.intValue());
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1161p1
    public void a(MetricaService.d dVar) {
        this.d = dVar;
    }

    public void a(File file) {
        this.l.a(file);
    }

    private void a(C1178pi c1178pi) {
        Vc vc = this.j;
        if (vc != null) {
            vc.a(c1178pi);
        }
    }
}
