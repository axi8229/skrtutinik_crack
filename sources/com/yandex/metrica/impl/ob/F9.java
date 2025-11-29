package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class F9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Wb wb = (Wb) obj;
        If.k.a.C0285a.C0286a c0286a = new If.k.a.C0285a.C0286a();
        c0286a.a = wb.a;
        c0286a.b = wb.b;
        return c0286a;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        If.k.a.C0285a.C0286a c0286a = (If.k.a.C0285a.C0286a) obj;
        return new Wb(c0286a.a, c0286a.b);
    }
}
