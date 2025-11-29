package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;

/* loaded from: classes3.dex */
public class Ca implements Converter {
    private final Ja a;
    private final Ea b;
    private final Ia c;
    private final Ma d;

    public Ca() {
        this(new Ja(), new Ea(), new Ia(), new Ma());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.c, Vm> fromModel(Ua ua) {
        Na<C1100mf.m, Vm> naFromModel;
        C1100mf.c cVar = new C1100mf.c();
        Na<C1100mf.k, Vm> naFromModel2 = this.a.fromModel(ua.a);
        cVar.a = naFromModel2.a;
        cVar.c = this.b.fromModel(ua.b);
        Na<C1100mf.j, Vm> naFromModel3 = this.c.fromModel(ua.c);
        cVar.d = naFromModel3.a;
        C0797ab c0797ab = ua.d;
        if (c0797ab != null) {
            naFromModel = this.d.fromModel(c0797ab);
            cVar.b = naFromModel.a;
        } else {
            naFromModel = null;
        }
        return new Na<>(cVar, Um.a(naFromModel2, naFromModel3, naFromModel));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ca(Ja ja, Ea ea, Ia ia, Ma ma) {
        this.a = ja;
        this.b = ea;
        this.c = ia;
        this.d = ma;
    }
}
