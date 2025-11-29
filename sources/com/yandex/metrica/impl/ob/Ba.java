package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1100mf;
import java.util.Collections;

/* loaded from: classes3.dex */
public class Ba implements Fa {
    private final Ca a;

    public Ba() {
        this(new Ca());
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Ta ta = (Ta) obj;
        C1100mf c1100mf = new C1100mf();
        c1100mf.e = new C1100mf.b();
        Na<C1100mf.c, Vm> naFromModel = this.a.fromModel(ta.c);
        c1100mf.e.a = naFromModel.a;
        c1100mf.a = ta.b;
        return Collections.singletonList(new Na(c1100mf, Um.a(naFromModel)));
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ba(Ca ca) {
        this.a = ca;
    }
}
