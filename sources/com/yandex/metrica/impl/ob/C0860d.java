package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0860d implements InterfaceC1134o {
    private final com.yandex.metrica.billing_interface.g a;

    public C0860d() {
        this(new com.yandex.metrica.billing_interface.g());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1134o
    public Map<String, com.yandex.metrica.billing_interface.a> a(C0985i c0985i, Map<String, com.yandex.metrica.billing_interface.a> map, InterfaceC1059l interfaceC1059l) {
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            com.yandex.metrica.billing_interface.a aVar = map.get(str);
            this.a.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (aVar.a != com.yandex.metrica.billing_interface.e.INAPP || interfaceC1059l.a()) {
                com.yandex.metrica.billing_interface.a aVarA = interfaceC1059l.a(aVar.b);
                if (aVarA == null || !aVarA.c.equals(aVar.c) || (aVar.a == com.yandex.metrica.billing_interface.e.SUBS && jCurrentTimeMillis - aVarA.e >= TimeUnit.SECONDS.toMillis(c0985i.a))) {
                    map2.put(str, aVar);
                }
            } else if (jCurrentTimeMillis - aVar.d <= TimeUnit.SECONDS.toMillis(c0985i.b)) {
                map2.put(str, aVar);
            }
        }
        return map2;
    }

    C0860d(com.yandex.metrica.billing_interface.g gVar) {
        this.a = gVar;
    }
}
