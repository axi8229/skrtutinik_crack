package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public final class Y9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1249si toModel(If.r rVar) {
        return new C1249si(rVar.a);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        If.r rVar = new If.r();
        rVar.a = ((C1249si) obj).a();
        return rVar;
    }
}
