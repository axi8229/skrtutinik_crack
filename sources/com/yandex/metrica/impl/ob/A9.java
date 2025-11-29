package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class A9 implements ProtobufConverter {
    private final C1408z9 a;

    public A9() {
        this(new C1408z9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.f fromModel(C1217ra c1217ra) {
        If.f fVar = new If.f();
        fVar.a = a(c1217ra.a);
        fVar.b = a(c1217ra.b);
        fVar.c = a(c1217ra.c);
        return fVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        If.f fVar = (If.f) obj;
        return new C1217ra(a(fVar.a), a(fVar.b), a(fVar.c));
    }

    A9(C1408z9 c1408z9) {
        this.a = c1408z9;
    }

    public C1217ra a(If.f fVar) {
        return new C1217ra(a(fVar.a), a(fVar.b), a(fVar.c));
    }

    private If.e a(C1194qa c1194qa) {
        if (c1194qa == null) {
            return null;
        }
        this.a.getClass();
        If.e eVar = new If.e();
        eVar.a = c1194qa.a;
        eVar.b = c1194qa.b;
        return eVar;
    }

    private C1194qa a(If.e eVar) {
        if (eVar == null) {
            return null;
        }
        return this.a.toModel(eVar);
    }
}
