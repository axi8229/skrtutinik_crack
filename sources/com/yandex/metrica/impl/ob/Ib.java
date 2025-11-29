package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1266tb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ib {
    public static final Map<String, C1266tb.a> a;

    static {
        HashMap map = new HashMap();
        map.put("google", C1266tb.a.GOOGLE);
        map.put("huawei", C1266tb.a.HMS);
        map.put("yandex", C1266tb.a.YANDEX);
        a = Collections.unmodifiableMap(map);
    }
}
