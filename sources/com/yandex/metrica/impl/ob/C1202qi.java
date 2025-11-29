package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.qi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1202qi {
    public final C0804ai A;
    public final List<Bd> B;
    public final C0854ci C;
    public final Zh D;
    public final RetryPolicyConfig E;
    public final C1297ui F;
    public final long G;
    public final long H;
    public final boolean I;
    public final C1348wl J;
    public final C0982hl K;
    public final C0982hl L;
    public final C0982hl M;
    public final C0985i N;
    public final Ph O;
    public final C1217ra P;
    public final List<String> Q;
    public final Oh R;
    public final C1327w0 S;
    public final Uh T;
    public final C1249si U;
    public final Map<String, Object> V;
    public final String a;

    @Deprecated
    public final String b;

    @Deprecated
    public final String c;
    public final List<String> d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final List<String> i;
    public final List<String> j;
    public final List<String> k;
    public final List<String> l;
    public final List<String> m;
    public final Map<String, List<String>> n;
    public final String o;
    public final String p;
    public final String q;
    public final Sh r;
    public final List<C1147oc> s;
    public final C0879di t;
    public final long u;
    public final boolean v;
    public final boolean w;
    public final List<C0829bi> x;
    public final String y;
    public final C1273ti z;

    @Deprecated
    /* renamed from: com.yandex.metrica.impl.ob.qi$b */
    public static class b {
        private List<Bd> A;
        private C0854ci B;
        C1273ti C;
        private long D;
        private long E;
        boolean F;
        private Zh G;
        RetryPolicyConfig H;
        C1297ui I;
        C1348wl J;
        C0982hl K;
        C0982hl L;
        C0982hl M;
        C0985i N;
        Ph O;
        C1217ra P;
        List<String> Q;
        Oh R;
        C1327w0 S;
        Uh T;
        private C1249si U;
        private Map<String, Object> V;
        String a;
        String b;
        String c;
        List<String> d;
        String e;
        String f;
        String g;
        String h;
        List<String> i;
        List<String> j;
        List<String> k;
        List<String> l;
        List<String> m;
        Map<String, List<String>> n;
        String o;
        String p;
        String q;
        final Sh r;
        List<C1147oc> s;
        C0879di t;
        C0804ai u;
        long v;
        boolean w;
        boolean x;
        private List<C0829bi> y;
        private String z;

        public b(Sh sh) {
            this.r = sh;
        }

        public b j(String str) {
            this.g = str;
            return this;
        }

        public b k(String str) {
            this.a = str;
            return this;
        }

        public b a(String str) {
            this.h = str;
            return this;
        }

        public b b(List<String> list) {
            this.k = list;
            return this;
        }

        @Deprecated
        public b c(String str) {
            this.b = str;
            return this;
        }

        @Deprecated
        public b d(String str) {
            this.c = str;
            return this;
        }

        public b e(List<String> list) {
            this.i = list;
            return this;
        }

        public b f(String str) {
            this.e = str;
            return this;
        }

        public b g(List<String> list) {
            this.m = list;
            return this;
        }

        public b h(String str) {
            this.p = str;
            return this;
        }

        public b i(List<String> list) {
            this.d = list;
            return this;
        }

        public b j(List<C0829bi> list) {
            this.y = list;
            return this;
        }

        public b a(List<String> list) {
            this.l = list;
            return this;
        }

        public b b(String str) {
            this.z = str;
            return this;
        }

        public b c(List<String> list) {
            this.j = list;
            return this;
        }

        public b d(List<C1147oc> list) {
            this.s = list;
            return this;
        }

        public b e(String str) {
            this.o = str;
            return this;
        }

        public b f(List<String> list) {
            this.Q = list;
            return this;
        }

        public b g(String str) {
            this.q = str;
            return this;
        }

        public b h(List<Bd> list) {
            this.A = list;
            return this;
        }

        public b i(String str) {
            this.f = str;
            return this;
        }

        public b a(Map<String, List<String>> map) {
            this.n = map;
            return this;
        }

        public b b(long j) {
            this.D = j;
            return this;
        }

        public b c(long j) {
            this.v = j;
            return this;
        }

        public b a(C0879di c0879di) {
            this.t = c0879di;
            return this;
        }

        public b b(boolean z) {
            this.F = z;
            return this;
        }

        public b c(boolean z) {
            this.x = z;
            return this;
        }

        public b a(C0804ai c0804ai) {
            this.u = c0804ai;
            return this;
        }

        public b b(C0982hl c0982hl) {
            this.K = c0982hl;
            return this;
        }

        public b c(C0982hl c0982hl) {
            this.L = c0982hl;
            return this;
        }

        public b a(boolean z) {
            this.w = z;
            return this;
        }

        public b b(Map<String, Object> map) {
            this.V = map;
            return this;
        }

        public b a(C0854ci c0854ci) {
            this.B = c0854ci;
            return this;
        }

        public b a(long j) {
            this.E = j;
            return this;
        }

        public b a(C1273ti c1273ti) {
            this.C = c1273ti;
            return this;
        }

        public b a(Zh zh) {
            this.G = zh;
            return this;
        }

        public b a(RetryPolicyConfig retryPolicyConfig) {
            this.H = retryPolicyConfig;
            return this;
        }

        public b a(C1297ui c1297ui) {
            this.I = c1297ui;
            return this;
        }

        public b a(C1348wl c1348wl) {
            this.J = c1348wl;
            return this;
        }

        public b a(C0982hl c0982hl) {
            this.M = c0982hl;
            return this;
        }

        public b a(C0985i c0985i) {
            this.N = c0985i;
            return this;
        }

        public b a(Ph ph) {
            this.O = ph;
            return this;
        }

        public b a(C1217ra c1217ra) {
            this.P = c1217ra;
            return this;
        }

        public b a(Oh oh) {
            this.R = oh;
            return this;
        }

        public b a(C1327w0 c1327w0) {
            this.S = c1327w0;
            return this;
        }

        public b a(Uh uh) {
            this.T = uh;
            return this;
        }

        public b a(C1249si c1249si) {
            this.U = c1249si;
            return this;
        }

        public C1202qi a() {
            return new C1202qi(this);
        }
    }

    public b a(Sh sh) {
        b bVar = new b(sh);
        bVar.a = this.a;
        bVar.b = this.b;
        bVar.c = this.c;
        bVar.j = this.j;
        bVar.k = this.k;
        bVar.o = this.o;
        bVar.d = this.d;
        bVar.i = this.i;
        bVar.e = this.e;
        bVar.f = this.f;
        bVar.g = this.g;
        bVar.h = this.h;
        bVar.l = this.l;
        bVar.m = this.m;
        bVar.s = this.s;
        bVar.n = this.n;
        bVar.t = this.t;
        bVar.p = this.p;
        bVar.q = this.q;
        bVar.x = this.w;
        bVar.v = this.u;
        bVar.w = this.v;
        b bVarH = bVar.j(this.x).b(this.y).h(this.B);
        bVarH.u = this.A;
        b bVarA = bVarH.a(this.C).b(this.G).a(this.H);
        bVarA.C = this.z;
        bVarA.F = this.I;
        b bVarA2 = bVarA.a(this.D);
        RetryPolicyConfig retryPolicyConfig = this.E;
        bVarA2.I = this.F;
        bVarA2.H = retryPolicyConfig;
        bVarA2.J = this.J;
        bVarA2.K = this.K;
        bVarA2.L = this.L;
        bVarA2.M = this.M;
        bVarA2.O = this.O;
        bVarA2.P = this.P;
        bVarA2.Q = this.Q;
        bVarA2.N = this.N;
        bVarA2.R = this.R;
        bVarA2.S = this.S;
        bVarA2.T = this.T;
        return bVarA2.a(this.U).b(this.V);
    }

    public String toString() {
        return "StartupStateModel{uuid='" + this.a + "', deviceID='" + this.b + "', deviceIDHash='" + this.c + "', reportUrls=" + this.d + ", getAdUrl='" + this.e + "', reportAdUrl='" + this.f + "', sdkListUrl='" + this.g + "', certificateUrl='" + this.h + "', locationUrls=" + this.i + ", hostUrlsFromStartup=" + this.j + ", hostUrlsFromClient=" + this.k + ", diagnosticUrls=" + this.l + ", mediascopeUrls=" + this.m + ", customSdkHosts=" + this.n + ", encodedClidsFromResponse='" + this.o + "', lastClientClidsForStartupRequest='" + this.p + "', lastChosenForRequestClids='" + this.q + "', collectingFlags=" + this.r + ", locationCollectionConfigs=" + this.s + ", socketConfig=" + this.t + ", obtainTime=" + this.u + ", hadFirstStartup=" + this.v + ", startupDidNotOverrideClids=" + this.w + ", requests=" + this.x + ", countryInit='" + this.y + "', statSending=" + this.z + ", permissionsCollectingConfig=" + this.A + ", permissions=" + this.B + ", sdkFingerprintingConfig=" + this.C + ", identityLightCollectingConfig=" + this.D + ", retryPolicyConfig=" + this.E + ", throttlingConfig=" + this.F + ", obtainServerTime=" + this.G + ", firstStartupServerTime=" + this.H + ", outdated=" + this.I + ", uiParsingConfig=" + this.J + ", uiEventCollectingConfig=" + this.K + ", uiRawEventCollectingConfig=" + this.L + ", uiCollectingForBridgeConfig=" + this.M + ", autoInappCollectingConfig=" + this.N + ", cacheControl=" + this.O + ", diagnosticsConfigsHolder=" + this.P + ", mediascopeApiKeys=" + this.Q + ", attributionConfig=" + this.R + ", easyCollectingConfig=" + this.S + ", egressConfig=" + this.T + ", startupUpdateConfig=" + this.U + ", modulesRemoteConfigs=" + this.V + '}';
    }

    private C1202qi(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        List<String> list = bVar.d;
        this.d = list == null ? null : A2.c(list);
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        List<String> list2 = bVar.i;
        this.i = list2 == null ? null : A2.c(list2);
        List<String> list3 = bVar.j;
        this.j = list3 == null ? null : A2.c(list3);
        List<String> list4 = bVar.k;
        this.k = list4 == null ? null : A2.c(list4);
        List<String> list5 = bVar.l;
        this.l = list5 == null ? null : A2.c(list5);
        List<String> list6 = bVar.m;
        this.m = list6 == null ? null : A2.c(list6);
        Map<String, List<String>> map = bVar.n;
        this.n = map == null ? null : A2.d(map);
        this.o = bVar.o;
        this.p = bVar.p;
        this.r = bVar.r;
        List<C1147oc> list7 = bVar.s;
        this.s = list7 == null ? new ArrayList<>() : list7;
        this.t = bVar.t;
        this.A = bVar.u;
        this.u = bVar.v;
        this.v = bVar.w;
        this.q = bVar.q;
        this.w = bVar.x;
        this.x = bVar.y != null ? A2.c(bVar.y) : null;
        this.y = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        this.z = bVar.C;
        this.G = bVar.D;
        this.H = bVar.E;
        this.I = bVar.F;
        this.D = bVar.G;
        RetryPolicyConfig retryPolicyConfig = bVar.H;
        if (retryPolicyConfig == null) {
            If r0 = new If();
            this.E = new RetryPolicyConfig(r0.H, r0.I);
        } else {
            this.E = retryPolicyConfig;
        }
        this.F = bVar.I;
        this.J = bVar.J;
        this.K = bVar.K;
        this.L = bVar.L;
        this.M = bVar.M;
        this.N = bVar.N;
        this.O = bVar.O;
        C1217ra c1217ra = bVar.P;
        this.P = c1217ra == null ? new C1217ra() : c1217ra;
        List<String> list8 = bVar.Q;
        this.Q = list8 == null ? new ArrayList<>() : list8;
        this.R = bVar.R;
        C1327w0 c1327w0 = bVar.S;
        this.S = c1327w0 == null ? new C1327w0(C1085m0.b.a) : c1327w0;
        this.T = bVar.T;
        this.U = bVar.U == null ? new C1249si(C1085m0.c.a) : bVar.U;
        this.V = bVar.V == null ? Collections.emptyMap() : bVar.V;
    }
}
