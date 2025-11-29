package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.n5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1115n5 extends X4 {
    public C1115n5(L3 l3) {
        super(l3);
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        String strM = c0836c0.m();
        if (TextUtils.isEmpty(strM)) {
            return false;
        }
        a().b(strM);
        return false;
    }
}
