package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class Q9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C0804ai c0804ai = (C0804ai) obj;
        If.n nVar = new If.n();
        nVar.a = c0804ai.a;
        nVar.b = c0804ai.b;
        return nVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        If.n nVar = (If.n) obj;
        return new C0804ai(nVar.a, nVar.b);
    }
}
