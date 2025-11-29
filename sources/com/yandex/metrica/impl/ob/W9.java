package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class W9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.q fromModel(C0879di c0879di) {
        If.q qVar = new If.q();
        qVar.a = c0879di.a;
        qVar.b = c0879di.b;
        qVar.d = C0810b.a(c0879di.c);
        qVar.c = C0810b.a(c0879di.d);
        qVar.e = c0879di.e;
        qVar.f = c0879di.f;
        qVar.g = c0879di.g;
        qVar.h = c0879di.h;
        qVar.i = c0879di.i;
        qVar.j = c0879di.j;
        return qVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0879di toModel(If.q qVar) {
        return new C0879di(qVar.a, qVar.b, C0810b.a(qVar.d), C0810b.a(qVar.c), qVar.e, qVar.f, qVar.g, qVar.h, qVar.i, qVar.j);
    }
}
