package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1202qi;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Sh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* renamed from: com.yandex.metrica.impl.ob.f9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0920f9 extends AbstractC0870d9 {
    private Rd c;
    private Rd d;
    private Rd e;
    private Rd f;
    private Rd g;

    @Deprecated
    private Rd h;
    private Rd i;

    @Deprecated
    private Rd j;
    private Rd k;
    private Rd l;
    private Rd m;
    private Rd n;
    private Rd o;
    private Rd p;
    private Rd q;
    private Rd r;
    private Rd s;
    private Rd t;
    private Rd u;
    private Rd v;
    static final Rd w = new Rd("PREF_KEY_UID_", null);
    private static final Rd x = new Rd("PREF_KEY_HOST_URL_", null);
    private static final Rd y = new Rd("PREF_KEY_HOST_URLS_FROM_STARTUP", null);
    private static final Rd z = new Rd("PREF_KEY_HOST_URLS_FROM_CLIENT", null);

    @Deprecated
    private static final Rd A = new Rd("PREF_KEY_REPORT_URL_", null);
    private static final Rd B = new Rd("PREF_KEY_REPORT_URLS_", null);

    @Deprecated
    private static final Rd C = new Rd("PREF_L_URL", null);
    private static final Rd D = new Rd("PREF_L_URLS", null);
    private static final Rd E = new Rd("PREF_KEY_GET_AD_URL", null);
    private static final Rd F = new Rd("PREF_KEY_REPORT_AD_URL", null);
    private static final Rd G = new Rd("PREF_KEY_STARTUP_OBTAIN_TIME_", null);
    private static final Rd H = new Rd("PREF_KEY_STARTUP_ENCODED_CLIDS_", null);
    static final Rd I = new Rd("PREF_KEY_DEVICE_ID_", null);
    private static final Rd J = new Rd("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_", null);

    @Deprecated
    private static final Rd K = new Rd("PREF_KEY_PINNING_UPDATE_URL", null);
    private static final Rd L = new Rd("PREF_KEY_EASY_COLLECTING_ENABLED_", null);
    private static final Rd M = new Rd("PREF_KEY_COLLECTING_PACKAGE_INFO_ENABLED_", null);
    private static final Rd N = new Rd("PREF_KEY_PERMISSIONS_COLLECTING_ENABLED_", null);
    private static final Rd O = new Rd("PREF_KEY_FEATURES_COLLECTING_ENABLED_", null);
    private static final Rd P = new Rd("SOCKET_CONFIG_", null);
    private static final Rd Q = new Rd("LAST_STARTUP_REQUEST_CLIDS", null);

    public C0920f9(S7 s7, String str) {
        super(s7, str);
        this.c = new Rd(I.b());
        this.d = d(w.b());
        this.e = d(x.b());
        this.f = d(y.b());
        this.g = d(z.b());
        this.h = d(A.b());
        this.i = d(B.b());
        this.j = d(C.b());
        this.k = d(D.b());
        this.l = d(E.b());
        this.m = d(F.b());
        this.n = d(G.b());
        this.o = d(H.b());
        this.p = d(J.b());
        this.q = d(L.b());
        this.r = d(M.b());
        this.s = d(N.b());
        this.t = d(O.b());
        this.v = d(Q.b());
        this.u = d(P.b());
    }

    public C0920f9 a(List<String> list) {
        return (C0920f9) b(this.k.a(), Tl.c(list));
    }

    public C0920f9 b(List<String> list) {
        return (C0920f9) b(this.i.a(), Tl.c(list));
    }

    public void f() {
        f(K.a());
        f(this.c.a());
        f(this.l.a());
        f(this.r.a());
        f(this.q.a());
        f(this.o.a());
        f(this.t.a());
        f(this.e.a());
        f(this.g.a());
        f(this.f.a());
        f(this.v.a());
        f(this.j.a());
        f(this.k.a());
        f(this.n.a());
        f(this.s.a());
        f(this.m.a());
        f(this.h.a());
        f(this.i.a());
        f(this.u.a());
        f(this.p.a());
        f(this.d.a());
        f(d(new Rd("PREF_KEY_DISTRIBUTION_REFERRER_", null).b()).a());
        d();
    }

    @Deprecated
    public C1202qi g() {
        C1202qi.b bVar;
        C1202qi.b bVar2;
        C0879di c0879di;
        C1202qi.b bVarI = new C1202qi.b(new Sh(new Sh.a().d(a(this.q.a(), Sh.b.b)).m(a(this.r.a(), Sh.b.c)).n(a(this.s.a(), Sh.b.d)).f(a(this.t.a(), Sh.b.e)))).k(e(this.d.a())).c(Tl.c(e(this.f.a()))).b(Tl.c(e(this.g.a()))).e(e(this.o.a())).i(Tl.c(e(this.i.a()))).e(Tl.c(e(this.k.a()))).f(e(this.l.a())).i(e(this.m.a()));
        String strE = e(this.u.a());
        try {
        } catch (Throwable unused) {
            bVar = bVarI;
        }
        if (TextUtils.isEmpty(strE)) {
            bVar2 = bVarI;
            c0879di = null;
            return bVar2.a(c0879di).h(e(this.v.a())).c(a(this.p.a(), true)).c(a(this.n.a(), -1L)).a();
        }
        JSONObject jSONObject = new JSONObject(strE);
        If.q qVar = new If.q();
        long j = jSONObject.getLong("seconds_to_live");
        String string = jSONObject.getString("token");
        JSONArray jSONArray = jSONObject.getJSONArray("ports");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        bVar = bVarI;
        try {
            c0879di = new C0879di(j, string, arrayList, new ArrayList(), jSONObject.getLong("first_delay_seconds"), jSONObject.getInt("launch_delay_seconds"), jSONObject.optLong("open_event_interval_seconds", qVar.g), qVar.h, qVar.i, qVar.j);
            bVar2 = bVar;
        } catch (Throwable unused2) {
            bVar2 = bVar;
            c0879di = null;
            return bVar2.a(c0879di).h(e(this.v.a())).c(a(this.p.a(), true)).c(a(this.n.a(), -1L)).a();
        }
        return bVar2.a(c0879di).h(e(this.v.a())).c(a(this.p.a(), true)).c(a(this.n.a(), -1L)).a();
    }

    @Deprecated
    public String h(String str) {
        return a(this.h.a(), (String) null);
    }

    @Deprecated
    public C0920f9 i(String str) {
        return (C0920f9) b(this.c.a(), str);
    }

    public C0920f9 j(String str) {
        return (C0920f9) b(this.o.a(), str);
    }

    public C0920f9 k(String str) {
        return (C0920f9) b(this.l.a(), str);
    }

    public C0920f9 l(String str) {
        return (C0920f9) b(this.e.a(), str);
    }

    public C0920f9 m(String str) {
        return (C0920f9) b(this.m.a(), str);
    }

    @Deprecated
    public C0920f9 n(String str) {
        return (C0920f9) b(this.h.a(), str);
    }

    public C0920f9 o(String str) {
        return (C0920f9) b(this.d.a(), str);
    }

    public C0920f9 a(boolean z2) {
        return (C0920f9) b(this.p.a(), z2);
    }

    public C0920f9 b(long j) {
        return (C0920f9) b(this.n.a(), j);
    }

    @Deprecated
    public String g(String str) {
        return a(this.j.a(), (String) null);
    }
}
