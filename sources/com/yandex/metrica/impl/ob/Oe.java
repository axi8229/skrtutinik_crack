package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1318vf;

/* loaded from: classes3.dex */
public final class Oe extends Ne<Double> {
    public Oe(String str, double d) {
        super(2, str, Double.valueOf(d), new Qe(), new Me(new Re(new Wm(100))));
    }

    @Override // com.yandex.metrica.impl.ob.Ne
    protected void a(C1318vf.a aVar) {
        aVar.d.c += f().doubleValue();
    }
}
