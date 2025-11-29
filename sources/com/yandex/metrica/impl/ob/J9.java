package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class J9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Zh toModel(If.j jVar) {
        return new Zh(jVar.a);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        If.j jVar = new If.j();
        jVar.a = ((Zh) obj).a;
        return jVar;
    }
}
