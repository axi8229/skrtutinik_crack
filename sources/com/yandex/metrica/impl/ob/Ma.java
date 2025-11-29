package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;

/* loaded from: classes3.dex */
public class Ma implements Converter {
    private final Oa a;
    private final C1058kn b;
    private final C1058kn c;

    public Ma() {
        this(new Oa(), new C1058kn(100), new C1058kn(2048));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.m, Vm> fromModel(C0797ab c0797ab) {
        Na<C1100mf.n, Vm> naFromModel;
        C1100mf.m mVar = new C1100mf.m();
        C0959gn<String, Vm> c0959gnA = this.b.a(c0797ab.a);
        mVar.a = C0810b.b(c0959gnA.a);
        C0959gn<String, Vm> c0959gnA2 = this.c.a(c0797ab.b);
        mVar.b = C0810b.b(c0959gnA2.a);
        C0822bb c0822bb = c0797ab.c;
        if (c0822bb != null) {
            naFromModel = this.a.fromModel(c0822bb);
            mVar.c = naFromModel.a;
        } else {
            naFromModel = null;
        }
        return new Na<>(mVar, Um.a(c0959gnA, c0959gnA2, naFromModel));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ma(Oa oa, C1058kn c1058kn, C1058kn c1058kn2) {
        this.a = oa;
        this.b = c1058kn;
        this.c = c1058kn2;
    }
}
