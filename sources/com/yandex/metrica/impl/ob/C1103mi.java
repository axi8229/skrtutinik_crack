package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.IParamsCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.mi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1103mi {
    private final Set<String> a;
    private final Map<String, W0> b;
    private List<String> c;
    private Map<String, String> d;
    private long e;
    private boolean f;
    private C0932fl g;
    private C1217ra h;
    private long i;
    private final List<InterfaceC0957gl> j;
    private final C0820b9 k;
    private final Rh l;
    private final Th m;
    private final Wh n;

    public C1103mi(Context context, C0820b9 c0820b9) {
        this(c0820b9, new Nh(), new Rh(), C0905ej.a(context).a(context, new C0980hj(c0820b9)), new Th(), new Wh(), new Vh());
    }

    private void b(String str, W0 w0) {
        if (a(w0)) {
            return;
        }
        this.b.put(str, w0);
    }

    private void h() {
        this.k.i(this.b.get("yandex_mobile_metrica_uuid")).e(this.b.get("yandex_mobile_metrica_device_id")).d(this.b.get("appmetrica_device_id_hash")).a(this.b.get("yandex_mobile_metrica_get_ad_url")).b(this.b.get("yandex_mobile_metrica_report_ad_url")).h(this.e).h(this.b.get(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS)).r(Tl.c(this.d)).a(this.g).a(this.h).f(this.b.get("yandex_mobile_metrica_google_adv_id")).g(this.b.get("yandex_mobile_metrica_huawei_oaid")).j(this.b.get("yandex_mobile_metrica_yandex_adv_id")).d(this.f).c(this.m.a()).g(this.i).a(this.n.a()).d();
    }

    public void a(Map<String, String> map) {
        if (A2.b(map) || A2.a(map, this.d)) {
            return;
        }
        this.d = new HashMap(map);
        this.f = true;
        h();
    }

    String c() {
        W0 w0 = this.b.get("yandex_mobile_metrica_device_id");
        if (w0 == null) {
            return null;
        }
        return w0.a;
    }

    public C1217ra d() {
        return this.h;
    }

    long e() {
        return this.e;
    }

    public C0932fl f() {
        return this.g;
    }

    String g() {
        W0 w0 = this.b.get("yandex_mobile_metrica_uuid");
        if (w0 == null) {
            return null;
        }
        return w0.a;
    }

    private boolean b(W0 w0) {
        return w0 == null || TextUtils.isEmpty(w0.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    synchronized boolean b(java.util.List<java.lang.String> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.Collection r0 = com.yandex.metrica.impl.ob.C1128ni.a(r7)     // Catch: java.lang.Throwable -> L25
            boolean r0 = r6.a(r0)     // Catch: java.lang.Throwable -> L25
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L25
        Ld:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Throwable -> L25
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L27
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Throwable -> L25
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L25
            java.util.Set<java.lang.String> r4 = r6.a     // Catch: java.lang.Throwable -> L25
            boolean r1 = r4.contains(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto Ld
            r7 = r3
            goto L28
        L25:
            r7 = move-exception
            goto L4a
        L27:
            r7 = r2
        L28:
            long r4 = r6.i     // Catch: java.lang.Throwable -> L25
            boolean r1 = com.yandex.metrica.impl.ob.C1128ni.a(r4)     // Catch: java.lang.Throwable -> L25
            com.yandex.metrica.impl.ob.fl r4 = r6.g     // Catch: java.lang.Throwable -> L25
            if (r4 == 0) goto L3a
            boolean r4 = r4.a()     // Catch: java.lang.Throwable -> L25
            if (r4 == 0) goto L3a
            r4 = r3
            goto L3b
        L3a:
            r4 = r2
        L3b:
            if (r0 == 0) goto L47
            if (r7 != 0) goto L47
            if (r1 != 0) goto L47
            boolean r7 = r6.f     // Catch: java.lang.Throwable -> L25
            if (r7 != 0) goto L47
            if (r4 != 0) goto L48
        L47:
            r2 = r3
        L48:
            monitor-exit(r6)
            return r2
        L4a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L25
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1103mi.b(java.util.List):boolean");
    }

    C1103mi(C0820b9 c0820b9, Nh nh, Rh rh, C0880dj c0880dj, Th th, Wh wh, Vh vh) {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        this.b = new HashMap();
        this.j = new ArrayList();
        hashSet.add("yandex_mobile_metrica_google_adv_id");
        hashSet.add("yandex_mobile_metrica_huawei_oaid");
        hashSet.add("yandex_mobile_metrica_yandex_adv_id");
        this.k = c0820b9;
        this.l = rh;
        this.m = th;
        this.n = wh;
        a("yandex_mobile_metrica_uuid", c0880dj.a());
        a("yandex_mobile_metrica_device_id", c0820b9.l());
        a("appmetrica_device_id_hash", c0820b9.k());
        a("yandex_mobile_metrica_get_ad_url", c0820b9.f());
        a("yandex_mobile_metrica_report_ad_url", c0820b9.g());
        b(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, c0820b9.r());
        a("yandex_mobile_metrica_google_adv_id", c0820b9.o());
        a("yandex_mobile_metrica_huawei_oaid", c0820b9.p());
        a("yandex_mobile_metrica_yandex_adv_id", c0820b9.v());
        th.a(c0820b9.j());
        wh.a(c0820b9.n());
        this.c = c0820b9.i();
        String strK = c0820b9.k(null);
        this.d = strK != null ? Tl.a(strK) : null;
        this.f = c0820b9.b(true);
        this.e = c0820b9.d(0L);
        this.g = c0820b9.t();
        this.h = c0820b9.m();
        this.i = c0820b9.q();
        h();
    }

    public boolean a() {
        W0 w0 = this.b.get(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS);
        if (!a(w0) && w0.a.isEmpty()) {
            return A2.b(this.d);
        }
        return true;
    }

    List<String> b() {
        return this.c;
    }

    private void a(String str, W0 w0) {
        if (b(w0)) {
            return;
        }
        this.b.put(str, w0);
    }

    private boolean a(W0 w0) {
        return w0 == null || w0.a == null;
    }

    synchronized void a(List<String> list, Map<String, W0> map) {
        try {
            for (String str : list) {
                W0 w0 = this.b.get(str);
                if (w0 != null) {
                    map.put(str, w0);
                }
            }
            this.m.a(list, map);
            this.n.a(list, map);
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized boolean a(Collection<String> collection) {
        try {
            for (String str : collection) {
                W0 w0A = this.b.get(str);
                if (w0A == null) {
                    w0A = this.m.b().get(str);
                }
                if (w0A == null) {
                    w0A = this.n.a(str);
                }
                if (IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS.equals(str)) {
                    if (this.f || a(w0A) || (w0A.a.isEmpty() && !A2.b(this.d))) {
                        return false;
                    }
                } else if (IParamsCallback.YANDEX_MOBILE_METRICA_FEATURE_LIB_SSL_ENABLED.equals(str)) {
                    if (w0A == null) {
                        return false;
                    }
                } else if (b(w0A)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    void a(Bundle bundle) {
        HashMap<String, String> mapD;
        boolean zEquals;
        L l = new L(bundle);
        W0 w0O = l.o();
        if (b(this.b.get("yandex_mobile_metrica_uuid")) && !b(w0O) && !b(w0O)) {
            this.b.put("yandex_mobile_metrica_uuid", w0O);
        }
        W0 w0C = l.c();
        if (!b(w0C)) {
            this.b.put("yandex_mobile_metrica_device_id", w0C);
        }
        W0 w0D = l.d();
        if (!b(w0D)) {
            this.b.put("appmetrica_device_id_hash", w0D);
        }
        this.b.put("yandex_mobile_metrica_google_adv_id", l.g());
        this.b.put("yandex_mobile_metrica_huawei_oaid", l.i());
        this.b.put("yandex_mobile_metrica_yandex_adv_id", l.p());
        this.m.a(l.b());
        this.n.a(l.f());
        W0 w0H = l.h();
        if (!a(w0H)) {
            this.b.put("yandex_mobile_metrica_get_ad_url", w0H);
        }
        W0 w0K = l.k();
        if (!a(w0K)) {
            this.b.put("yandex_mobile_metrica_report_ad_url", w0K);
        }
        this.e = l.m();
        Rh rh = this.l;
        Map<String, String> map = this.d;
        String str = l.a().a;
        if (str == null) {
            mapD = null;
        } else if (str.isEmpty()) {
            mapD = new HashMap<>();
        } else {
            mapD = Tl.d(str);
        }
        rh.getClass();
        if (A2.b(map)) {
            zEquals = A2.b(mapD);
        } else {
            zEquals = map.equals(mapD);
        }
        if (zEquals) {
            this.b.put(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, l.l());
            this.f = false;
        }
        C0932fl c0932flN = l.n();
        if (c0932flN != null && c0932flN.a()) {
            this.g = c0932flN;
            Iterator<InterfaceC0957gl> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(this.g);
            }
        }
        this.h = l.e();
        this.i = l.j();
        h();
    }

    public synchronized void a(InterfaceC0957gl interfaceC0957gl) {
        this.j.add(interfaceC0957gl);
    }

    void a(List<String> list) {
        this.c = list;
        this.k.b(list);
    }
}
