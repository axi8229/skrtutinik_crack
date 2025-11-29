package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.hj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0980hj implements InterfaceC0830bj {
    private final C0820b9 a;

    public C0980hj(C0820b9 c0820b9) {
        this.a = c0820b9;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0830bj
    public String a() {
        W0 w0U = this.a.u();
        String str = !TextUtils.isEmpty(w0U.a) ? w0U.a : null;
        if (str != null) {
            return str;
        }
        String strN = this.a.n(null);
        return !TextUtils.isEmpty(strN) ? strN : str;
    }
}
