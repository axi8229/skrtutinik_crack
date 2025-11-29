package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.D3;

/* loaded from: classes3.dex */
public class Q4 extends M4 {
    private final C1233s2 b;
    private final Vc c;

    public Q4(F3 f3, C1233s2 c1233s2, Vc vc) {
        super(f3);
        this.b = c1233s2;
        this.c = vc;
    }

    @Override // com.yandex.metrica.impl.ob.M4
    public boolean a(C0836c0 c0836c0, C1114n4 c1114n4) {
        D3.a aVarA = c1114n4.b().a();
        this.b.a(aVarA.l);
        Boolean bool = aVarA.e;
        Boolean bool2 = aVarA.p;
        Boolean bool3 = Boolean.TRUE;
        if (bool3.equals(bool) || (bool == null && bool3.equals(bool2))) {
            this.c.a(true);
        } else if (Boolean.FALSE.equals(bool)) {
            this.c.a(false);
        }
        return false;
    }
}
