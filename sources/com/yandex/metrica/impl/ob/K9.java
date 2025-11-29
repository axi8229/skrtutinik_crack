package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class K9 implements ProtobufConverter {
    private final G9 a;
    private final I9 b;

    public K9() {
        this(new G9(), new I9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.k.a fromModel(C1097mc c1097mc) {
        If.k.a aVar = new If.k.a();
        aVar.a = c1097mc.a;
        aVar.b = c1097mc.b;
        aVar.c = c1097mc.c;
        aVar.d = c1097mc.d;
        aVar.e = c1097mc.e;
        aVar.f = c1097mc.f;
        aVar.g = c1097mc.g;
        aVar.j = c1097mc.h;
        aVar.h = c1097mc.i;
        aVar.i = c1097mc.j;
        aVar.p = c1097mc.k;
        aVar.q = c1097mc.l;
        Xb xb = c1097mc.m;
        if (xb != null) {
            aVar.k = this.a.fromModel(xb);
        }
        Xb xb2 = c1097mc.n;
        if (xb2 != null) {
            aVar.l = this.a.fromModel(xb2);
        }
        Xb xb3 = c1097mc.o;
        if (xb3 != null) {
            aVar.m = this.a.fromModel(xb3);
        }
        Xb xb4 = c1097mc.p;
        if (xb4 != null) {
            aVar.n = this.a.fromModel(xb4);
        }
        C0848cc c0848cc = c1097mc.q;
        if (c0848cc != null) {
            aVar.o = this.b.fromModel(c0848cc);
        }
        return aVar;
    }

    K9(G9 g9, I9 i9) {
        this.a = g9;
        this.b = i9;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1097mc toModel(If.k.a aVar) {
        If.k.a.C0285a c0285a = aVar.k;
        Xb model = c0285a != null ? this.a.toModel(c0285a) : null;
        If.k.a.C0285a c0285a2 = aVar.l;
        Xb model2 = c0285a2 != null ? this.a.toModel(c0285a2) : null;
        If.k.a.C0285a c0285a3 = aVar.m;
        Xb model3 = c0285a3 != null ? this.a.toModel(c0285a3) : null;
        If.k.a.C0285a c0285a4 = aVar.n;
        Xb model4 = c0285a4 != null ? this.a.toModel(c0285a4) : null;
        If.k.a.b bVar = aVar.o;
        return new C1097mc(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f, aVar.g, aVar.j, aVar.h, aVar.i, aVar.p, aVar.q, model, model2, model3, model4, bVar != null ? this.b.toModel(bVar) : null);
    }
}
