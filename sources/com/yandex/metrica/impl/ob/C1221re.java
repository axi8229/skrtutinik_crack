package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.C1199qf;
import com.yandex.metrica.impl.ob.E;
import com.yandex.metrica.impl.ob.Tl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.re, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1221re {
    private static Map<D0, Integer> h;
    private static final C1221re i;
    private final InterfaceC1389ye a;
    private final Ge b;
    private final InterfaceC1149oe c;
    private final InterfaceC1245se d;
    private final InterfaceC1365xe e;
    private final InterfaceC1413ze f;
    private final C1269te g;

    /* renamed from: com.yandex.metrica.impl.ob.re$b */
    public static class b {
        private InterfaceC1389ye a;
        private Ge b;
        private InterfaceC1149oe c;
        private InterfaceC1245se d;
        private InterfaceC1365xe e;
        private InterfaceC1413ze f;
        private C1269te g;

        private b(C1221re c1221re) {
            this.a = c1221re.a;
            this.b = c1221re.b;
            this.c = c1221re.c;
            this.d = c1221re.d;
            this.e = c1221re.e;
            this.f = c1221re.f;
            this.g = c1221re.g;
        }

        public b a(InterfaceC1389ye interfaceC1389ye) {
            this.a = interfaceC1389ye;
            return this;
        }

        public b a(Ge ge) {
            this.b = ge;
            return this;
        }

        public b a(InterfaceC1149oe interfaceC1149oe) {
            this.c = interfaceC1149oe;
            return this;
        }

        public b a(InterfaceC1245se interfaceC1245se) {
            this.d = interfaceC1245se;
            return this;
        }

        public b a(InterfaceC1365xe interfaceC1365xe) {
            this.e = interfaceC1365xe;
            return this;
        }

        public b a(InterfaceC1413ze interfaceC1413ze) {
            this.f = interfaceC1413ze;
            return this;
        }

        public C1221re a() {
            return new C1221re(this);
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(D0.FIRST_OCCURRENCE, 1);
        map.put(D0.NON_FIRST_OCCURENCE, 0);
        map.put(D0.UNKNOWN, -1);
        h = Collections.unmodifiableMap(map);
        i = new C1221re(new De(), new Ee(), new Ae(), new Ce(), new C1293ue(), new C1317ve(), new C1269te());
    }

    private C1221re(b bVar) {
        this(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
    }

    public static C1221re b() {
        return i;
    }

    public C1199qf.d.a a(C1198qe c1198qe, Lg lg) {
        C1199qf.d.a.C0293a c0293a;
        int iA;
        C1199qf.d.a aVar = new C1199qf.d.a();
        C1199qf.d.a.c cVarA = this.f.a(c1198qe.o, c1198qe.p, c1198qe.i, c1198qe.h);
        C1199qf.b bVarA = this.e.a(c1198qe.g);
        String str = c1198qe.m;
        if (TextUtils.isEmpty(str)) {
            c0293a = null;
        } else {
            com.yandex.metrica.g gVarA = C0810b.a(str);
            c0293a = new C1199qf.d.a.C0293a();
            if (!TextUtils.isEmpty(gVarA.c())) {
                c0293a.a = gVarA.c();
            }
            if (!TextUtils.isEmpty(gVarA.b())) {
                c0293a.b = gVarA.b();
            }
            if (!A2.b(gVarA.a())) {
                c0293a.c = Tl.g(gVarA.a());
            }
        }
        if (cVarA != null) {
            aVar.g = cVarA;
        }
        if (bVarA != null) {
            aVar.f = bVarA;
        }
        String strA = this.a.a(c1198qe.a);
        if (strA != null) {
            aVar.d = strA;
        }
        aVar.e = this.b.a(c1198qe, lg);
        String str2 = c1198qe.l;
        if (str2 != null) {
            aVar.h = str2;
        }
        if (c0293a != null) {
            aVar.i = c0293a;
        }
        Integer numA = this.d.a(c1198qe);
        if (numA != null) {
            aVar.c = numA.intValue();
        }
        if (c1198qe.c != null) {
            aVar.a = r9.intValue();
        }
        if (c1198qe.d != null) {
            aVar.o = r9.intValue();
        }
        if (c1198qe.e != null) {
            aVar.p = r9.intValue();
        }
        Long l = c1198qe.f;
        if (l != null) {
            aVar.b = l.longValue();
        }
        Integer num = c1198qe.n;
        if (num != null) {
            aVar.j = num.intValue();
        }
        aVar.k = this.c.a(c1198qe.r);
        String str3 = c1198qe.g;
        if (str3 != null) {
            try {
                iA = new L6().a(Boolean.valueOf(new Tl.a(str3).getBoolean("enabled")));
            } catch (Throwable unused) {
            }
        } else {
            iA = -1;
        }
        aVar.l = iA;
        String str4 = c1198qe.q;
        if (str4 != null) {
            aVar.m = str4.getBytes();
        }
        D0 d0 = c1198qe.s;
        Integer num2 = d0 != null ? h.get(d0) : null;
        if (num2 != null) {
            aVar.n = num2.intValue();
        }
        E.b.a aVar2 = c1198qe.t;
        if (aVar2 != null) {
            aVar.q = J1.a(aVar2);
        }
        C1147oc.a aVar3 = c1198qe.u;
        int iA2 = aVar3 != null ? J1.a(aVar3) : 3;
        Integer num3 = c1198qe.v;
        if (num3 != null) {
            aVar.s = num3.intValue();
        }
        aVar.r = iA2;
        Integer num4 = c1198qe.w;
        aVar.t = num4 == null ? 0 : num4.intValue();
        EnumC1375y0 enumC1375y0 = c1198qe.x;
        if (enumC1375y0 != null) {
            aVar.u = enumC1375y0.a;
        }
        Boolean bool = c1198qe.y;
        if (bool != null) {
            aVar.v = bool.booleanValue();
        }
        if (c1198qe.z != null) {
            aVar.w = r9.intValue();
        }
        aVar.x = this.g.a(c1198qe.A);
        return aVar;
    }

    private C1221re(InterfaceC1389ye interfaceC1389ye, Ge ge, InterfaceC1149oe interfaceC1149oe, InterfaceC1245se interfaceC1245se, InterfaceC1365xe interfaceC1365xe, InterfaceC1413ze interfaceC1413ze, C1269te c1269te) {
        this.a = interfaceC1389ye;
        this.b = ge;
        this.c = interfaceC1149oe;
        this.d = interfaceC1245se;
        this.e = interfaceC1365xe;
        this.f = interfaceC1413ze;
        this.g = c1269te;
    }

    public static b a() {
        return new b();
    }
}
