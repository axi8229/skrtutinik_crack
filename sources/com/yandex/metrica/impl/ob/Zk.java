package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;

/* loaded from: classes3.dex */
public class Zk implements Cl {
    private final int a;

    public Zk(int i) {
        this.a = i;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(Object obj) {
        return ((String) obj).length() > this.a;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.TEXT_TOO_LONG;
    }
}
