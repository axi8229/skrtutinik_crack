package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes3.dex */
public class Be implements Ge, InterfaceC1149oe {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1149oe
    public int a(Em em) {
        return 2;
    }

    @Override // com.yandex.metrica.impl.ob.Ge
    public byte[] a(C1198qe c1198qe, Lg lg) {
        return TextUtils.isEmpty(c1198qe.b) ? new byte[0] : Base64.decode(c1198qe.b, 0);
    }
}
