package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.impl.ob.C1202qi;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.pi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1178pi {
    private final C0854ci A;
    private final Zh B;
    private final RetryPolicyConfig C;
    private final C1297ui D;
    private final long E;
    private final long F;
    private final boolean G;
    private final C1348wl H;
    private final C0982hl I;
    private final C0982hl J;
    private final C0982hl K;
    private final C0985i L;
    private final Ph M;
    private final C1217ra N;
    private final List<String> O;
    private final Oh P;
    private final Uh Q;
    private final C1249si R;
    private final Map<String, Object> S;
    private final String T;
    private final String U;
    private final C1202qi V;
    private final String a;
    private final List<String> b;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private final List<String> g;
    private final Map<String, List<String>> h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final Sh p;
    private final List<C1147oc> q;
    private final C0879di r;
    private final long s;
    private final boolean t;
    private final boolean u;
    private final List<C0829bi> v;
    private final String w;
    private final C1273ti x;
    private final C0804ai y;
    private final List<Bd> z;

    /* renamed from: com.yandex.metrica.impl.ob.pi$a */
    public static final class a {
        private String a;
        private String b;
        private final C1202qi.b c;

        public a(C1202qi.b bVar) {
            this.c = bVar;
        }

        public final a a(List<String> list) {
            this.c.l = list;
            return this;
        }

        public final a b(List<String> list) {
            this.c.k = list;
            return this;
        }

        public final a c(String str) {
            this.a = str;
            return this;
        }

        public final a d(String str) {
            this.b = str;
            return this;
        }

        public final a e(List<String> list) {
            this.c.i = list;
            return this;
        }

        public final a f(List<String> list) {
            this.c.Q = list;
            return this;
        }

        public final a g(List<String> list) {
            this.c.m = list;
            return this;
        }

        public final a h(String str) {
            this.c.p = str;
            return this;
        }

        public final a i(List<String> list) {
            this.c.d = list;
            return this;
        }

        public final a j(String str) {
            this.c.g = str;
            return this;
        }

        public final a k(String str) {
            this.c.a = str;
            return this;
        }

        public final a c(List<String> list) {
            this.c.j = list;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a d(List<? extends C1147oc> list) {
            this.c.s = list;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a a(Map<String, ? extends List<String>> map) {
            this.c.n = map;
            return this;
        }

        public final a b(long j) {
            this.c.b(j);
            return this;
        }

        public final a e(String str) {
            this.c.o = str;
            return this;
        }

        public final a f(String str) {
            this.c.e = str;
            return this;
        }

        public final a g(String str) {
            this.c.q = str;
            return this;
        }

        public final a h(List<? extends Bd> list) {
            this.c.h((List<Bd>) list);
            return this;
        }

        public final a i(String str) {
            this.c.f = str;
            return this;
        }

        public final a j(List<? extends C0829bi> list) {
            this.c.j((List<C0829bi>) list);
            return this;
        }

        public final a b(boolean z) {
            this.c.F = z;
            return this;
        }

        public final a c(long j) {
            this.c.v = j;
            return this;
        }

        public final a a(String str) {
            this.c.h = str;
            return this;
        }

        public final a b(String str) {
            this.c.b(str);
            return this;
        }

        public final a c(boolean z) {
            this.c.x = z;
            return this;
        }

        public final a a(C0879di c0879di) {
            this.c.t = c0879di;
            return this;
        }

        public final a b(C0982hl c0982hl) {
            this.c.K = c0982hl;
            return this;
        }

        public final a c(C0982hl c0982hl) {
            this.c.L = c0982hl;
            return this;
        }

        public final a a(long j) {
            this.c.a(j);
            return this;
        }

        public final a b(Map<String, ? extends Object> map) {
            this.c.b(map);
            return this;
        }

        public final a a(boolean z) {
            this.c.w = z;
            return this;
        }

        public final a a(C1273ti c1273ti) {
            this.c.C = c1273ti;
            return this;
        }

        public final a a(C0804ai c0804ai) {
            this.c.u = c0804ai;
            return this;
        }

        public final a a(C0854ci c0854ci) {
            this.c.a(c0854ci);
            return this;
        }

        public final a a(Zh zh) {
            this.c.a(zh);
            return this;
        }

        public final a a(RetryPolicyConfig retryPolicyConfig) {
            this.c.H = retryPolicyConfig;
            return this;
        }

        public final a a(C1297ui c1297ui) {
            this.c.I = c1297ui;
            return this;
        }

        public final a a(C1348wl c1348wl) {
            this.c.J = c1348wl;
            return this;
        }

        public final a a(C0982hl c0982hl) {
            this.c.M = c0982hl;
            return this;
        }

        public final a a(C0985i c0985i) {
            this.c.N = c0985i;
            return this;
        }

        public final a a(Ph ph) {
            this.c.O = ph;
            return this;
        }

        public final a a(C1217ra c1217ra) {
            this.c.P = c1217ra;
            return this;
        }

        public final a a(Oh oh) {
            this.c.R = oh;
            return this;
        }

        public final a a(C1327w0 c1327w0) {
            this.c.S = c1327w0;
            return this;
        }

        public final a a(Uh uh) {
            this.c.T = uh;
            return this;
        }

        public final a a(C1249si c1249si) {
            this.c.a(c1249si);
            return this;
        }

        public final C1178pi a() {
            String str = this.a;
            String str2 = this.b;
            C1202qi c1202qiA = this.c.a();
            Intrinsics.checkNotNullExpressionValue(c1202qiA, "modelBuilder.build()");
            return new C1178pi(str, str2, c1202qiA, null);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.pi$b */
    public static final class b {
        private final ProtobufStateStorage a;
        private final C0794a8 b;

        public b(ProtobufStateStorage protobufStateStorage, C0794a8 c0794a8) {
            this.a = protobufStateStorage;
            this.b = c0794a8;
        }

        public final C1178pi a() {
            String strA = this.b.a();
            String strB = this.b.b();
            Object obj = this.a.read();
            Intrinsics.checkNotNullExpressionValue(obj, "modelStorage.read()");
            return new C1178pi(strA, strB, (C1202qi) obj, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(Context context) {
            ProtobufStateStorage protobufStateStorageA = InterfaceC0921fa.b.a(C1202qi.class).a(context);
            Intrinsics.checkNotNullExpressionValue(protobufStateStorageA, "StorageFactory.Provider.…ass.java).create(context)");
            F0 f0G = F0.g();
            Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
            this(protobufStateStorageA, f0G.w().a());
        }

        public final void a(C1178pi c1178pi) {
            this.b.a(c1178pi.i());
            this.b.b(c1178pi.j());
            this.a.save(c1178pi.V);
        }
    }

    private C1178pi(String str, String str2, C1202qi c1202qi) {
        this.T = str;
        this.U = str2;
        this.V = c1202qi;
        this.a = c1202qi.a;
        this.b = c1202qi.d;
        this.c = c1202qi.i;
        this.d = c1202qi.j;
        this.e = c1202qi.k;
        this.f = c1202qi.l;
        this.g = c1202qi.m;
        this.h = c1202qi.n;
        this.i = c1202qi.e;
        this.j = c1202qi.f;
        this.k = c1202qi.g;
        this.l = c1202qi.h;
        this.m = c1202qi.o;
        this.n = c1202qi.p;
        this.o = c1202qi.q;
        Sh sh = c1202qi.r;
        Intrinsics.checkNotNullExpressionValue(sh, "startupStateModel.collectingFlags");
        this.p = sh;
        List<C1147oc> list = c1202qi.s;
        Intrinsics.checkNotNullExpressionValue(list, "startupStateModel.locationCollectionConfigs");
        this.q = list;
        this.r = c1202qi.t;
        this.s = c1202qi.u;
        this.t = c1202qi.v;
        this.u = c1202qi.w;
        this.v = c1202qi.x;
        this.w = c1202qi.y;
        this.x = c1202qi.z;
        this.y = c1202qi.A;
        this.z = c1202qi.B;
        this.A = c1202qi.C;
        this.B = c1202qi.D;
        RetryPolicyConfig retryPolicyConfig = c1202qi.E;
        Intrinsics.checkNotNullExpressionValue(retryPolicyConfig, "startupStateModel.retryPolicyConfig");
        this.C = retryPolicyConfig;
        this.D = c1202qi.F;
        this.E = c1202qi.G;
        this.F = c1202qi.H;
        this.G = c1202qi.I;
        this.H = c1202qi.J;
        this.I = c1202qi.K;
        this.J = c1202qi.L;
        this.K = c1202qi.M;
        this.L = c1202qi.N;
        this.M = c1202qi.O;
        C1217ra c1217ra = c1202qi.P;
        Intrinsics.checkNotNullExpressionValue(c1217ra, "startupStateModel.diagnosticsConfigsHolder");
        this.N = c1217ra;
        List<String> list2 = c1202qi.Q;
        Intrinsics.checkNotNullExpressionValue(list2, "startupStateModel.mediascopeApiKeys");
        this.O = list2;
        this.P = c1202qi.R;
        Intrinsics.checkNotNullExpressionValue(c1202qi.S, "startupStateModel.easyCollectingConfig");
        this.Q = c1202qi.T;
        C1249si c1249si = c1202qi.U;
        Intrinsics.checkNotNullExpressionValue(c1249si, "startupStateModel.startupUpdateConfig");
        this.R = c1249si;
        Map<String, Object> map = c1202qi.V;
        Intrinsics.checkNotNullExpressionValue(map, "startupStateModel.modulesRemoteConfigs");
        this.S = map;
    }

    public final Map<String, Object> A() {
        return this.S;
    }

    public final long B() {
        return this.E;
    }

    public final long C() {
        return this.s;
    }

    public final boolean D() {
        return this.G;
    }

    public final List<Bd> E() {
        return this.z;
    }

    public final C0804ai F() {
        return this.y;
    }

    public final String G() {
        return this.j;
    }

    public final List<String> H() {
        return this.b;
    }

    public final List<C0829bi> I() {
        return this.v;
    }

    public final RetryPolicyConfig J() {
        return this.C;
    }

    public final C0854ci K() {
        return this.A;
    }

    public final String L() {
        return this.k;
    }

    public final C0879di M() {
        return this.r;
    }

    public final boolean N() {
        return this.u;
    }

    public final C1249si O() {
        return this.R;
    }

    public final C1273ti P() {
        return this.x;
    }

    public final C1297ui Q() {
        return this.D;
    }

    public final C0982hl R() {
        return this.K;
    }

    public final C0982hl S() {
        return this.I;
    }

    public final C1348wl T() {
        return this.H;
    }

    public final C0982hl U() {
        return this.J;
    }

    public final String V() {
        return this.a;
    }

    public final Oh b() {
        return this.P;
    }

    public final C0985i c() {
        return this.L;
    }

    public final Ph d() {
        return this.M;
    }

    public final String e() {
        return this.l;
    }

    public final Sh f() {
        return this.p;
    }

    public final String g() {
        return this.w;
    }

    public final Map<String, List<String>> h() {
        return this.h;
    }

    public final String i() {
        return this.T;
    }

    public final String j() {
        return this.U;
    }

    public final List<String> k() {
        return this.f;
    }

    public final C1217ra l() {
        return this.N;
    }

    public final Uh m() {
        return this.Q;
    }

    public final String n() {
        return this.m;
    }

    public final long o() {
        return this.F;
    }

    public final String p() {
        return this.i;
    }

    public final boolean q() {
        return this.t;
    }

    public final List<String> r() {
        return this.e;
    }

    public final List<String> s() {
        return this.d;
    }

    public final Zh t() {
        return this.B;
    }

    public String toString() {
        return "StartupState(deviceId=" + this.T + ", deviceIdHash=" + this.U + ", startupStateModel=" + this.V + ')';
    }

    public final String u() {
        return this.o;
    }

    public final String v() {
        return this.n;
    }

    public final List<C1147oc> w() {
        return this.q;
    }

    public final List<String> x() {
        return this.c;
    }

    public final List<String> y() {
        return this.O;
    }

    public final List<String> z() {
        return this.g;
    }

    public final a a() {
        Sh sh = this.V.r;
        Intrinsics.checkNotNullExpressionValue(sh, "startupStateModel.collectingFlags");
        C1202qi.b bVarA = this.V.a(sh);
        Intrinsics.checkNotNullExpressionValue(bVarA, "startupStateModel.buildUpon(collectingFlags)");
        return new a(bVarA).c(this.T).d(this.U);
    }

    public /* synthetic */ C1178pi(String str, String str2, C1202qi c1202qi, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, c1202qi);
    }
}
