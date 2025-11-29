package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.ik, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1005ik {
    private final List<Object> a;

    C1005ik(List<Object> list) {
        this.a = list;
    }

    C1228rl.b a(String str) {
        Iterator<Object> it = this.a.iterator();
        while (it.hasNext()) {
            Cl cl = (Cl) it.next();
            if (cl.a(str)) {
                return cl.a();
            }
        }
        return null;
    }
}
