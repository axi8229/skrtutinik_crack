package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* renamed from: com.yandex.metrica.impl.ob.z9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1408z9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1194qa toModel(If.e eVar) {
        return new C1194qa(eVar.a, eVar.b);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C1194qa c1194qa = (C1194qa) obj;
        If.e eVar = new If.e();
        eVar.a = c1194qa.a;
        eVar.b = c1194qa.b;
        return eVar;
    }
}
