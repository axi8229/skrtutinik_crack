package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class C9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.h fromModel(Uh uh) {
        If.h hVar = new If.h();
        hVar.a = uh.c();
        hVar.b = uh.b();
        hVar.c = uh.a();
        hVar.e = uh.e();
        hVar.d = uh.d();
        return hVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uh toModel(If.h hVar) {
        String str = hVar.a;
        Intrinsics.checkNotNullExpressionValue(str, "nano.url");
        return new Uh(str, hVar.b, hVar.c, hVar.d, hVar.e);
    }
}
