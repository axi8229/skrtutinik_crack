package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1100mf;
import java.util.Collections;

/* loaded from: classes3.dex */
public class Pa implements Fa {
    private final Oa a;
    private final Ja b;

    public Pa() {
        this(new Oa(), new Ja());
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C0847cb c0847cb = (C0847cb) obj;
        C1100mf c1100mf = new C1100mf();
        c1100mf.a = 2;
        c1100mf.c = new C1100mf.o();
        Na<C1100mf.n, Vm> naFromModel = this.a.fromModel(c0847cb.c);
        c1100mf.c.b = naFromModel.a;
        Na<C1100mf.k, Vm> naFromModel2 = this.b.fromModel(c0847cb.b);
        c1100mf.c.a = naFromModel2.a;
        return Collections.singletonList(new Na(c1100mf, Um.a(naFromModel, naFromModel2)));
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Pa(Oa oa, Ja ja) {
        this.a = oa;
        this.b = ja;
    }
}
