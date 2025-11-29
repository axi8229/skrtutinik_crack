package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class I9 implements ProtobufConverter {
    private final H9 a;

    public I9() {
        this(new H9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.k.a.b fromModel(C0848cc c0848cc) {
        If.k.a.b bVar = new If.k.a.b();
        Qc qc = c0848cc.a;
        bVar.a = qc.a;
        bVar.b = qc.b;
        C0798ac c0798ac = c0848cc.b;
        if (c0798ac != null) {
            bVar.c = this.a.fromModel(c0798ac);
        }
        return bVar;
    }

    I9(H9 h9) {
        this.a = h9;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0848cc toModel(If.k.a.b bVar) {
        If.k.a.b.C0287a c0287a = bVar.c;
        return new C0848cc(new Qc(bVar.a, bVar.b), c0287a != null ? this.a.toModel(c0287a) : null);
    }
}
