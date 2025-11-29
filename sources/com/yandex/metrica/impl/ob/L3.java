package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.ob.C0817b6;
import com.yandex.metrica.impl.ob.C1230s;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.K3;
import com.yandex.metrica.impl.ob.Lg;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class L3 implements S3, P3, InterfaceC1171pb, Lg.d {
    private final Context a;
    private final I3 b;
    private final C0845c9 c;
    private final C0895e9 d;
    private final C0795a9 e;
    private final S1 f;
    private final L7 g;
    private final L4 h;
    private final I4 i;
    private final C1230s j;
    private final B3 k;
    private final C0817b6 l;
    private final Z3 m;
    private final M5 n;
    private final C0858cm o;
    private final Sl p;
    private final C0790a4 q;
    private final K3.b r;
    private final C1146ob s;
    private final C1071lb t;
    private final C1195qb u;
    private final H v;
    private final C1353x2 w;
    private final I1 x;
    private final C0819b8 y;
    private final C0967h6 z;

    class a implements C0817b6.a {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.C0817b6.a
        public void a(C0836c0 c0836c0, C0842c6 c0842c6) {
            L3.this.q.a(c0836c0, c0842c6);
        }
    }

    L3(Context context, I3 i3, B3 b3, C1353x2 c1353x2, M3 m3) {
        this.a = context.getApplicationContext();
        this.b = i3;
        this.k = b3;
        this.w = c1353x2;
        C0819b8 c0819b8E = m3.e();
        this.y = c0819b8E;
        this.x = F0.g().k();
        Z3 z3A = m3.a(this);
        this.m = z3A;
        C0858cm c0858cmB = m3.c().b();
        this.o = c0858cmB;
        Sl slA = m3.c().a();
        this.p = slA;
        C0845c9 c0845c9A = m3.d().a();
        this.c = c0845c9A;
        this.e = m3.d().b();
        this.d = F0.g().s();
        C1230s c1230sA = b3.a(i3, c0858cmB, c0845c9A);
        this.j = c1230sA;
        this.n = m3.a();
        L7 l7B = m3.b(this);
        this.g = l7B;
        S1<L3> s1E = m3.e(this);
        this.f = s1E;
        this.r = m3.d(this);
        C1195qb c1195qbA = m3.a(l7B, z3A);
        this.u = c1195qbA;
        C1071lb c1071lbA = m3.a(l7B);
        this.t = c1071lbA;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1195qbA);
        arrayList.add(c1071lbA);
        this.s = m3.a(arrayList, this);
        z();
        C0817b6 c0817b6A = m3.a(this, c0819b8E, new a());
        this.l = c0817b6A;
        if (slA.isEnabled()) {
            slA.fi("Read app environment for component %s. Value: %s", i3.toString(), c1230sA.a().a);
        }
        C0967h6 c0967h6B = m3.b();
        this.z = c0967h6B;
        this.q = m3.a(c0845c9A, c0819b8E, c0817b6A, l7B, c1230sA, c0967h6B, s1E);
        I4 i4C = m3.c(this);
        this.i = i4C;
        this.h = m3.a(this, i4C);
        this.v = m3.a(c0845c9A);
        l7B.e();
    }

    private void z() {
        int libraryApiLevel = YandexMetrica.getLibraryApiLevel();
        Integer numJ = this.c.j();
        if (numJ == null) {
            numJ = Integer.valueOf(this.y.c());
        }
        if (numJ.intValue() < libraryApiLevel) {
            this.r.a(new Id(new Jd(this.a, this.b.a()))).a();
            this.y.b(libraryApiLevel);
        }
    }

    public boolean A() {
        Lg lgM = m();
        return lgM.R() && lgM.x() && this.w.b(this.q.a(), lgM.K(), "need to check permissions");
    }

    public boolean B() {
        return this.q.d() && m().x();
    }

    public boolean C() {
        return this.q.c() && m().O() && m().x();
    }

    public void D() {
        this.m.e();
    }

    public boolean E() {
        Lg lgM = m();
        return lgM.R() && this.w.b(this.q.a(), lgM.L(), "should force send permissions");
    }

    public boolean F() {
        return !(this.x.b().d && this.m.d().N());
    }

    public void G() {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public synchronized void a(EnumC0954gi enumC0954gi, C1178pi c1178pi) {
    }

    public void b(C0836c0 c0836c0) {
        this.j.a(c0836c0.b());
        C1230s.a aVarA = this.j.a();
        B3 b3 = this.k;
        C0845c9 c0845c9 = this.c;
        synchronized (b3) {
            if (aVarA.b > c0845c9.f().b) {
                c0845c9.a(aVarA).d();
                if (this.o.isEnabled()) {
                    this.o.fi("Save new app environment for %s. Value: %s", this.b, aVarA.a);
                }
            }
        }
    }

    public synchronized void c() {
        this.f.d();
    }

    public H d() {
        return this.v;
    }

    public I3 e() {
        return this.b;
    }

    public C0845c9 f() {
        return this.c;
    }

    public Context g() {
        return this.a;
    }

    public String h() {
        return this.c.n();
    }

    public L7 i() {
        return this.g;
    }

    public M5 j() {
        return this.n;
    }

    protected I4 k() {
        return this.i;
    }

    public C1146ob l() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Lg m() {
        return (Lg) this.m.b();
    }

    @Deprecated
    public final Jd n() {
        return new Jd(this.a, this.b.a());
    }

    public C0795a9 o() {
        return this.e;
    }

    public String p() {
        return this.c.m();
    }

    public C0858cm q() {
        return this.o;
    }

    public C0790a4 r() {
        return this.q;
    }

    public CounterConfiguration.b s() {
        return CounterConfiguration.b.MANUAL;
    }

    public C0895e9 t() {
        return this.d;
    }

    public C0967h6 u() {
        return this.z;
    }

    public C0817b6 v() {
        return this.l;
    }

    public C1178pi w() {
        return this.m.d();
    }

    public C0819b8 x() {
        return this.y;
    }

    public void y() {
        this.q.b();
    }

    @Override // com.yandex.metrica.impl.ob.S3
    public void a(C0836c0 c0836c0) {
        if (this.o.isEnabled()) {
            C0858cm c0858cm = this.o;
            c0858cm.getClass();
            if (C1399z0.c(c0836c0.o())) {
                StringBuilder sb = new StringBuilder("Event received on service");
                sb.append(": ");
                sb.append(c0836c0.g());
                if (C1399z0.e(c0836c0.o()) && !TextUtils.isEmpty(c0836c0.q())) {
                    sb.append(" with value ");
                    sb.append(c0836c0.q());
                }
                c0858cm.i(sb.toString());
            }
        }
        String strA = this.b.a();
        if (TextUtils.isEmpty(strA) || "-1".equals(strA)) {
            return;
        }
        this.h.a(c0836c0);
    }

    public void b() {
        this.j.b();
        B3 b3 = this.k;
        C1230s.a aVarA = this.j.a();
        C0845c9 c0845c9 = this.c;
        synchronized (b3) {
            c0845c9.a(aVarA).d();
        }
    }

    public void b(String str) {
        this.c.i(str).d();
    }

    @Override // com.yandex.metrica.impl.ob.S3
    public synchronized void a(D3.a aVar) {
        try {
            Z3 z3 = this.m;
            synchronized (z3) {
                z3.a((Z3) aVar);
            }
            if (Boolean.TRUE.equals(aVar.k)) {
                this.o.setEnabled();
            } else {
                if (Boolean.FALSE.equals(aVar.k)) {
                    this.o.setDisabled();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public synchronized void a(C1178pi c1178pi) {
        this.m.a(c1178pi);
        this.g.b(c1178pi);
        this.s.c();
    }

    public void a(String str) {
        this.c.j(str).d();
    }
}
