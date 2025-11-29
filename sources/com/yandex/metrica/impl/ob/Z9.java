package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class Z9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1273ti toModel(If.s sVar) {
        return new C1273ti(sVar.a);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        If.s sVar = new If.s();
        sVar.a = ((C1273ti) obj).a;
        return sVar;
    }
}
