package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1230s;
import java.util.HashMap;

/* loaded from: classes3.dex */
class B3 {
    private final HashMap<String, C1230s> a = new HashMap<>();

    B3() {
    }

    public synchronized C1230s a(I3 i3, C0858cm c0858cm, C0845c9 c0845c9) {
        C1230s c1230s;
        c1230s = this.a.get(i3.toString());
        if (c1230s == null) {
            C1230s.a aVarF = c0845c9.f();
            c1230s = new C1230s(aVarF.a, aVarF.b, c0858cm);
            this.a.put(i3.toString(), c1230s);
        }
        return c1230s;
    }
}
