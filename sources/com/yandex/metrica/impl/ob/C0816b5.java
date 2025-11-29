package com.yandex.metrica.impl.ob;

import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.b5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0816b5 extends X4 {
    private final M5 b;

    public C0816b5(L3 l3) {
        this(l3, l3.j());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        if (TextUtils.isEmpty(c0836c0.g())) {
            return false;
        }
        c0836c0.a(this.b.a(c0836c0.g()));
        return false;
    }

    C0816b5(L3 l3, M5 m5) {
        super(l3);
        this.b = m5;
    }
}
