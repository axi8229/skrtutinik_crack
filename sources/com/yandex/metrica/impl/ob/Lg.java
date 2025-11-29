package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.Eg;
import com.yandex.metrica.impl.ob.Hg;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Lg extends Hg {
    private boolean A;
    private String B;
    private List<String> C;
    private int D;
    private long E;
    private long F;
    private boolean G;
    private long H;
    private List<String> I;
    private boolean o;
    private Location p;
    private boolean q;
    private int r;
    private int s;
    private boolean t;
    private int u;
    private Boolean v;
    private e w;
    private final d x;
    private String y;
    private boolean z;

    public static final class a extends Eg.a<D3.a, a> {
        public final String d;
        public final Location e;
        public final boolean f;
        public final boolean g;
        public final int h;
        public final int i;
        public final int j;
        public final boolean k;
        public final boolean l;
        public final Map<String, String> m;
        public final int n;

        public a(D3.a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h, aVar.i, aVar.j, aVar.k, aVar.l, aVar.m, aVar.n);
        }

        @Override // com.yandex.metrica.impl.ob.Dg
        public Object a(Object obj) {
            D3.a aVar = (D3.a) obj;
            String str = aVar.a;
            String str2 = this.a;
            if (str != null) {
                str2 = str;
            }
            String str3 = aVar.b;
            String str4 = this.b;
            if (str3 != null) {
                str4 = str3;
            }
            String str5 = aVar.c;
            String str6 = this.c;
            if (str5 != null) {
                str6 = str5;
            }
            String str7 = aVar.d;
            String str8 = this.d;
            if (str7 != null) {
                str8 = str7;
            }
            Boolean bool = aVar.e;
            Boolean boolValueOf = Boolean.valueOf(this.f);
            if (bool != null) {
                boolValueOf = bool;
            }
            Location location = aVar.f;
            Location location2 = this.e;
            if (location != null) {
                location2 = location;
            }
            Boolean bool2 = aVar.g;
            Boolean boolValueOf2 = Boolean.valueOf(this.g);
            if (bool2 != null) {
                boolValueOf2 = bool2;
            }
            Integer num = aVar.h;
            Integer numValueOf = Integer.valueOf(this.h);
            if (num != null) {
                numValueOf = num;
            }
            Integer num2 = aVar.i;
            Integer numValueOf2 = Integer.valueOf(this.i);
            if (num2 != null) {
                numValueOf2 = num2;
            }
            Integer num3 = aVar.j;
            Integer numValueOf3 = Integer.valueOf(this.j);
            if (num3 != null) {
                numValueOf3 = num3;
            }
            Boolean bool3 = aVar.k;
            Boolean boolValueOf3 = Boolean.valueOf(this.k);
            if (bool3 != null) {
                boolValueOf3 = bool3;
            }
            Boolean bool4 = aVar.l;
            Boolean boolValueOf4 = Boolean.valueOf(this.l);
            if (bool4 != null) {
                boolValueOf4 = bool4;
            }
            Map<String, String> map = aVar.m;
            Map<String, String> map2 = this.m;
            if (map != null) {
                map2 = map;
            }
            Integer num4 = aVar.n;
            return new a(str2, str4, str6, str8, boolValueOf, location2, boolValueOf2, numValueOf, numValueOf2, numValueOf3, boolValueOf3, boolValueOf4, map2, num4 == null ? Integer.valueOf(this.n) : num4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:123:0x01a3, code lost:
        
            if (r2.getExtras() == null) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x01a5, code lost:
        
            r8 = r2.getExtras().equals(r8.getExtras());
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x01b6, code lost:
        
            if (r8.getExtras() != null) goto L128;
         */
        /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
        @Override // com.yandex.metrica.impl.ob.Dg
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 447
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Lg.a.b(java.lang.Object):boolean");
        }

        a(String str, String str2, String str3, String str4, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map<String, String> map, Integer num4) {
            super(str, str2, str3);
            this.d = str4;
            Boolean bool5 = Boolean.FALSE;
            this.f = ((Boolean) Tl.a(bool, bool5)).booleanValue();
            this.e = location;
            this.g = ((Boolean) Tl.a(bool2, bool5)).booleanValue();
            this.h = Math.max(10, ((Integer) Tl.a((int) num, 10)).intValue());
            this.i = ((Integer) Tl.a((int) num2, 7)).intValue();
            this.j = ((Integer) Tl.a((int) num3, 90)).intValue();
            this.k = ((Boolean) Tl.a(bool3, bool5)).booleanValue();
            this.l = ((Boolean) Tl.a(bool4, Boolean.TRUE)).booleanValue();
            this.m = map;
            this.n = ((Integer) Tl.a((int) num4, 1000)).intValue();
        }
    }

    public static abstract class b implements e {
        protected final C1233s2 a;

        public b(C1233s2 c1233s2) {
            this.a = c1233s2;
        }

        @Override // com.yandex.metrica.impl.ob.Lg.e
        public boolean a(Boolean bool) {
            Boolean bool2 = Boolean.TRUE;
            if (bool == null) {
                bool = bool2;
            }
            return bool.booleanValue();
        }
    }

    public static class c extends Hg.a<Lg, a> {
        private final L3 d;
        private final e e;
        private final Rh f;

        public c(L3 l3, e eVar) {
            this(l3, eVar, new Rh());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yandex.metrica.impl.ob.Eg.d
        public Eg a(Object obj) {
            Eg.c cVar = (Eg.c) obj;
            Lg lgA = a(cVar);
            Lg.a(lgA, ((a) cVar.b).d);
            lgA.a(this.d.x().a());
            lgA.a(this.d.d().a());
            lgA.d(((a) cVar.b).f);
            lgA.a(((a) cVar.b).e);
            lgA.c(((a) cVar.b).g);
            lgA.d(((a) cVar.b).h);
            lgA.c(((a) cVar.b).i);
            lgA.b(((a) cVar.b).j);
            lgA.e(((a) cVar.b).k);
            lgA.a(Boolean.valueOf(((a) cVar.b).l), this.e);
            lgA.a(((a) cVar.b).n);
            C1178pi c1178pi = cVar.a;
            a aVar = (a) cVar.b;
            lgA.b(c1178pi.y().contains(aVar.d) ? c1178pi.z() : c1178pi.H());
            lgA.f(c1178pi.f().c);
            if (c1178pi.F() != null) {
                lgA.b(c1178pi.F().a);
                lgA.c(c1178pi.F().b);
            }
            lgA.b(c1178pi.f().d);
            lgA.h(c1178pi.n());
            lgA.a(this.f.a(aVar.m, c1178pi, F0.g().d()));
            return lgA;
        }

        c(L3 l3, e eVar, Rh rh) {
            super(l3.g(), l3.e().b());
            this.d = l3;
            this.e = eVar;
            this.f = rh;
        }

        @Override // com.yandex.metrica.impl.ob.Eg.b
        protected Eg a() {
            return new Lg(this.d);
        }
    }

    public interface d {
    }

    public interface e {
        boolean a(Boolean bool);
    }

    Lg(d dVar) {
        this.x = dVar;
    }

    static void a(Lg lg, String str) {
        lg.y = str;
    }

    public String B() {
        return this.y;
    }

    public int C() {
        return this.D;
    }

    public List<String> D() {
        return this.I;
    }

    public String E() {
        String str = this.B;
        return str == null ? "" : str;
    }

    public boolean F() {
        return this.w.a(this.v);
    }

    public int G() {
        return this.s;
    }

    public Location H() {
        return this.p;
    }

    public int I() {
        return this.u;
    }

    public long J() {
        return this.H;
    }

    public long K() {
        return this.E;
    }

    public long L() {
        return this.F;
    }

    public List<String> M() {
        return this.C;
    }

    public int N() {
        return this.r;
    }

    public boolean O() {
        return this.A;
    }

    public boolean P() {
        return this.q;
    }

    public boolean Q() {
        return this.o;
    }

    public boolean R() {
        return this.z;
    }

    public boolean S() {
        return x() && !A2.b(this.C) && this.G;
    }

    public boolean T() {
        return ((L3) this.x).F();
    }

    public void b(List<String> list) {
        this.C = list;
    }

    public void c(long j) {
        this.F = j;
    }

    public void d(boolean z) {
        this.o = z;
    }

    public void e(boolean z) {
        this.t = z;
    }

    public void f(boolean z) {
        this.z = z;
    }

    void h(String str) {
        this.B = str;
    }

    @Override // com.yandex.metrica.impl.ob.Hg, com.yandex.metrica.impl.ob.Eg
    public String toString() {
        return "ReportRequestConfig{mLocationTracking=" + this.o + ", mManualLocation=" + this.p + ", mFirstActivationAsUpdate=" + this.q + ", mSessionTimeout=" + this.r + ", mDispatchPeriod=" + this.s + ", mLogEnabled=" + this.t + ", mMaxReportsCount=" + this.u + ", statisticSendingFromArguments=" + this.v + ", statisticsSendingStrategy=" + this.w + ", mPreloadInfoSendingStrategy=" + this.x + ", mApiKey='" + this.y + "', mPermissionsCollectingEnabled=" + this.z + ", mFeaturesCollectingEnabled=" + this.A + ", mClidsFromStartupResponse='" + this.B + "', mReportHosts=" + this.C + ", mAttributionId=" + this.D + ", mPermissionsCollectingIntervalSeconds=" + this.E + ", mPermissionsForceSendIntervalSeconds=" + this.F + ", mClidsFromClientMatchClidsFromStartupRequest=" + this.G + ", mMaxReportsInDbCount=" + this.H + ", mCertificates=" + this.I + "} " + super.toString();
    }

    public void a(Location location) {
        this.p = location;
    }

    public void b(long j) {
        this.E = j;
    }

    public void c(boolean z) {
        this.q = z;
    }

    public void d(int i) {
        this.r = i;
    }

    public void a(int i) {
        this.D = i;
    }

    public void b(boolean z) {
        this.A = z;
    }

    public void c(int i) {
        this.u = i;
    }

    public void a(long j) {
        this.H = j;
    }

    public void b(int i) {
        this.s = i;
    }

    public void a(List<String> list) {
        this.I = list;
    }

    public void a(Boolean bool, e eVar) {
        this.v = bool;
        this.w = eVar;
    }

    public void a(boolean z) {
        this.G = z;
    }
}
