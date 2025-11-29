package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1100mf;
import java.math.BigDecimal;
import kotlin.Pair;

/* loaded from: classes3.dex */
public class Ea implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1100mf.e fromModel(BigDecimal bigDecimal) {
        Pair pairA = Ol.a(bigDecimal);
        Nl nl = new Nl(((Number) pairA.getFirst()).longValue(), ((Number) pairA.getSecond()).intValue());
        C1100mf.e eVar = new C1100mf.e();
        eVar.a = nl.b();
        eVar.b = nl.a();
        return eVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
