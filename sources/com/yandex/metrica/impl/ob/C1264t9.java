package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* renamed from: com.yandex.metrica.impl.ob.t9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1264t9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0985i toModel(If.b bVar) {
        return new C0985i(bVar.a, bVar.b);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C0985i c0985i = (C0985i) obj;
        If.b bVar = new If.b();
        bVar.a = c0985i.a;
        bVar.b = c0985i.b;
        return bVar;
    }
}
