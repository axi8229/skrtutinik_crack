package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.webkit.WebView;
import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.impl.ob.C1183q;
import com.yandex.metrica.profile.UserProfile;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Uf extends Lf {
    private final Qf i;
    private final Xf j;
    private final Wf k;
    private final C1137o2 l;

    class A implements Runnable {
        final /* synthetic */ Activity a;

        A(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.this.l.a(this.a, Uf.a(Uf.this));
        }
    }

    class B implements Runnable {
        final /* synthetic */ C1183q.c a;

        B(C1183q.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).a(this.a);
        }
    }

    class C implements Runnable {
        final /* synthetic */ String a;

        C(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportEvent(this.a);
        }
    }

    class D implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        D(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportEvent(this.a, this.b);
        }
    }

    class E implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ List b;

        E(String str, List list) {
            this.a = str;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportEvent(this.a, A2.a(this.b));
        }
    }

    class F implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Throwable b;

        F(String str, Throwable th) {
            this.a = str;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportError(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$a, reason: case insensitive filesystem */
    class RunnableC0779a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Throwable c;

        RunnableC0779a(String str, String str2, Throwable th) {
            this.a = str;
            this.b = str2;
            this.c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportError(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$b, reason: case insensitive filesystem */
    class RunnableC0780b implements Runnable {
        final /* synthetic */ Throwable a;

        RunnableC0780b(Throwable th) {
            this.a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportUnhandledException(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$c, reason: case insensitive filesystem */
    class RunnableC0781c implements Runnable {
        final /* synthetic */ String a;

        RunnableC0781c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).c(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$d, reason: case insensitive filesystem */
    class RunnableC0782d implements Runnable {
        final /* synthetic */ Intent a;

        RunnableC0782d(Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.c(Uf.this).a().a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$e, reason: case insensitive filesystem */
    class RunnableC0783e implements Runnable {
        final /* synthetic */ String a;

        RunnableC0783e(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.c(Uf.this).a().a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.Uf$f, reason: case insensitive filesystem */
    class RunnableC0784f implements Runnable {
        final /* synthetic */ Intent a;

        RunnableC0784f(Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.c(Uf.this).a().a(this.a);
        }
    }

    class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).a(this.a);
        }
    }

    class h implements Runnable {
        final /* synthetic */ Location a;

        h(Location location) {
            this.a = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            Location location = this.a;
            sfE.getClass();
            R2.a(location);
        }
    }

    class i implements Runnable {
        final /* synthetic */ boolean a;

        i(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            boolean z = this.a;
            sfE.getClass();
            R2.a(z);
        }
    }

    class j implements Runnable {
        final /* synthetic */ boolean a;

        j(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            boolean z = this.a;
            sfE.getClass();
            R2.a(z);
        }
    }

    class k implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ YandexMetricaConfig b;
        final /* synthetic */ com.yandex.metrica.i c;

        k(Context context, YandexMetricaConfig yandexMetricaConfig, com.yandex.metrica.i iVar) {
            this.a = context;
            this.b = yandexMetricaConfig;
            this.c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            Context context = this.a;
            sfE.getClass();
            R2.a(context).b(this.b, Uf.this.c().a(this.c));
        }
    }

    class l implements Runnable {
        final /* synthetic */ boolean a;

        l(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            boolean z = this.a;
            sfE.getClass();
            R2.c(z);
        }
    }

    class m implements Runnable {
        final /* synthetic */ String a;

        m(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            String str = this.a;
            sfE.getClass();
            R2.a(str);
        }
    }

    class n implements Runnable {
        final /* synthetic */ UserProfile a;

        n(UserProfile userProfile) {
            this.a = userProfile;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportUserProfile(this.a);
        }
    }

    class o implements Runnable {
        final /* synthetic */ Revenue a;

        o(Revenue revenue) {
            this.a = revenue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportRevenue(this.a);
        }
    }

    class p implements Runnable {
        final /* synthetic */ AdRevenue a;

        p(AdRevenue adRevenue) {
            this.a = adRevenue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportAdRevenue(this.a);
        }
    }

    class q implements Runnable {
        final /* synthetic */ ECommerceEvent a;

        q(ECommerceEvent eCommerceEvent) {
            this.a = eCommerceEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).reportECommerce(this.a);
        }
    }

    class r implements Runnable {
        final /* synthetic */ DeferredDeeplinkParametersListener a;

        r(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
            this.a = deferredDeeplinkParametersListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.this.e().getClass();
            R2.k().a(this.a);
        }
    }

    class s implements Runnable {
        final /* synthetic */ DeferredDeeplinkListener a;

        s(DeferredDeeplinkListener deferredDeeplinkListener) {
            this.a = deferredDeeplinkListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.this.e().getClass();
            R2.k().a(this.a);
        }
    }

    class t implements Runnable {
        final /* synthetic */ AppMetricaDeviceIDListener a;

        t(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
            this.a = appMetricaDeviceIDListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.this.e().getClass();
            R2.k().b(this.a);
        }
    }

    class u implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        u(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sf sfE = Uf.this.e();
            String str = this.a;
            String str2 = this.b;
            sfE.getClass();
            R2.a(str, str2);
        }
    }

    class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).sendEventsBuffer();
        }
    }

    class w implements Runnable {
        w() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).a(Uf.this.h());
        }
    }

    class x implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        x(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).a(this.a, this.b);
        }
    }

    class y implements Runnable {
        final /* synthetic */ String a;

        y(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.a(Uf.this).b(this.a);
        }
    }

    class z implements Runnable {
        final /* synthetic */ Activity a;

        z(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uf.this.l.b(this.a, Uf.a(Uf.this));
        }
    }

    public Uf(ICommonExecutor iCommonExecutor) {
        this(new Sf(), iCommonExecutor, new Xf(), new Wf(), new D2());
    }

    public void a(Context context, YandexMetricaConfig yandexMetricaConfig) {
        this.j.a(context, yandexMetricaConfig);
        com.yandex.metrica.i iVarA = this.k.a(yandexMetricaConfig instanceof com.yandex.metrica.i ? (com.yandex.metrica.i) yandexMetricaConfig : new com.yandex.metrica.i(yandexMetricaConfig));
        g().a(context, iVarA);
        d().execute(new k(context, yandexMetricaConfig, iVarA));
        e().getClass();
        R2.j();
    }

    public void c(Activity activity) {
        a().a(null);
        this.j.getClass();
        g().getClass();
        d().execute(new z(activity));
    }

    public void d(String str) {
        a().a(null);
        this.j.c(str);
        g().getClass();
        d().execute(new RunnableC0781c(str));
    }

    public void e(String str) {
        a().a(null);
        this.j.a(str);
        d().execute(new g(str));
    }

    public void f(String str) {
        this.j.getClass();
        g().getClass();
        d().execute(new m(str));
    }

    public void i() {
        a().a(null);
        this.j.getClass();
        g().getClass();
        d().execute(new v());
    }

    private Uf(Sf sf, ICommonExecutor iCommonExecutor, Xf xf, Wf wf, D2 d2) {
        this(sf, iCommonExecutor, xf, wf, new Kf(sf), new Qf(sf), d2, new com.yandex.metrica.f(sf, d2), Pf.a(), P.g().f(), P.g().l(), P.g().e());
    }

    public void b(String str) {
        a().a(null);
        this.j.reportEvent(str);
        g().getClass();
        d().execute(new C(str));
    }

    public void b(String str, String str2) {
        a().a(null);
        this.j.reportEvent(str, str2);
        g().getClass();
        d().execute(new D(str, str2));
    }

    public void c(String str, String str2) {
        a().a(null);
        if (!this.j.f(str)) {
            Log.w("AppMetrica", "Impossible to report event because parameters are invalid.");
        } else {
            g().getClass();
            d().execute(new x(str, str2));
        }
    }

    public void b(Activity activity) {
        Intent intent = null;
        a().a(null);
        this.j.c(activity);
        g().getClass();
        if (activity != null) {
            try {
                intent = activity.getIntent();
            } catch (Throwable unused) {
            }
        }
        d().execute(new RunnableC0782d(intent));
    }

    Uf(Sf sf, ICommonExecutor iCommonExecutor, Xf xf, Wf wf, Kf kf, Qf qf, D2 d2, com.yandex.metrica.f fVar, Pf pf, C1060l0 c1060l0, C1137o2 c1137o2, C0786a0 c0786a0) {
        super(sf, iCommonExecutor, kf, d2, fVar, pf, c1060l0, c0786a0);
        this.k = wf;
        this.j = xf;
        this.i = qf;
        this.l = c1137o2;
    }

    public void c(String str) {
        if (this.i.a().b() && this.j.g(str)) {
            g().getClass();
            d().execute(new y(str));
        }
    }

    public void b(Context context, boolean z2) {
        this.j.b(context);
        g().c(context);
        d().execute(new l(z2));
    }

    static C1036k1 c(Uf uf) {
        uf.e().getClass();
        return R2.k().d();
    }

    public void a(Activity activity) {
        a().a(null);
        this.j.getClass();
        g().getClass();
        d().execute(new A(activity));
    }

    public void a(Application application) {
        a().a(null);
        this.j.a(application);
        d().execute(new B(g().a(application)));
    }

    public void a(String str, Map<String, Object> map) {
        a().a(null);
        this.j.reportEvent(str, map);
        g().getClass();
        d().execute(new E(str, A2.a((Map) map)));
    }

    public void a(String str, Throwable th) {
        a().a(null);
        this.j.reportError(str, th);
        g().getClass();
        if (th == null) {
            th = new C1041k6();
            th.fillInStackTrace();
        }
        d().execute(new F(str, th));
    }

    public void a(String str, String str2, Throwable th) {
        a().a(null);
        this.j.reportError(str, str2, th);
        d().execute(new RunnableC0779a(str, str2, th));
    }

    public void a(Throwable th) {
        a().a(null);
        this.j.reportUnhandledException(th);
        g().getClass();
        d().execute(new RunnableC0780b(th));
    }

    public void a(String str) {
        a().a(null);
        this.j.e(str);
        g().getClass();
        d().execute(new RunnableC0783e(str));
    }

    public void a(Intent intent) {
        a().a(null);
        this.j.a(intent);
        g().getClass();
        d().execute(new RunnableC0784f(intent));
    }

    public void a(Location location) {
        this.j.getClass();
        g().getClass();
        d().execute(new h(location));
    }

    public void a(boolean z2) {
        this.j.getClass();
        g().getClass();
        d().execute(new i(z2));
    }

    public void a(Context context, boolean z2) {
        this.j.a(context);
        g().b(context);
        d().execute(new j(z2));
    }

    public void a(UserProfile userProfile) {
        a().a(null);
        this.j.reportUserProfile(userProfile);
        g().getClass();
        d().execute(new n(userProfile));
    }

    public void a(Revenue revenue) {
        a().a(null);
        this.j.reportRevenue(revenue);
        g().getClass();
        d().execute(new o(revenue));
    }

    public void a(AdRevenue adRevenue) {
        a().a(null);
        this.j.reportAdRevenue(adRevenue);
        g().getClass();
        d().execute(new p(adRevenue));
    }

    public void a(ECommerceEvent eCommerceEvent) {
        a().a(null);
        this.j.reportECommerce(eCommerceEvent);
        g().getClass();
        d().execute(new q(eCommerceEvent));
    }

    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        a().a(null);
        this.j.a(deferredDeeplinkParametersListener);
        g().getClass();
        d().execute(new r(deferredDeeplinkParametersListener));
    }

    public void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        a().a(null);
        this.j.a(deferredDeeplinkListener);
        g().getClass();
        d().execute(new s(deferredDeeplinkListener));
    }

    public void a(AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        a().a(null);
        this.j.a(appMetricaDeviceIDListener);
        g().getClass();
        d().execute(new t(appMetricaDeviceIDListener));
    }

    public IReporter a(Context context, String str) {
        this.j.a(context, str);
        b().a(context);
        return f().a(context, str);
    }

    public void a(Context context, ReporterConfig reporterConfig) {
        this.j.a(context, reporterConfig);
        com.yandex.metrica.e eVarA = com.yandex.metrica.e.a(reporterConfig);
        g().a(context);
        f().a(context, eVarA);
    }

    public void a(String str, String str2) {
        this.j.d(str);
        g().getClass();
        d().execute(new u(str, str2));
    }

    public void a(WebView webView) {
        a().a(null);
        this.j.a(webView);
        g().a(webView, this);
        d().execute(new w());
    }

    static K0 a(Uf uf) {
        uf.e().getClass();
        return R2.k().d().b();
    }
}
