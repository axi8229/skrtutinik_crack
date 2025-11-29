package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ListConverter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class T6 implements ListConverter {
    private U6 a = new U6();

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1025jf[] fromModel(List<D6> list) {
        C1025jf[] c1025jfArr = new C1025jf[list.size()];
        Iterator<D6> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            c1025jfArr[i] = this.a.fromModel(it.next());
            i++;
        }
        return c1025jfArr;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
