package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.AdRevenue;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.ecommerce.ECommerceEvent;
import com.yandex.metrica.plugins.IPluginReporter;
import com.yandex.metrica.plugins.PluginErrorDetails;
import com.yandex.metrica.profile.UserProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.nh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1127nh implements M0, IPluginReporter {
    private final List<InterfaceC1027jh> a = new ArrayList();
    private volatile M0 b;

    /* renamed from: com.yandex.metrica.impl.ob.nh$a */
    class a implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(C1127nh c1127nh, String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.d(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$b */
    class b implements InterfaceC1027jh {
        b(C1127nh c1127nh) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.sendEventsBuffer();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$c */
    class c implements InterfaceC1027jh {
        final /* synthetic */ H6 a;

        c(C1127nh c1127nh, H6 h6) {
            this.a = h6;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$d */
    class d implements InterfaceC1027jh {
        final /* synthetic */ String a;

        d(C1127nh c1127nh, String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportEvent(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$e */
    class e implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        e(C1127nh c1127nh, String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportEvent(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$f */
    class f implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ Map b;

        f(C1127nh c1127nh, String str, Map map) {
            this.a = str;
            this.b = map;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportEvent(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$g */
    class g implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ Throwable b;

        g(C1127nh c1127nh, String str, Throwable th) {
            this.a = str;
            this.b = th;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportError(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$h */
    class h implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Throwable c;

        h(C1127nh c1127nh, String str, String str2, Throwable th) {
            this.a = str;
            this.b = str2;
            this.c = th;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportError(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$i */
    class i implements InterfaceC1027jh {
        final /* synthetic */ Throwable a;

        i(C1127nh c1127nh, Throwable th) {
            this.a = th;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportUnhandledException(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$j */
    class j implements InterfaceC1027jh {
        j(C1127nh c1127nh) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.resumeSession();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$k */
    class k implements InterfaceC1027jh {
        k(C1127nh c1127nh) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.pauseSession();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$l */
    class l implements InterfaceC1027jh {
        final /* synthetic */ String a;

        l(C1127nh c1127nh, String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.setUserProfileID(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$m */
    class m implements InterfaceC1027jh {
        final /* synthetic */ UserProfile a;

        m(C1127nh c1127nh, UserProfile userProfile) {
            this.a = userProfile;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportUserProfile(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$n */
    class n implements InterfaceC1027jh {
        final /* synthetic */ C1333w6 a;

        n(C1127nh c1127nh, C1333w6 c1333w6) {
            this.a = c1333w6;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$o */
    class o implements InterfaceC1027jh {
        final /* synthetic */ Revenue a;

        o(C1127nh c1127nh, Revenue revenue) {
            this.a = revenue;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportRevenue(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$p */
    class p implements InterfaceC1027jh {
        final /* synthetic */ ECommerceEvent a;

        p(C1127nh c1127nh, ECommerceEvent eCommerceEvent) {
            this.a = eCommerceEvent;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportECommerce(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$q */
    class q implements InterfaceC1027jh {
        final /* synthetic */ boolean a;

        q(C1127nh c1127nh, boolean z) {
            this.a = z;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.setStatisticsSending(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$r */
    class r implements InterfaceC1027jh {
        final /* synthetic */ AdRevenue a;

        r(C1127nh c1127nh, AdRevenue adRevenue) {
            this.a = adRevenue;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.reportAdRevenue(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$s */
    class s implements InterfaceC1027jh {
        final /* synthetic */ PluginErrorDetails a;

        s(C1127nh c1127nh, PluginErrorDetails pluginErrorDetails) {
            this.a = pluginErrorDetails;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.getPluginExtension().reportUnhandledException(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$t */
    class t implements InterfaceC1027jh {
        final /* synthetic */ PluginErrorDetails a;
        final /* synthetic */ String b;

        t(C1127nh c1127nh, PluginErrorDetails pluginErrorDetails, String str) {
            this.a = pluginErrorDetails;
            this.b = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.getPluginExtension().reportError(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$u */
    class u implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ PluginErrorDetails c;

        u(C1127nh c1127nh, String str, String str2, PluginErrorDetails pluginErrorDetails) {
            this.a = str;
            this.b = str2;
            this.c = pluginErrorDetails;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.getPluginExtension().reportError(this.a, this.b, this.c);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$v */
    class v implements InterfaceC1027jh {
        v(C1127nh c1127nh) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.b();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$w */
    class w implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;

        w(C1127nh c1127nh, String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.a(this.a, this.b);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.nh$x */
    class x implements InterfaceC1027jh {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        x(C1127nh c1127nh, String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1027jh
        public void a(M0 m0) {
            m0.b(this.a, this.b);
        }
    }

    synchronized void a(Context context) {
        try {
            this.b = Pf.a().a(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
            Iterator<InterfaceC1027jh> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(this.b);
            }
            this.a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void b() {
        a(new v(this));
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void d(String str, String str2) {
        a(new a(this, str, str2));
    }

    @Override // com.yandex.metrica.IReporter
    public IPluginReporter getPluginExtension() {
        return this;
    }

    @Override // com.yandex.metrica.IReporter
    public void pauseSession() {
        a(new k(this));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportAdRevenue(AdRevenue adRevenue) {
        a(new r(this, adRevenue));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportECommerce(ECommerceEvent eCommerceEvent) {
        a(new p(this, eCommerceEvent));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) {
        a(new g(this, str, th));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str) {
        a(new d(this, str));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportRevenue(Revenue revenue) {
        a(new o(this, revenue));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUnhandledException(Throwable th) {
        a(new i(this, th));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportUserProfile(UserProfile userProfile) {
        a(new m(this, userProfile));
    }

    @Override // com.yandex.metrica.IReporter
    public void resumeSession() {
        a(new j(this));
    }

    @Override // com.yandex.metrica.IReporter
    public void sendEventsBuffer() {
        a(new b(this));
    }

    @Override // com.yandex.metrica.IReporter
    public void setStatisticsSending(boolean z) {
        a(new q(this, z));
    }

    @Override // com.yandex.metrica.IReporter
    public void setUserProfileID(String str) {
        a(new l(this, str));
    }

    @Override // com.yandex.metrica.impl.ob.M0, com.yandex.metrica.d
    public void b(String str, String str2) {
        a(new x(this, str, str2));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2) {
        a(new h(this, str, str2, null));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, String str2) {
        a(new e(this, str, str2));
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        a(new s(this, pluginErrorDetails));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportError(String str, String str2, Throwable th) {
        a(new h(this, str, str2, th));
    }

    @Override // com.yandex.metrica.IReporter
    public void reportEvent(String str, Map<String, Object> map) {
        a(new f(this, str, map));
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        a(new t(this, pluginErrorDetails, str));
    }

    @Override // com.yandex.metrica.plugins.IPluginReporter
    public void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        a(new u(this, str, str2, pluginErrorDetails));
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(H6 h6) {
        a(new c(this, h6));
    }

    @Override // com.yandex.metrica.impl.ob.R0
    public void a(C1333w6 c1333w6) {
        a(new n(this, c1333w6));
    }

    @Override // com.yandex.metrica.impl.ob.M0
    public void a(String str, JSONObject jSONObject) {
        a(new w(this, str, jSONObject));
    }

    private synchronized void a(InterfaceC1027jh interfaceC1027jh) {
        try {
            if (this.b == null) {
                this.a.add(interfaceC1027jh);
            } else {
                interfaceC1027jh.a(this.b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
