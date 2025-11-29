package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class L9 implements ProtobufConverter {
    private final K9 a;
    private final M9 b;

    public L9() {
        this(new K9(), new M9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.k fromModel(C1147oc c1147oc) {
        If.k kVar = new If.k();
        kVar.a = this.a.fromModel(c1147oc.a);
        kVar.b = this.b.fromModel(c1147oc.b);
        return kVar;
    }

    L9(K9 k9, M9 m9) {
        this.a = k9;
        this.b = m9;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1147oc toModel(If.k kVar) {
        K9 k9 = this.a;
        If.k.a aVar = kVar.a;
        If.k.a aVar2 = new If.k.a();
        if (aVar == null) {
            aVar = aVar2;
        }
        C1097mc model = k9.toModel(aVar);
        M9 m9 = this.b;
        If.k.b bVar = kVar.b;
        If.k.b bVar2 = new If.k.b();
        if (bVar == null) {
            bVar = bVar2;
        }
        return new C1147oc(model, m9.toModel(bVar));
    }
}
