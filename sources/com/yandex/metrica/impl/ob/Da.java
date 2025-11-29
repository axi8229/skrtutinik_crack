package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.util.List;

/* loaded from: classes3.dex */
public class Da implements Converter {
    private final C1033jn a;

    public Da() {
        this(new C1033jn(20, 100));
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Na<C1100mf.d, Vm> fromModel(List<String> list) {
        C0959gn<List<String>, Xm> c0959gnA = this.a.a((List) list);
        C1100mf.d dVar = new C1100mf.d();
        List<String> list2 = c0959gnA.a;
        byte[][] bArr = new byte[0][];
        if (list2 != null) {
            bArr = new byte[list2.size()][];
            for (int i = 0; i < list2.size(); i++) {
                bArr[i] = C0810b.b(list2.get(i));
            }
        }
        dVar.a = bArr;
        return new Na<>(dVar, c0959gnA.b);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Da(C1033jn c1033jn) {
        this.a = c1033jn;
    }
}
