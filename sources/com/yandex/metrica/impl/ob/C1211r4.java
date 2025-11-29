package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.r4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1211r4 extends AbstractC0940g4 {
    C1211r4(Context context, X3 x3) {
        super(context, x3);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0940g4
    protected void b(C0836c0 c0836c0, D3 d3) {
        Boolean bool = d3.b.e;
        Boolean bool2 = Boolean.FALSE;
        if (bool == null) {
            bool = bool2;
        }
        c().a(bool.booleanValue());
        b().a(c0836c0, d3);
    }
}
