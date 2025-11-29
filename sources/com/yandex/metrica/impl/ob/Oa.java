package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Oa implements Converter {
    private final Ha a;
    private final Da b;
    private final C1058kn c;
    private final C1058kn d;

    public Oa() {
        this(new Ha(), new Da(), new C1058kn(100), new C1058kn(1000));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.n, Vm> fromModel(C0822bb c0822bb) {
        Na<C1100mf.d, Vm> naFromModel;
        C1100mf.n nVar = new C1100mf.n();
        C0959gn<String, Vm> c0959gnA = this.c.a(c0822bb.a);
        nVar.a = C0810b.b(c0959gnA.a);
        List<String> list = c0822bb.b;
        Na<C1100mf.i, Vm> naFromModel2 = null;
        if (list != null) {
            naFromModel = this.b.fromModel(list);
            nVar.b = naFromModel.a;
        } else {
            naFromModel = null;
        }
        C0959gn<String, Vm> c0959gnA2 = this.d.a(c0822bb.c);
        nVar.c = C0810b.b(c0959gnA2.a);
        Map<String, String> map = c0822bb.d;
        if (map != null) {
            naFromModel2 = this.a.fromModel(map);
            nVar.d = naFromModel2.a;
        }
        return new Na<>(nVar, Um.a(c0959gnA, naFromModel, c0959gnA2, naFromModel2));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Oa(Ha ha, Da da, C1058kn c1058kn, C1058kn c1058kn2) {
        this.a = ha;
        this.b = da;
        this.c = c1058kn;
        this.d = c1058kn2;
    }
}
