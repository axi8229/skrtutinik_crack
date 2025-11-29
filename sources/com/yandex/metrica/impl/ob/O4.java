package com.yandex.metrica.impl.ob;

import android.os.Bundle;

/* loaded from: classes3.dex */
public class O4 extends M4 {
    public O4(F3 f3) {
        super(f3);
    }

    @Override // com.yandex.metrica.impl.ob.M4
    public boolean a(C0836c0 c0836c0, C1114n4 c1114n4) {
        Bundle bundleL = c0836c0.l();
        a().a(bundleL != null ? (V0) bundleL.getParcelable("com.yandex.metrica.impl.IdentifiersData") : null);
        return false;
    }
}
