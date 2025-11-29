package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.b9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0820b9 extends AbstractC0870d9 {
    static final Rd A;
    static final Rd B;
    static final Rd C;
    static final Rd D;
    static final Rd E;
    static final Rd F;
    static final Rd G;

    @Deprecated
    static final Rd c = new Rd("UUID", null);
    static final Rd d = new Rd("UUID_RESULT", null);

    @Deprecated
    static final Rd e = new Rd("DEVICE_ID", null);
    static final Rd f = new Rd("DEVICE_ID_RESULT", null);

    @Deprecated
    static final Rd g = new Rd("DEVICE_ID_HASH", null);
    static final Rd h = new Rd("DEVICE_ID_HASH_RESULT", null);

    @Deprecated
    static final Rd i = new Rd("AD_URL_GET", null);
    static final Rd j = new Rd("AD_URL_GET_RESULT", null);

    @Deprecated
    static final Rd k = new Rd("AD_URL_REPORT", null);
    static final Rd l = new Rd("AD_URL_REPORT_RESULT", null);
    static final Rd m = new Rd("CUSTOM_HOSTS", null);
    static final Rd n = new Rd("SERVER_TIME_OFFSET", null);

    @Deprecated
    static final Rd o = new Rd("CLIDS", null);
    static final Rd p = new Rd("RESPONSE_CLIDS_RESULT", null);
    static final Rd q = new Rd("CUSTOM_SDK_HOSTS", null);
    static final Rd r = new Rd("CLIENT_CLIDS", null);
    static final Rd s = new Rd("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    static final Rd t;
    static final Rd u;
    static final Rd v;
    static final Rd w;
    static final Rd x;
    static final Rd y;
    static final Rd z;

    static {
        new Rd("DEPRECATED_NATIVE_CRASHES_CHECKED", null);
        t = new Rd("API_LEVEL", null);
        u = new Rd("ADS_REQUESTED_CONTEXT", null);
        v = new Rd("CONTEXT_HISTORY", null);
        w = new Rd("ACCESS_CONFIG", null);
        x = new Rd("DIAGNOSTICS_CONFIGS_HOLDER", null);
        y = new Rd("NEXT_STARTUP_TIME", null);
        z = new Rd("LAST_UI_CONTEXT_ID", null);
        A = new Rd("GAID", null);
        B = new Rd("HOAID", null);
        C = new Rd("YANDEX_ADV_ID", null);
        D = new Rd("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
        E = new Rd("SCREEN_INFO", null);
        F = new Rd("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
        G = new Rd("FEATURES", null);
    }

    public C0820b9(S7 s7) {
        super(s7);
    }

    public C0820b9 a(W0 w0) {
        return a(j.a(), w0);
    }

    public boolean b(boolean z2) {
        return a(D.a(), z2);
    }

    public C0820b9 c(W0 w0) {
        return a(q.a(), w0);
    }

    public long d(long j2) {
        return a(n.b(), j2);
    }

    public C0820b9 e(W0 w0) {
        return a(f.a(), w0);
    }

    public W0 f() {
        return i(j.a());
    }

    public W0 g() {
        return i(l.a());
    }

    @Deprecated
    public String h(String str) {
        return a(k.a(), (String) null);
    }

    public List<String> i() {
        String strA = a(m.a(), (String) null);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return Tl.c(strA);
    }

    public W0 j() {
        return i(q.a());
    }

    public W0 k() {
        return i(h.a());
    }

    public W0 l() {
        return i(f.a());
    }

    @Deprecated
    public String m(String str) {
        return a(g.a(), (String) null);
    }

    public Xh n() {
        String strA = a(G.a(), (String) null);
        try {
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject = new JSONObject(strA);
                return new Xh(Tl.a(jSONObject, "libSslEnabled", (Boolean) null), U0.a(Tl.b(jSONObject, "STATUS")), Tl.b(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new Xh(null, U0.UNKNOWN, null);
    }

    public W0 o() {
        return i(A.a());
    }

    public W0 p() {
        return i(B.a());
    }

    @Deprecated
    public C0820b9 q(String str) {
        return (C0820b9) b(o.a(), str);
    }

    public W0 r() {
        return i(p.a());
    }

    @Deprecated
    public C0820b9 s(String str) {
        return (C0820b9) b(e.a(), str);
    }

    @Deprecated
    public C0820b9 t(String str) {
        return (C0820b9) b(c.a(), str);
    }

    public W0 u() {
        return i(d.a());
    }

    public W0 v() {
        return i(C.a());
    }

    public boolean w() {
        return a(s.a(), false);
    }

    public boolean x() {
        return a(F.a(), false);
    }

    public C0820b9 y() {
        return (C0820b9) b(s.a(), true);
    }

    public void z() {
        b(F.a(), true);
    }

    public C0820b9 a(Xh xh) {
        String strA = G.a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", xh.b()).put("STATUS", xh.c().a()).putOpt("ERROR_EXPLANATION", xh.a());
        } catch (Throwable unused) {
        }
        return (C0820b9) b(strA, jSONObject.toString());
    }

    public long b(long j2) {
        return a(t.a(), j2);
    }

    public C0820b9 c(boolean z2) {
        return (C0820b9) b(u.a(), z2);
    }

    public C0820b9 d(W0 w0) {
        return a(h.a(), w0);
    }

    public C0820b9 e(long j2) {
        return (C0820b9) b(t.a(), j2);
    }

    public C0820b9 f(W0 w0) {
        return a(A.a(), w0);
    }

    @Deprecated
    public String g(String str) {
        return a(i.a(), (String) null);
    }

    public C0820b9 h(W0 w0) {
        return a(p.a(), w0);
    }

    @Deprecated
    public String j(String str) {
        return a(o.a(), (String) null);
    }

    public String k(String str) {
        return a(r.a(), (String) null);
    }

    @Deprecated
    public String l(String str) {
        return a(e.a(), (String) null);
    }

    public C1217ra m() {
        C1217ra c1217raA = null;
        try {
            String strA = a(x.a(), (String) null);
            if (strA != null) {
                c1217raA = Tl.a(new JSONObject(strA));
            }
        } catch (Throwable unused) {
        }
        return c1217raA == null ? new C1217ra() : c1217raA;
    }

    @Deprecated
    public C0820b9 o(String str) {
        return (C0820b9) b(i.a(), str);
    }

    @Deprecated
    public C0820b9 p(String str) {
        return (C0820b9) b(k.a(), str);
    }

    public long q() {
        return a(y.a(), 0L);
    }

    public C0820b9 r(String str) {
        return (C0820b9) b(r.a(), str);
    }

    public C0838c2 s() {
        return Tl.f(e(E.a()));
    }

    public C0932fl t() {
        try {
            String strA = a(w.a(), (String) null);
            if (strA != null) {
                return Tl.c(new JSONObject(strA));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0820b9 b(W0 w0) {
        return a(l.a(), w0);
    }

    public long c(long j2) {
        return a(z.a(), j2);
    }

    public C0820b9 d(boolean z2) {
        return (C0820b9) b(D.a(), z2);
    }

    public C0820b9 f(long j2) {
        return (C0820b9) b(z.a(), j2);
    }

    public C0820b9 g(W0 w0) {
        return a(B.a(), w0);
    }

    public C0820b9 h(long j2) {
        return (C0820b9) b(n.a(), j2);
    }

    public C0820b9 i(W0 w0) {
        return a(d.a(), w0);
    }

    public C0820b9 j(W0 w0) {
        return a(C.a(), w0);
    }

    private W0 i(String str) {
        W0 w0;
        String strA;
        try {
            strA = a(str, (String) null);
        } catch (Throwable unused) {
        }
        if (strA != null) {
            JSONObject jSONObject = new JSONObject(strA);
            w0 = new W0(Tl.b(jSONObject, "ID"), U0.a(Tl.b(jSONObject, "STATUS")), Tl.b(jSONObject, "ERROR_EXPLANATION"));
        } else {
            w0 = null;
        }
        return w0 == null ? new W0(null, U0.UNKNOWN, "no identifier in preferences") : w0;
    }

    public C0820b9 b(List<String> list) {
        return (C0820b9) b(m.a(), Tl.c(list));
    }

    public C0820b9 g(long j2) {
        return (C0820b9) b(y.a(), j2);
    }

    public List<String> h() {
        LinkedList linkedList = new LinkedList();
        List<String> listA = a(v.a(), linkedList);
        return listA == null ? linkedList : listA;
    }

    @Deprecated
    public String n(String str) {
        return a(c.a(), (String) null);
    }

    public boolean a(boolean z2) {
        return a(u.a(), z2);
    }

    public C0820b9 a(List<String> list) {
        return (C0820b9) b(v.a(), list);
    }

    public C0820b9 a(C0932fl c0932fl) {
        String string;
        if (c0932fl != null) {
            try {
                string = Tl.a(c0932fl).toString();
            } catch (Throwable unused) {
            }
        } else {
            string = null;
        }
        if (string != null) {
            b(w.a(), string);
        }
        return this;
    }

    public C0820b9 a(C1217ra c1217ra) {
        return (C0820b9) b(x.a(), Tl.a(c1217ra).toString());
    }

    public void a(C0838c2 c0838c2) {
        b(E.a(), Tl.a(c0838c2));
    }

    private C0820b9 a(String str, W0 w0) {
        String string;
        if (w0 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ID", w0.a).put("STATUS", w0.b.a()).put("ERROR_EXPLANATION", w0.c);
                } catch (Throwable unused) {
                }
                string = jSONObject.toString();
            } catch (Throwable unused2) {
            }
        } else {
            string = null;
        }
        if (string != null) {
            b(str, string);
        }
        return this;
    }
}
