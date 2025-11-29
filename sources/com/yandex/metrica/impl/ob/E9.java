package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Sh;

/* loaded from: classes3.dex */
public class E9 implements ProtobufConverter {
    private final F1 a;

    public E9() {
        this(new C1078li());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.i fromModel(Sh sh) {
        If.i iVar = new If.i();
        iVar.d = sh.d;
        iVar.c = sh.c;
        iVar.b = sh.b;
        iVar.a = sh.a;
        iVar.j = sh.e;
        iVar.k = sh.f;
        iVar.e = sh.n;
        iVar.h = sh.r;
        iVar.i = sh.s;
        iVar.r = sh.o;
        iVar.f = sh.p;
        iVar.g = sh.q;
        iVar.m = sh.h;
        iVar.l = sh.g;
        iVar.n = sh.i;
        iVar.o = sh.j;
        iVar.p = sh.l;
        iVar.u = sh.m;
        iVar.q = sh.k;
        iVar.s = sh.t;
        iVar.t = sh.u;
        iVar.v = sh.v;
        iVar.w = sh.w;
        iVar.x = this.a.a(sh.x);
        return iVar;
    }

    E9(F1 f1) {
        this.a = f1;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Sh toModel(If.i iVar) {
        return new Sh(new Sh.a().d(iVar.a).p(iVar.i).c(iVar.h).q(iVar.r).w(iVar.g).v(iVar.f).g(iVar.e).f(iVar.d).o(iVar.j).j(iVar.k).n(iVar.c).m(iVar.b).k(iVar.m).l(iVar.l).h(iVar.n).t(iVar.o).s(iVar.p).u(iVar.u).r(iVar.q).a(iVar.s).b(iVar.t).i(iVar.v).e(iVar.w).a(this.a.a(iVar.x)));
    }
}
