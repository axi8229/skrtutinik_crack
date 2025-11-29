package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class U9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.p fromModel(C0854ci c0854ci) {
        If.p pVar = new If.p();
        pVar.a = c0854ci.a;
        pVar.b = c0854ci.b;
        pVar.c = c0854ci.c;
        pVar.d = c0854ci.d;
        return pVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0854ci toModel(If.p pVar) {
        return new C0854ci(pVar.a, pVar.b, pVar.c, pVar.d);
    }
}
