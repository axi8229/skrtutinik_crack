package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;

/* loaded from: classes3.dex */
public class N6 implements Converter {
    private final O6<H6> a;

    public N6() {
        this(new O6(new X6()));
    }

    public byte[] a(H6 h6) {
        return this.a.a(h6);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        return this.a.a((H6) obj);
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    N6(O6<H6> o6) {
        this.a = o6;
    }
}
