package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.List;

/* loaded from: classes3.dex */
public class Ka implements Converter {
    private final C1033jn a;

    public Ka() {
        this(new C1033jn(20, 100));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.l[], Vm> fromModel(List<String> list) {
        C0959gn<List<String>, Xm> c0959gnA = this.a.a((List) list);
        List<String> list2 = c0959gnA.a;
        C1100mf.l[] lVarArr = new C1100mf.l[0];
        if (list2 != null) {
            lVarArr = new C1100mf.l[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C1100mf.l lVar = new C1100mf.l();
                lVarArr[i] = lVar;
                lVar.a = C0810b.b(list2.get(i));
            }
        }
        return new Na<>(lVarArr, c0959gnA.b);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ka(C1033jn c1033jn) {
        this.a = c1033jn;
    }
}
