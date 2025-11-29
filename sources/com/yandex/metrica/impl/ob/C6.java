package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.AbstractC1381y6;

/* loaded from: classes3.dex */
public class C6 extends AbstractC1381y6 {
    private C1377y2 d;

    public C6(Context context, C1377y2 c1377y2, AbstractC1381y6.a aVar, com.yandex.metrica.c cVar) {
        this(c1377y2, aVar, cVar, new A0(context));
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1381y6
    void a(H6 h6) {
        this.d.a().a(h6);
    }

    C6(C1377y2 c1377y2, AbstractC1381y6.a aVar, com.yandex.metrica.c cVar, A0 a0) {
        super(aVar, cVar, a0);
        this.d = c1377y2;
    }
}
