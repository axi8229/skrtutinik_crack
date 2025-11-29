package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ja implements Converter {
    private final Ha a;
    private final Ia b;
    private final Da c;
    private final Ka d;
    private final C1058kn e;
    private final C1058kn f;

    public Ja() {
        this(new Ha(), new Ia(), new Da(), new Ka(), new C1058kn(100), new C1058kn(1000));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.k, Vm> fromModel(Ya ya) {
        Na<C1100mf.d, Vm> naFromModel;
        Na<C1100mf.i, Vm> naFromModel2;
        Na<C1100mf.j, Vm> naFromModel3;
        Na<C1100mf.j, Vm> naFromModel4;
        C1100mf.k kVar = new C1100mf.k();
        C0959gn<String, Vm> c0959gnA = this.e.a(ya.a);
        kVar.a = C0810b.b(c0959gnA.a);
        C0959gn<String, Vm> c0959gnA2 = this.f.a(ya.b);
        kVar.b = C0810b.b(c0959gnA2.a);
        List<String> list = ya.c;
        Na<C1100mf.l[], Vm> naFromModel5 = null;
        if (list != null) {
            naFromModel = this.c.fromModel(list);
            kVar.c = naFromModel.a;
        } else {
            naFromModel = null;
        }
        Map<String, String> map = ya.d;
        if (map != null) {
            naFromModel2 = this.a.fromModel(map);
            kVar.d = naFromModel2.a;
        } else {
            naFromModel2 = null;
        }
        Xa xa = ya.e;
        if (xa != null) {
            naFromModel3 = this.b.fromModel(xa);
            kVar.e = naFromModel3.a;
        } else {
            naFromModel3 = null;
        }
        Xa xa2 = ya.f;
        if (xa2 != null) {
            naFromModel4 = this.b.fromModel(xa2);
            kVar.f = naFromModel4.a;
        } else {
            naFromModel4 = null;
        }
        List<String> list2 = ya.g;
        if (list2 != null) {
            naFromModel5 = this.d.fromModel(list2);
            kVar.g = naFromModel5.a;
        }
        return new Na<>(kVar, Um.a(c0959gnA, c0959gnA2, naFromModel, naFromModel2, naFromModel3, naFromModel4, naFromModel5));
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Ja(Ha ha, Ia ia, Da da, Ka ka, C1058kn c1058kn, C1058kn c1058kn2) {
        this.a = ha;
        this.b = ia;
        this.c = da;
        this.d = ka;
        this.e = c1058kn;
        this.f = c1058kn2;
    }
}
