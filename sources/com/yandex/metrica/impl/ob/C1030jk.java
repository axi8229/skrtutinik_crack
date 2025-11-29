package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;

/* renamed from: com.yandex.metrica.impl.ob.jk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1030jk implements Cl {
    private final String a;

    C1030jk(String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(Object obj) {
        return ((String) obj).contains(this.a);
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.CONTAINS;
    }
}
