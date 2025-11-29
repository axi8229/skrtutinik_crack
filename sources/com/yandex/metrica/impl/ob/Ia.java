package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.List;

/* loaded from: classes3.dex */
public class Ia implements Converter {
    private final Aa a;
    private final C0922fb b;

    public Ia() {
        this(new Aa(), new C0922fb(30));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.j, Vm> fromModel(Xa xa) {
        int iA;
        C1100mf.j jVar = new C1100mf.j();
        Na<C1100mf.a, Vm> naFromModel = this.a.fromModel(xa.a);
        jVar.a = naFromModel.a;
        C0959gn<List<Sa>, Xm> c0959gnA = this.b.a((List) xa.b);
        if (A2.b(c0959gnA.a)) {
            iA = 0;
        } else {
            jVar.b = new C1100mf.a[c0959gnA.a.size()];
            iA = 0;
            for (int i = 0; i < c0959gnA.a.size(); i++) {
                Na<C1100mf.a, Vm> naFromModel2 = this.a.fromModel(c0959gnA.a.get(i));
                jVar.b[i] = naFromModel2.a;
                iA += naFromModel2.b.a();
            }
        }
        return new Na<>(jVar, Um.a(naFromModel, c0959gnA, new Um(iA)));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ia(Aa aa, C0922fb c0922fb) {
        this.a = aa;
        this.b = c0922fb;
    }
}
