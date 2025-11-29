package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.IParamsCallback;
import com.yandex.metrica.impl.ob.ResultReceiverC0911f0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.yandex.metrica.impl.ob.hi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0979hi implements InterfaceC1028ji, Q0 {
    static final Map<EnumC0954gi, IParamsCallback.Reason> j = Collections.unmodifiableMap(new a());
    private final List<String> a;
    private final T1 b;
    private final C1103mi c;
    private final Handler d;
    private C0858cm e;
    private final ResultReceiverC0911f0.a f;
    private final Object g;
    private final Map<Yh, List<String>> h;
    private Map<String, String> i;

    /* renamed from: com.yandex.metrica.impl.ob.hi$a */
    class a extends HashMap<EnumC0954gi, IParamsCallback.Reason> {
        a() {
            put(EnumC0954gi.UNKNOWN, IParamsCallback.Reason.UNKNOWN);
            put(EnumC0954gi.NETWORK, IParamsCallback.Reason.NETWORK);
            put(EnumC0954gi.PARSE, IParamsCallback.Reason.INVALID_RESPONSE);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.hi$b */
    class b implements ResultReceiverC0911f0.a {
        b(C0979hi c0979hi) {
        }

        @Override // com.yandex.metrica.impl.ob.ResultReceiverC0911f0.a
        public void a(int i, Bundle bundle) {
        }
    }

    public C0979hi(Context context, T1 t1, C0820b9 c0820b9, Handler handler) {
        this(t1, new C1103mi(context, c0820b9), handler);
    }

    private void f() {
        WeakHashMap weakHashMap = new WeakHashMap();
        for (Map.Entry<Yh, List<String>> entry : this.h.entrySet()) {
            List<String> value = entry.getValue();
            if (this.c.a((Collection<String>) value)) {
                weakHashMap.put(entry.getKey(), value);
            }
        }
        Iterator it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Yh yh = (Yh) ((Map.Entry) it.next()).getKey();
            if (yh != null) {
                a(yh, new Bundle());
            }
        }
        weakHashMap.clear();
    }

    @Override // com.yandex.metrica.impl.ob.Q0
    public long a() {
        return this.c.e();
    }

    public String b() {
        return this.c.c();
    }

    public C1217ra c() {
        return this.c.d();
    }

    public C0932fl d() {
        return this.c.f();
    }

    public String e() {
        return this.c.g();
    }

    public void g() {
        boolean zB;
        synchronized (this.g) {
            try {
                C1103mi c1103mi = this.c;
                synchronized (c1103mi) {
                    zB = c1103mi.b(Arrays.asList(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS, "appmetrica_device_id_hash", "yandex_mobile_metrica_device_id", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url", "yandex_mobile_metrica_uuid"));
                }
                if (zB) {
                    Map<String, String> map = this.i;
                    this.b.a(this.a, new ResultReceiverC0911f0(this.d, this.f), map);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    C0979hi(T1 t1, C1103mi c1103mi, Handler handler) {
        this.a = Arrays.asList("yandex_mobile_metrica_uuid", "yandex_mobile_metrica_device_id", "appmetrica_device_id_hash", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url", IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS);
        this.g = new Object();
        this.h = new WeakHashMap();
        this.b = t1;
        this.c = c1103mi;
        this.d = handler;
        this.f = new b(this);
    }

    public void a(IIdentifierCallback iIdentifierCallback, List<String> list, Map<String, String> map) {
        Qh qh = new Qh(iIdentifierCallback);
        synchronized (this.g) {
            try {
                this.c.a(map);
                if (this.h.isEmpty()) {
                    this.b.g();
                }
                this.h.put(qh, list);
                if (this.c.b(list)) {
                    this.b.a(list, new ResultReceiverC0911f0(this.d, new C1003ii(this, qh)), map);
                } else {
                    a(qh, new Bundle());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(String str) {
        synchronized (this.g) {
            this.b.b(str);
        }
    }

    public void a(Bundle bundle, Yh yh) {
        synchronized (this.g) {
            try {
                this.c.a(bundle);
                f();
                f();
                if (yh != null) {
                    a(yh, bundle);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(C0858cm c0858cm) {
        this.e = c0858cm;
    }

    public void a(List<String> list) {
        synchronized (this.g) {
            try {
                List<String> listB = this.c.b();
                if (A2.b(list)) {
                    if (!A2.b(listB)) {
                        this.c.a((List<String>) null);
                        this.b.a((List<String>) null);
                    }
                } else if (!A2.a(list, listB)) {
                    this.c.a(list);
                    this.b.a(list);
                } else {
                    this.b.a(listB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Map<String, String> map) {
        if (A2.b(map)) {
            return;
        }
        synchronized (this.g) {
            Map<String, String> mapI = Tl.i(map);
            this.i = mapI;
            this.b.a(mapI);
            this.c.a(mapI);
        }
    }

    public void a(String str) {
        synchronized (this.g) {
            this.b.a(str);
        }
    }

    public void a(InterfaceC0957gl interfaceC0957gl) {
        this.c.a(interfaceC0957gl);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.yandex.metrica.impl.ob.Yh r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.util.Map<com.yandex.metrica.impl.ob.Yh, java.util.List<java.lang.String>> r0 = r5.h
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L98
            java.util.Map<com.yandex.metrica.impl.ob.Yh, java.util.List<java.lang.String>> r0 = r5.h
            java.lang.Object r0 = r0.get(r6)
            java.util.List r0 = (java.util.List) r0
            com.yandex.metrica.impl.ob.mi r1 = r5.c
            boolean r1 = r1.a(r0)
            r2 = 0
            if (r1 == 0) goto L2a
            if (r0 != 0) goto L1c
            goto L26
        L1c:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.yandex.metrica.impl.ob.mi r7 = r5.c
            r7.a(r0, r2)
        L26:
            r6.onReceive(r2)
            goto L86
        L2a:
            java.lang.String r1 = "startup_error_key_code"
            boolean r3 = r7.containsKey(r1)
            if (r3 == 0) goto L45
            int r7 = r7.getInt(r1)
            com.yandex.metrica.impl.ob.gi r1 = com.yandex.metrica.impl.ob.EnumC0954gi.UNKNOWN
            r3 = 1
            if (r7 == r3) goto L42
            r3 = 2
            if (r7 == r3) goto L3f
            goto L46
        L3f:
            com.yandex.metrica.impl.ob.gi r1 = com.yandex.metrica.impl.ob.EnumC0954gi.PARSE
            goto L46
        L42:
            com.yandex.metrica.impl.ob.gi r1 = com.yandex.metrica.impl.ob.EnumC0954gi.NETWORK
            goto L46
        L45:
            r1 = r2
        L46:
            if (r1 != 0) goto L64
            com.yandex.metrica.impl.ob.mi r7 = r5.c
            boolean r7 = r7.a()
            if (r7 != 0) goto L62
            com.yandex.metrica.impl.ob.cm r7 = r5.e
            if (r7 == 0) goto L5f
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.i
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "Clids error. Passed clids: %s, and clids from server are empty."
            r7.fw(r4, r3)
        L5f:
            com.yandex.metrica.IParamsCallback$Reason r7 = com.yandex.metrica.IParamsCallback.Reason.INCONSISTENT_CLIDS
            goto L65
        L62:
            com.yandex.metrica.impl.ob.gi r1 = com.yandex.metrica.impl.ob.EnumC0954gi.UNKNOWN
        L64:
            r7 = r2
        L65:
            if (r7 != 0) goto L76
            java.util.Map<com.yandex.metrica.impl.ob.gi, com.yandex.metrica.IParamsCallback$Reason> r7 = com.yandex.metrica.impl.ob.C0979hi.j
            com.yandex.metrica.IParamsCallback$Reason r3 = com.yandex.metrica.IParamsCallback.Reason.UNKNOWN
            java.lang.Object r7 = r7.get(r1)
            if (r7 != 0) goto L72
            goto L73
        L72:
            r3 = r7
        L73:
            r7 = r3
            com.yandex.metrica.IParamsCallback$Reason r7 = (com.yandex.metrica.IParamsCallback.Reason) r7
        L76:
            if (r0 != 0) goto L79
            goto L83
        L79:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.yandex.metrica.impl.ob.mi r1 = r5.c
            r1.a(r0, r2)
        L83:
            r6.a(r7, r2)
        L86:
            java.util.Map<com.yandex.metrica.impl.ob.Yh, java.util.List<java.lang.String>> r7 = r5.h
            r7.remove(r6)
            java.util.Map<com.yandex.metrica.impl.ob.Yh, java.util.List<java.lang.String>> r6 = r5.h
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L98
            com.yandex.metrica.impl.ob.T1 r6 = r5.b
            r6.f()
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C0979hi.a(com.yandex.metrica.impl.ob.Yh, android.os.Bundle):void");
    }
}
