package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1100mf;
import java.util.Collections;

/* loaded from: classes3.dex */
public class Qa implements Fa {
    private final Ja a;
    private final Ma b;

    public Qa() {
        this(new Ja(), new Ma());
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Na<C1100mf.m, Vm> naFromModel;
        C0872db c0872db = (C0872db) obj;
        C1100mf c1100mf = new C1100mf();
        c1100mf.a = 3;
        c1100mf.d = new C1100mf.p();
        Na<C1100mf.k, Vm> naFromModel2 = this.a.fromModel(c0872db.b);
        c1100mf.d.a = naFromModel2.a;
        C0797ab c0797ab = c0872db.c;
        if (c0797ab != null) {
            naFromModel = this.b.fromModel(c0797ab);
            c1100mf.d.b = naFromModel.a;
        } else {
            naFromModel = null;
        }
        return Collections.singletonList(new Na(c1100mf, Um.a(naFromModel2, naFromModel)));
    }

    @Override // com.yandex.metrica.impl.ob.Fa, com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    Qa(Ja ja, Ma ma) {
        this.a = ja;
        this.b = ma;
    }
}
