package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;

/* loaded from: classes3.dex */
public class Aa implements Converter {
    private final Ea a;
    private final C1058kn b;

    public Aa() {
        this(new Ea(), new C1058kn(20));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.a, Vm> fromModel(Sa sa) {
        C1100mf.a aVar = new C1100mf.a();
        aVar.b = this.a.fromModel(sa.a);
        C0959gn<String, Vm> c0959gnA = this.b.a(sa.b);
        aVar.a = C0810b.b(c0959gnA.a);
        return new Na<>(aVar, Um.a(c0959gnA));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Aa(Ea ea, C1058kn c1058kn) {
        this.a = ea;
        this.b = c1058kn;
    }
}
