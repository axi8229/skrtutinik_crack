package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.r5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1212r5 extends X4 {
    public C1212r5(L3 l3) {
        super(l3);
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        String strP = a().p();
        String strM = c0836c0.m();
        a().b(strM);
        if (TextUtils.equals(strP, strM)) {
            return false;
        }
        a().a(J.s());
        return false;
    }
}
