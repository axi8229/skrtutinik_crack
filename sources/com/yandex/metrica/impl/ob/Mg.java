package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.C1306v3;
import com.yandex.metrica.impl.ob.Eg;
import com.yandex.metrica.impl.ob.Hg;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Mg extends Hg {
    private final Jg A;
    private List<String> o;
    private List<String> p;
    private String q;
    private String r;
    private Map<String, String> s;
    private C1306v3.a t;
    private List<String> u;
    private boolean v;
    private boolean w;
    private String x;
    private long y;
    private final C1247sg z;

    public static class b extends Eg.a<b, b> implements Dg<b, b> {
        public final String d;
        public final String e;
        public final Map<String, String> f;
        public final boolean g;
        public final List<String> h;

        public b(C1402z3 c1402z3) {
            this(c1402z3.b().d(), c1402z3.b().c(), c1402z3.b().b(), c1402z3.a().d(), c1402z3.a().e(), c1402z3.a().a(), c1402z3.a().j(), c1402z3.a().b());
        }

        @Override // com.yandex.metrica.impl.ob.Dg
        public /* bridge */ /* synthetic */ boolean b(b bVar) {
            return false;
        }

        @Override // com.yandex.metrica.impl.ob.Dg
        public b a(b bVar) {
            String str = this.a;
            String str2 = bVar.a;
            if (str != null) {
                str2 = str;
            }
            String str3 = this.b;
            String str4 = bVar.b;
            if (str3 != null) {
                str4 = str3;
            }
            String str5 = this.c;
            String str6 = bVar.c;
            if (str5 != null) {
                str6 = str5;
            }
            String str7 = this.d;
            String str8 = bVar.d;
            if (str7 != null) {
                str8 = str7;
            }
            String str9 = this.e;
            String str10 = bVar.e;
            if (str9 != null) {
                str10 = str9;
            }
            Map<String, String> map = this.f;
            Map<String, String> map2 = bVar.f;
            if (map != null) {
                map2 = map;
            }
            return new b(str2, str4, str6, str8, str10, map2, this.g || bVar.g, bVar.g ? bVar.h : this.h);
        }

        public b(String str, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z, List<String> list) {
            super(str, str2, str3);
            this.d = str4;
            this.e = str5;
            this.f = map;
            this.g = z;
            this.h = list;
        }

        public b() {
            this(null, null, null, null, null, null, false, null);
        }
    }

    public static class c extends Hg.a<Mg, b> {
        private final I d;

        public c(Context context, String str) {
            this(context, str, new C1108mn(), F0.g().d());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yandex.metrica.impl.ob.Eg.d
        public Eg a(Object obj) {
            Eg.c cVar = (Eg.c) obj;
            Mg mgA = a(cVar);
            C1178pi c1178pi = cVar.a;
            mgA.c(c1178pi.s());
            mgA.b(c1178pi.r());
            String str = ((b) cVar.b).d;
            if (str != null) {
                Mg.a(mgA, str);
                Mg.b(mgA, ((b) cVar.b).e);
            }
            Map<String, String> map = ((b) cVar.b).f;
            mgA.a(map);
            mgA.a(this.d.a(new C1306v3.a(map, EnumC1279u0.APP)));
            mgA.a(((b) cVar.b).g);
            mgA.a(((b) cVar.b).h);
            mgA.b(cVar.a.q());
            mgA.h(cVar.a.g());
            mgA.b(cVar.a.o());
            return mgA;
        }

        protected c(Context context, String str, C1108mn c1108mn, I i) {
            super(context, str, c1108mn);
            this.d = i;
        }

        @Override // com.yandex.metrica.impl.ob.Eg.b
        protected Eg a() {
            return new Mg();
        }
    }

    public C1306v3.a B() {
        return this.t;
    }

    public Map<String, String> C() {
        return this.s;
    }

    public String D() {
        return this.x;
    }

    public String E() {
        return this.q;
    }

    public String F() {
        return this.r;
    }

    public List<String> G() {
        return this.u;
    }

    public C1247sg H() {
        return this.z;
    }

    public List<String> I() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!A2.b(this.o)) {
            linkedHashSet.addAll(this.o);
        }
        if (!A2.b(this.p)) {
            linkedHashSet.addAll(this.p);
        }
        linkedHashSet.addAll(this.A.a());
        return new ArrayList(linkedHashSet);
    }

    public List<String> J() {
        return this.p;
    }

    public boolean K() {
        return this.v;
    }

    public boolean L() {
        return this.w;
    }

    public long a(long j) {
        if (this.y == 0) {
            this.y = j;
        }
        return this.y;
    }

    void b(boolean z) {
        this.w = z;
    }

    void c(List<String> list) {
        this.o = list;
    }

    public void h(String str) {
        this.x = str;
    }

    @Override // com.yandex.metrica.impl.ob.Hg, com.yandex.metrica.impl.ob.Eg
    public String toString() {
        return "StartupRequestConfig{mStartupHostsFromStartup=" + this.o + ", mStartupHostsFromClient=" + this.p + ", mDistributionReferrer='" + this.q + "', mInstallReferrerSource='" + this.r + "', mClidsFromClient=" + this.s + ", mNewCustomHosts=" + this.u + ", mHasNewCustomHosts=" + this.v + ", mSuccessfulStartup=" + this.w + ", mCountryInit='" + this.x + "', mFirstStartupTime=" + this.y + "} " + super.toString();
    }

    private Mg() {
        this(F0.g().m(), new Jg());
    }

    void b(long j) {
        if (this.y == 0) {
            this.y = j;
        }
    }

    Mg(C1247sg c1247sg, Jg jg) {
        this.t = new C1306v3.a(null, EnumC1279u0.APP);
        this.y = 0L;
        this.z = c1247sg;
        this.A = jg;
    }

    void a(Map<String, String> map) {
        this.s = map;
    }

    void b(List<String> list) {
        this.p = list;
    }

    static void b(Mg mg, String str) {
        mg.r = str;
    }

    void a(C1306v3.a aVar) {
        this.t = aVar;
    }

    static void a(Mg mg, String str) {
        mg.q = str;
    }

    public void a(List<String> list) {
        this.u = list;
    }

    public void a(boolean z) {
        this.v = z;
    }
}
