package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* loaded from: classes3.dex */
public class G9 implements ProtobufConverter {
    private final F9 a;

    public G9() {
        this(new F9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.k.a.C0285a fromModel(Xb xb) {
        If.k.a.C0285a c0285a = new If.k.a.C0285a();
        Qc qc = xb.a;
        c0285a.a = qc.a;
        c0285a.b = qc.b;
        Wb wb = xb.b;
        if (wb != null) {
            this.a.getClass();
            If.k.a.C0285a.C0286a c0286a = new If.k.a.C0285a.C0286a();
            c0286a.a = wb.a;
            c0286a.b = wb.b;
            c0285a.c = c0286a;
        }
        return c0285a;
    }

    G9(F9 f9) {
        this.a = f9;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Xb toModel(If.k.a.C0285a c0285a) {
        Wb wb;
        If.k.a.C0285a.C0286a c0286a = c0285a.c;
        if (c0286a != null) {
            this.a.getClass();
            wb = new Wb(c0286a.a, c0286a.b);
        } else {
            wb = null;
        }
        return new Xb(new Qc(c0285a.a, c0285a.b), wb);
    }
}
