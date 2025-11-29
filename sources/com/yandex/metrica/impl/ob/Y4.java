package com.yandex.metrica.impl.ob;

import com.yandex.metrica.IReporter;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Y4 extends X4 {
    private final IReporter b;

    public Y4(L3 l3, IReporter iReporter) {
        super(l3);
        this.b = iReporter;
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        C1213r6 c1213r6A = C1213r6.a(c0836c0.o());
        HashMap map = new HashMap();
        map.put("type", c1213r6A.a);
        map.put("delivery_method", c1213r6A.b);
        this.b.reportEvent("crash_saved", map);
        return false;
    }
}
