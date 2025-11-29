package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C0790a4;
import com.yandex.metrica.impl.ob.C0817b6;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.K3;
import com.yandex.metrica.impl.ob.Lg;
import java.util.List;

/* loaded from: classes3.dex */
class M3 {
    private final b a;
    private final c b;
    protected final Context c;
    private final I3 d;
    private final D3.a e;
    private final AbstractC1321vi f;
    protected final C1178pi g;
    private final Lg.e h;
    private final Dm i;
    private final ICommonExecutor j;
    private final C0912f1 k;
    private final int l;

    class a implements C0790a4.a {
        final /* synthetic */ S1 a;

        a(M3 m3, S1 s1) {
            this.a = s1;
        }
    }

    static class b {
        private final String a;

        b(String str) {
            this.a = str;
        }

        Sl a() {
            return Ul.a(this.a);
        }

        C0858cm b() {
            return Ul.b(this.a);
        }
    }

    static class c {
        private final I3 a;
        private final C1020ja b;

        c(Context context, I3 i3) {
            this(i3, C1020ja.a(context));
        }

        C0845c9 a() {
            return new C0845c9(this.b.b(this.a));
        }

        C0795a9 b() {
            return new C0795a9(this.b.b(this.a));
        }

        c(I3 i3, C1020ja c1020ja) {
            this.a = i3;
            this.b = c1020ja;
        }
    }

    M3(Context context, I3 i3, D3.a aVar, AbstractC1321vi abstractC1321vi, C1178pi c1178pi, Lg.e eVar, ICommonExecutor iCommonExecutor, int i, C0912f1 c0912f1) {
        this(context, i3, aVar, abstractC1321vi, c1178pi, eVar, iCommonExecutor, new Dm(), i, new b(aVar.d), new c(context, i3), c0912f1);
    }

    M5 a() {
        return new M5(this.c, this.d, this.l);
    }

    L7 b(L3 l3) {
        return new L7(l3, C1020ja.a(this.c).c(this.d), new K7(l3.s()));
    }

    b c() {
        return this.a;
    }

    c d() {
        return this.b;
    }

    S1<L3> e(L3 l3) {
        S1<L3> s1 = new S1<>(l3, this.f.a(), this.j);
        this.k.a(s1);
        return s1;
    }

    M3(Context context, I3 i3, D3.a aVar, AbstractC1321vi abstractC1321vi, C1178pi c1178pi, Lg.e eVar, ICommonExecutor iCommonExecutor, Dm dm, int i, b bVar, c cVar, C0912f1 c0912f1) {
        this.c = context;
        this.d = i3;
        this.e = aVar;
        this.f = abstractC1321vi;
        this.g = c1178pi;
        this.h = eVar;
        this.j = iCommonExecutor;
        this.i = dm;
        this.l = i;
        this.a = bVar;
        this.b = cVar;
        this.k = c0912f1;
    }

    Z3 a(L3 l3) {
        return new Z3(new Lg.c(l3, this.h), this.g, new Lg.a(this.e));
    }

    I4 c(L3 l3) {
        return new I4(l3);
    }

    K3.b d(L3 l3) {
        return new K3.b(l3);
    }

    C0817b6 a(L3 l3, C0819b8 c0819b8, C0817b6.a aVar) {
        return new C0817b6(l3, new C0792a6(c0819b8), aVar);
    }

    C0790a4 a(C0845c9 c0845c9, C0819b8 c0819b8, C0817b6 c0817b6, L7 l7, C1230s c1230s, C0967h6 c0967h6, S1 s1) {
        return new C0790a4(c0845c9, c0819b8, c0817b6, l7, c1230s, this.i, c0967h6, this.l, new a(this, s1), new O3(c0819b8, new Y8(c0819b8)), new SystemTimeProvider());
    }

    C0967h6 b() {
        return new C0967h6(this.c, this.d);
    }

    C0819b8 e() {
        return F0.g().w().a(this.d);
    }

    L4<X4, L3> a(L3 l3, I4 i4) {
        return new L4<>(i4, l3);
    }

    C1071lb a(L7 l7) {
        return new C1071lb(l7);
    }

    C1195qb a(L7 l7, Z3 z3) {
        return new C1195qb(l7, z3);
    }

    C1146ob a(List<InterfaceC1096mb> list, InterfaceC1171pb interfaceC1171pb) {
        return new C1146ob(list, interfaceC1171pb);
    }

    H a(C0845c9 c0845c9) {
        return new H(this.c, c0845c9);
    }
}
