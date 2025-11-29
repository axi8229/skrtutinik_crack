package com.yandex.metrica.impl.ob;

import android.location.Location;
import com.yandex.metrica.impl.ob.H0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Bc implements J0 {
    private Pc a;
    private Cc b;
    private final List<Ec<?>> c;
    private final InterfaceC1172pc<Xb> d;
    private final InterfaceC1172pc<Xb> e;
    private final InterfaceC1172pc<Xb> f;
    private final InterfaceC1172pc<C0848cc> g;
    private final H0 h;
    private boolean i;

    public Bc(Cc cc, Pc pc) {
        this(cc, pc, F0.g().s());
    }

    @Override // com.yandex.metrica.impl.ob.J0
    public void a() {
        if (this.i) {
            Iterator<Ec<?>> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    public Location b() {
        if (this.i) {
            return this.a.a();
        }
        return null;
    }

    public void c() {
        if (this.i) {
            this.h.c();
            Iterator<Ec<?>> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void d() {
        this.h.d();
        Iterator<Ec<?>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private Bc(Cc cc, Pc pc, C0895e9 c0895e9) {
        this(cc, pc, new C0923fc(cc, c0895e9), new C1047kc(cc, c0895e9), new Lc(cc), new C0898ec(cc, c0895e9, pc), new H0.c());
    }

    Bc(Cc cc, Pc pc, Pb pb, Pb pb2, Lc lc, C0898ec c0898ec, H0.c cVar) {
        Xb xb;
        C0848cc c0848cc;
        Xb xb2;
        Xb xb3;
        this.b = cc;
        C1097mc c1097mc = cc.c;
        if (c1097mc != null) {
            this.i = c1097mc.g;
            xb = c1097mc.n;
            xb2 = c1097mc.o;
            xb3 = c1097mc.p;
            c0848cc = c1097mc.q;
        } else {
            xb = null;
            c0848cc = null;
            xb2 = null;
            xb3 = null;
        }
        this.a = pc;
        Ec<Xb> ecA = pb.a(pc, xb2);
        Ec<Xb> ecA2 = pb2.a(pc, xb);
        Ec<Xb> ecA3 = lc.a(pc, xb3);
        Ec<C0848cc> ecA4 = c0898ec.a(c0848cc);
        this.c = Arrays.asList(ecA, ecA2, ecA3, ecA4);
        this.d = ecA2;
        this.e = ecA;
        this.f = ecA3;
        this.g = ecA4;
        H0 h0A = cVar.a(this.b.a.b, this, this.a.b());
        this.h = h0A;
        this.a.b().a(h0A);
    }

    public void a(C1178pi c1178pi) {
        this.a.a(c1178pi);
    }

    public void a(C1097mc c1097mc) {
        this.i = c1097mc != null && c1097mc.g;
        this.a.a(c1097mc);
        ((Ec) this.d).a(c1097mc == null ? null : c1097mc.n);
        ((Ec) this.e).a(c1097mc == null ? null : c1097mc.o);
        ((Ec) this.f).a(c1097mc == null ? null : c1097mc.p);
        ((Ec) this.g).a(c1097mc != null ? c1097mc.q : null);
        a();
    }
}
