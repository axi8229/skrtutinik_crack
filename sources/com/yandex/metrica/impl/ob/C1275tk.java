package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;

/* renamed from: com.yandex.metrica.impl.ob.tk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1275tk implements Cl {
    private final String a;

    C1275tk(String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(Object obj) {
        return ((String) obj).equals(this.a);
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.EQUALS;
    }
}
