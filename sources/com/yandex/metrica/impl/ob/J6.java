package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class J6 implements ProtobufConverter {
    private V6 a;

    public J6(V6 v6) {
        this.a = v6;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0876df fromModel(C1333w6 c1333w6) {
        C0876df c0876df = new C0876df();
        E6 e6 = c1333w6.a;
        if (e6 != null) {
            c0876df.a = this.a.fromModel(e6);
        }
        c0876df.b = new C1050kf[c1333w6.b.size()];
        Iterator<E6> it = c1333w6.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            c0876df.b[i] = this.a.fromModel(it.next());
            i++;
        }
        String str = c1333w6.c;
        if (str != null) {
            c0876df.c = str;
        }
        return c0876df;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
