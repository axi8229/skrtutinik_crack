package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.C1178pi;
import com.yandex.metrica.impl.ob.C1326w;
import com.yandex.metrica.impl.ob.E;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.qc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1196qc implements E.c, C1326w.b {
    private List<C1147oc> a;
    private final E b;
    private final C1315vc c;
    private final C1326w d;
    private volatile C1097mc e;
    private final Set<InterfaceC1122nc> f;
    private final Object g;

    public C1196qc(Context context) {
        this(F0.g().c(), C1315vc.a(context), new C1178pi.b(context), F0.g().b());
    }

    private void d() {
        C1097mc c1097mcA = a();
        if (A2.a(this.e, c1097mcA)) {
            return;
        }
        this.c.a(c1097mcA);
        this.e = c1097mcA;
        C1097mc c1097mc = this.e;
        Iterator<InterfaceC1122nc> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a(c1097mc);
        }
    }

    public synchronized void a(InterfaceC1122nc interfaceC1122nc) {
        this.f.add(interfaceC1122nc);
    }

    public void b() {
        synchronized (this.g) {
            this.b.a(this);
            this.d.a(this);
        }
    }

    public synchronized void c() {
        d();
    }

    public synchronized void a(C1178pi c1178pi) {
        this.a = c1178pi.w();
        this.e = a();
        this.c.a(c1178pi, this.e);
        C1097mc c1097mc = this.e;
        Iterator<InterfaceC1122nc> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a(c1097mc);
        }
    }

    C1196qc(E e, C1315vc c1315vc, C1178pi.b bVar, C1326w c1326w) {
        this.f = new HashSet();
        this.g = new Object();
        this.b = e;
        this.c = c1315vc;
        this.d = c1326w;
        this.a = bVar.a().w();
    }

    @Override // com.yandex.metrica.impl.ob.C1326w.b
    public synchronized void a(C1326w.a aVar) {
        d();
    }

    @Override // com.yandex.metrica.impl.ob.E.c
    public synchronized void a(E.b.a aVar) {
        d();
    }

    private C1097mc a() {
        C1326w.a aVarC = this.d.c();
        E.b.a aVarB = this.b.b();
        for (C1147oc c1147oc : this.a) {
            if (c1147oc.b.a.contains(aVarB) && c1147oc.b.b.contains(aVarC)) {
                return c1147oc.a;
            }
        }
        return null;
    }
}
