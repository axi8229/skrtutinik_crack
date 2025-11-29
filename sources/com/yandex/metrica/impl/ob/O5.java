package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.Iterator;

/* loaded from: classes3.dex */
class O5 implements ProtobufConverter {
    O5() {
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Af fromModel(N5 n5) {
        Af af = new Af();
        af.d = new int[n5.b().size()];
        Iterator<Integer> it = n5.b().iterator();
        int i = 0;
        while (it.hasNext()) {
            af.d[i] = it.next().intValue();
            i++;
        }
        af.c = n5.c();
        af.b = n5.d();
        af.a = n5.e();
        return af;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public N5 toModel(Af af) {
        return new N5(af.a, af.b, af.c, A2.a(af.d));
    }
}
