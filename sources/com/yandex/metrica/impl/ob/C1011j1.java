package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.PreloadInfo;
import com.yandex.metrica.a;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C0785a;
import com.yandex.metrica.impl.ob.C1183q;
import com.yandex.metrica.impl.ob.r;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.j1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1011j1 extends B implements K0 {
    private static final Kn<String> y = new Hn(new Fn("Referral url"));
    private static final Long z = Long.valueOf(TimeUnit.SECONDS.toMillis(5));
    private final com.yandex.metrica.a p;
    private final com.yandex.metrica.i q;
    private final C0979hi r;
    private C0785a s;
    private final C1300ul t;
    private final r u;
    private final AtomicBoolean v;
    private final C1038k3 w;
    private final C1017j7 x;

    /* renamed from: com.yandex.metrica.impl.ob.j1$a */
    class a implements C0785a.b {
        final /* synthetic */ ICommonExecutor a;
        final /* synthetic */ C0887e1 b;
        final /* synthetic */ C1377y2 c;
        final /* synthetic */ C1377y2 d;

        /* renamed from: com.yandex.metrica.impl.ob.j1$a$a, reason: collision with other inner class name */
        class RunnableC0290a implements Runnable {
            final /* synthetic */ C1333w6 a;

            RunnableC0290a(C1333w6 c1333w6) {
                this.a = c1333w6;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1011j1.this.a(this.a);
                if (a.this.b.a(this.a.a.f)) {
                    a.this.c.a().a(this.a);
                }
                if (a.this.b.b(this.a.a.f)) {
                    a.this.d.a().a(this.a);
                }
            }
        }

        a(ICommonExecutor iCommonExecutor, C0887e1 c0887e1, C1377y2 c1377y2, C1377y2 c1377y22) {
            this.a = iCommonExecutor;
            this.b = c0887e1;
            this.c = c1377y2;
            this.d = c1377y22;
        }

        @Override // com.yandex.metrica.impl.ob.C0785a.b
        public void a() {
            this.a.execute(new RunnableC0290a(C1011j1.this.w.a()));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.j1$b */
    class b implements a.InterfaceC0279a {
        b() {
        }

        @Override // com.yandex.metrica.a.InterfaceC0279a
        public void a() {
            C1011j1 c1011j1 = C1011j1.this;
            c1011j1.i.a(c1011j1.b.a());
        }

        @Override // com.yandex.metrica.a.InterfaceC0279a
        public void b() {
            C1011j1 c1011j1 = C1011j1.this;
            c1011j1.i.b(c1011j1.b.a());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.j1$c */
    static class c {
        c() {
        }

        C1300ul a(Context context, ICommonExecutor iCommonExecutor, C0820b9 c0820b9, C1011j1 c1011j1, C0979hi c0979hi) {
            return new C1300ul(context, c0820b9, c1011j1, iCommonExecutor, c0979hi.d());
        }
    }

    C1011j1(Context context, A3 a3, com.yandex.metrica.i iVar, T1 t1, C1017j7 c1017j7, C0979hi c0979hi, C1377y2 c1377y2, C1377y2 c1377y22, C0820b9 c0820b9, P p, A0 a0) {
        this(context, iVar, t1, c1017j7, new Q1(a3, new CounterConfiguration(iVar, CounterConfiguration.b.MAIN), iVar.userProfileID), new com.yandex.metrica.a(iVar.sessionTimeout == null ? TimeUnit.SECONDS.toMillis(10L) : r0.intValue()), c0979hi, new C0887e1(), p.j(), c1377y2, c1377y22, c0820b9, p.c(), a0, new c(), new r(), new Zg(), new Yg(iVar.appVersion, iVar.a), new C1237s6(a0), new X6(), new S6(), new M6(), new K6(), p.k());
    }

    private void h() {
        this.i.a(this.b.a());
        this.p.a(new b(), z.longValue());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(boolean z2) {
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void b(Activity activity) {
        if (this.u.a(activity, r.a.PAUSED)) {
            d(activity != null ? activity.getClass().getSimpleName() : null);
            this.p.a();
            if (activity != null) {
                this.t.a(activity);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.B, com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void c(String str, String str2) {
        super.c(str, str2);
        this.x.a(this.b.c.a());
    }

    public final void g() {
        if (this.v.compareAndSet(false, true)) {
            this.s.c();
        }
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(String str, boolean z2) {
        if (this.c.isEnabled()) {
            this.c.i("App opened via deeplink: " + f(str));
        }
        this.i.a(C1399z0.a("open", str, z2, this.c), this.b);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void b(boolean z2) {
        this.b.b().b(z2);
    }

    @Override // com.yandex.metrica.impl.ob.El
    public void b(JSONObject jSONObject) {
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J(jSONObject.toString(), "view_tree", EnumC0787a1.EVENT_TYPE_VIEW_TREE.b(), 0, c0858cm), this.b);
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(String str) {
        ((Hn) y).a(str);
        this.i.a(C1399z0.a("referral", str, false, this.c), this.b);
        if (this.c.isEnabled()) {
            this.c.i("Referral URL received: " + f(str));
        }
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(C1183q.c cVar) {
        if (cVar == C1183q.c.WATCHING) {
            if (this.c.isEnabled()) {
                this.c.i("Enable activity auto tracking");
            }
        } else if (this.c.isEnabled()) {
            this.c.w("Could not enable activity auto tracking. " + cVar.a);
        }
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(Activity activity) {
        if (this.u.a(activity, r.a.RESUMED)) {
            e(activity != null ? activity.getClass().getSimpleName() : null);
            this.p.b();
            if (activity != null) {
                this.t.b(activity);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1111n1
    public void a(Location location) {
        this.b.b().a(location);
        if (this.c.isEnabled()) {
            this.c.fi("Set location: %s", location);
        }
    }

    C1011j1(Context context, com.yandex.metrica.i iVar, T1 t1, C1017j7 c1017j7, Q1 q1, com.yandex.metrica.a aVar, C0979hi c0979hi, C0887e1 c0887e1, InterfaceC0833bm interfaceC0833bm, C1377y2 c1377y2, C1377y2 c1377y22, C0820b9 c0820b9, ICommonExecutor iCommonExecutor, A0 a0, c cVar, r rVar, Zg zg, Yg yg, C1237s6 c1237s6, X6 x6, S6 s6, M6 m6, K6 k6, C1415zg c1415zg) {
        super(context, t1, q1, a0, interfaceC0833bm, zg.a(t1.b(), iVar.apiKey, true), yg, x6, s6, m6, k6, c1237s6);
        this.v = new AtomicBoolean(false);
        this.w = new C1038k3();
        this.b.a(a(iVar));
        this.p = aVar;
        this.x = c1017j7;
        this.q = iVar;
        this.u = rVar;
        C1300ul c1300ulA = cVar.a(context, iCommonExecutor, c0820b9, this, c0979hi);
        this.t = c1300ulA;
        this.r = c0979hi;
        c0979hi.a(c1300ulA);
        a(iVar.nativeCrashReporting, this.b);
        context.getApplicationContext();
        c0979hi.b();
        Bg bg = Bg.b;
        this.s = a(iCommonExecutor, c0887e1, c1377y2, c1377y22);
        if (C0810b.a(iVar.k)) {
            g();
        }
        h();
    }

    private C0785a a(ICommonExecutor iCommonExecutor, C0887e1 c0887e1, C1377y2 c1377y2, C1377y2 c1377y22) {
        return new C0785a(new a(iCommonExecutor, c0887e1, c1377y2, c1377y22));
    }

    @Override // com.yandex.metrica.impl.ob.El
    public void a(JSONObject jSONObject) {
        T1 t1 = this.i;
        C0858cm c0858cm = this.c;
        List<Integer> list = C1399z0.i;
        t1.a(new J(jSONObject.toString(), "view_tree", EnumC0787a1.EVENT_TYPE_RAW_VIEW_TREE.b(), 0, c0858cm), this.b);
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(InterfaceC1081ll interfaceC1081ll, boolean z2) {
        this.t.a(interfaceC1081ll, z2);
    }

    @Override // com.yandex.metrica.impl.ob.K0
    public void a(D2 d2) {
        d2.a(this.c);
    }

    private void a(Boolean bool, Q1 q1) {
        Boolean bool2 = Boolean.TRUE;
        if (bool == null) {
            bool = bool2;
        }
        this.x.a(bool.booleanValue(), q1.b().a(), q1.c.a());
        if (this.c.isEnabled()) {
            this.c.fi("Set report native crashes enabled: %b", bool);
        }
    }

    private C1000ie a(com.yandex.metrica.i iVar) {
        PreloadInfo preloadInfo = iVar.preloadInfo;
        C0858cm c0858cm = this.c;
        Boolean bool = iVar.i;
        Boolean bool2 = Boolean.FALSE;
        if (bool == null) {
            bool = bool2;
        }
        return new C1000ie(preloadInfo, c0858cm, bool.booleanValue());
    }
}
