package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.ValidationException;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.e;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.profile.UserProfile;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Of implements M0 {
    private final Sf a;
    private final C0802ag b;
    private final ICommonExecutor c;
    private final Context d;
    private final Wf e;
    private final com.yandex.metrica.e f;
    private final com.yandex.metrica.f g;
    private final Nf h;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().b(this.a, this.b);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().d(this.a, this.b);
        }
    }

    class c implements InterfaceC1206qm<M0> {
        final /* synthetic */ Sf a;
        final /* synthetic */ Context b;
        final /* synthetic */ com.yandex.metrica.e c;

        c(Sf sf, Context context, com.yandex.metrica.e eVar) {
            this.a = sf;
            this.b = context;
            this.c = eVar;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1206qm
        public M0 a() {
            Sf sf = this.a;
            Context context = this.b;
            com.yandex.metrica.e eVar = this.c;
            sf.getClass();
            return R2.a(context).a(eVar);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportEvent(this.a);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportEvent(this.a, this.b);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ List b;

        f(String str, List list) {
            this.a = str;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportEvent(this.a, A2.a(this.b));
        }
    }

    class g implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Throwable b;

        g(String str, Throwable th) {
            this.a = str;
            this.b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportError(this.a, this.b);
        }
    }

    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Throwable c;

        h(String str, String str2, Throwable th) {
            this.a = str;
            this.b = str2;
            this.c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportError(this.a, this.b, this.c);
        }
    }

    class i implements Runnable {
        final /* synthetic */ Throwable a;

        i(Throwable th) {
            this.a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportUnhandledException(this.a);
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().resumeSession();
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().pauseSession();
        }
    }

    class l implements Runnable {
        final /* synthetic */ String a;

        l(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().setUserProfileID(this.a);
        }
    }

    class m implements Runnable {
        final /* synthetic */ H6 a;

        m(H6 h6) {
            this.a = h6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().a(this.a);
        }
    }

    class n implements Runnable {
        final /* synthetic */ UserProfile a;

        n(UserProfile userProfile) {
            this.a = userProfile;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportUserProfile(this.a);
        }
    }

    class o implements Runnable {
        final /* synthetic */ Revenue a;

        o(Revenue revenue) {
            this.a = revenue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportRevenue(this.a);
        }
    }

    class p implements Runnable {
        final /* synthetic */ AdRevenue a;

        p(AdRevenue adRevenue) {
            this.a = adRevenue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportAdRevenue(this.a);
        }
    }

    class q implements Runnable {
        final /* synthetic */ ECommerceEvent a;

        q(ECommerceEvent eCommerceEvent) {
            this.a = eCommerceEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().reportECommerce(this.a);
        }
    }

    class r implements Runnable {
        final /* synthetic */ boolean a;

        r(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().setStatisticsSending(this.a);
        }
    }

    class s implements Runnable {
        final /* synthetic */ com.yandex.metrica.e a;

        s(com.yandex.metrica.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.a(Of.this, this.a);
        }
    }

    class t implements Runnable {
        final /* synthetic */ com.yandex.metrica.e a;

        t(com.yandex.metrica.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.a(Of.this, this.a);
        }
    }

    class u implements Runnable {
        final /* synthetic */ C1333w6 a;

        u(C1333w6 c1333w6) {
            this.a = c1333w6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().a(this.a);
        }
    }

    class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().b();
        }
    }

    class w implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;

        w(String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().a(this.a, this.b);
        }
    }

    class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Of.this.a().sendEventsBuffer();
        }
    }

    public Of(ICommonExecutor iCommonExecutor, Context context, String str) {
        this(iCommonExecutor, context.getApplicationContext(), str, new Sf());
    }

    final M0 a() {
        Sf sf = this.a;
        Context context = this.d;
        com.yandex.metrica.e eVar = this.f;
        sf.getClass();
        return R2.a(context).a(eVar);
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void b() {
        this.g.getClass();
        this.c.execute(new v());
    }

    public void d(String str) {
        com.yandex.metrica.e eVarA = new e.a(str).a();
        this.g.getClass();
        this.c.execute(new s(eVarA));
    }

    @Override // com.yandex.metrica.IReporter
    public IPluginReporter getPluginExtension() {
        return this.h;
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new k());
    }

    @Override // com.yandex.metrica.IReporter
    public void reportAdRevenue(AdRevenue adRevenue) {
        this.b.reportAdRevenue(adRevenue);
        this.g.getClass();
        this.c.execute(new p(adRevenue));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportECommerce(ECommerceEvent eCommerceEvent) {
        this.b.reportECommerce(eCommerceEvent);
        this.g.getClass();
        this.c.execute(new q(eCommerceEvent));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) throws ValidationException {
        this.b.reportError(str, th);
        this.g.getClass();
        if (th == null) {
            th = new C1041k6();
            th.fillInStackTrace();
        }
        this.c.execute(new g(str, th));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str) throws ValidationException {
        this.b.reportEvent(str);
        this.g.getClass();
        this.c.execute(new d(str));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(Revenue revenue) throws ValidationException {
        this.b.reportRevenue(revenue);
        this.g.getClass();
        this.c.execute(new o(revenue));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable th) throws ValidationException {
        this.b.reportUnhandledException(th);
        this.g.getClass();
        this.c.execute(new i(th));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(UserProfile userProfile) throws ValidationException {
        this.b.reportUserProfile(userProfile);
        this.g.getClass();
        this.c.execute(new n(userProfile));
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new j());
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new x());
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new r(z));
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(String str) {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new l(str));
    }

    private Of(ICommonExecutor iCommonExecutor, Context context, String str, Sf sf) {
        this(iCommonExecutor, context, new C0802ag(), sf, new Wf(), new com.yandex.metrica.f(sf, new D2()), com.yandex.metrica.e.a(str).a());
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void b(String str, String str2) {
        this.b.getClass();
        this.g.getClass();
        this.c.execute(new a(str, str2));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, String str2) throws ValidationException {
        this.b.reportEvent(str, str2);
        this.g.getClass();
        this.c.execute(new e(str, str2));
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void d(String str, String str2) throws ValidationException {
        this.b.d(str, str2);
        this.g.getClass();
        this.c.execute(new b(str, str2));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, Map<String, Object> map) throws ValidationException {
        this.b.reportEvent(str, map);
        this.g.getClass();
        this.c.execute(new f(str, A2.a((Map) map)));
    }

    private Of(ICommonExecutor iCommonExecutor, Context context, C0802ag c0802ag, Sf sf, Wf wf, com.yandex.metrica.f fVar, com.yandex.metrica.e eVar) {
        this(iCommonExecutor, context, c0802ag, sf, wf, fVar, eVar, new Nf(c0802ag.a(), fVar, iCommonExecutor, new c(sf, context, eVar)));
    }

    Of(ICommonExecutor iCommonExecutor, Context context, C0802ag c0802ag, Sf sf, Wf wf, com.yandex.metrica.f fVar, com.yandex.metrica.e eVar, Nf nf) {
        this.c = iCommonExecutor;
        this.d = context;
        this.b = c0802ag;
        this.a = sf;
        this.e = wf;
        this.g = fVar;
        this.f = eVar;
        this.h = nf;
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(H6 h6) {
        this.g.getClass();
        this.c.execute(new m(h6));
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(C1333w6 c1333w6) {
        this.g.getClass();
        this.c.execute(new u(c1333w6));
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void a(String str, JSONObject jSONObject) {
        this.g.getClass();
        this.c.execute(new w(str, jSONObject));
    }

    public void a(com.yandex.metrica.e eVar) {
        com.yandex.metrica.e eVarA = this.e.a(eVar);
        this.g.getClass();
        this.c.execute(new t(eVarA));
    }

    static void a(Of of, com.yandex.metrica.e eVar) {
        Sf sf = of.a;
        Context context = of.d;
        sf.getClass();
        R2.a(context).c(eVar);
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2) {
        this.b.reportError(str, str2, null);
        this.c.execute(new h(str, str2, null));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2, Throwable th) {
        this.b.reportError(str, str2, th);
        this.c.execute(new h(str, str2, th));
    }
}
