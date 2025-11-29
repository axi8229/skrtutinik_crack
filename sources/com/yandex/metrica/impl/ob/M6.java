package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C0976hf;

/* loaded from: classes3.dex */
public class M6 implements ProtobufConverter {
    private final S6 a;

    public M6() {
        this(new S6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0976hf fromModel(C1405z6 c1405z6) {
        C0976hf c0976hfFromModel = this.a.fromModel(c1405z6.a);
        c0976hfFromModel.g = 1;
        C0976hf.a aVar = new C0976hf.a();
        c0976hfFromModel.h = aVar;
        aVar.a = c1405z6.b;
        return c0976hfFromModel;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    M6(S6 s6) {
        this.a = s6;
    }
}
