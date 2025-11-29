package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.m5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1090m5 extends X4 {
    public C1090m5(L3 l3) {
        super(l3);
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        if (TextUtils.isEmpty(c0836c0.p()) || !TextUtils.isEmpty(a().h())) {
            return false;
        }
        a().a(c0836c0.p());
        return false;
    }
}
