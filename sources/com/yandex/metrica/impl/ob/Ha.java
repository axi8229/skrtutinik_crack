package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ha implements Converter {
    private final C1083ln a;

    public Ha() {
        this(new C1083ln(20480, 100, 1000));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.i, Vm> fromModel(Map<String, String> map) {
        C0959gn<Map<String, String>, Xm> c0959gnA = this.a.a(map);
        C1100mf.i iVar = new C1100mf.i();
        iVar.b = ((Xm) c0959gnA.b).b;
        Map<String, String> map2 = c0959gnA.a;
        if (map2 != null) {
            iVar.a = new C1100mf.i.a[map2.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                iVar.a[i] = new C1100mf.i.a();
                iVar.a[i].a = C0810b.b(entry.getKey());
                iVar.a[i].b = C0810b.b(entry.getValue());
                i++;
            }
        }
        return new Na<>(iVar, c0959gnA.b);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ha(C1083ln c1083ln) {
        this.a = c1083ln;
    }
}
