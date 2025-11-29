package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* renamed from: com.yandex.metrica.impl.ob.w9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1336w9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.c fromModel(Ph ph) {
        If.c cVar = new If.c();
        cVar.a = ph.a;
        cVar.b = ph.b;
        cVar.c = ph.c;
        cVar.d = ph.d;
        return cVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Ph toModel(If.c cVar) {
        return new Ph(cVar.a, cVar.b, cVar.c, cVar.d);
    }
}
