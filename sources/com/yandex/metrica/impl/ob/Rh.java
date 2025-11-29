package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1306v3;
import java.util.Map;

/* loaded from: classes3.dex */
public class Rh {
    public boolean a(Map<String, String> map, C1178pi c1178pi, I i) {
        Map<String, String> mapB = i.a(new C1306v3.a(map, EnumC1279u0.APP)).b();
        if (A2.b(mapB)) {
            return true;
        }
        return mapB.equals(Tl.a(c1178pi.u()));
    }
}
