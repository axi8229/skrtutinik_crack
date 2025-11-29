package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1100mf;
import java.util.Collections;

/* loaded from: classes3.dex */
public class Ra implements Fa {
    private final Oa a;

    public Ra() {
        this(new Oa());
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C1100mf c1100mf = new C1100mf();
        c1100mf.a = 1;
        c1100mf.b = new C1100mf.q();
        Na<C1100mf.n, Vm> naFromModel = this.a.fromModel(((C0897eb) obj).b);
        c1100mf.b.a = naFromModel.a;
        return Collections.singletonList(new Na(c1100mf, Um.a(naFromModel)));
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ra(Oa oa) {
        this.a = oa;
    }
}
