package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1018j8;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class P7 {
    private final HashMap<String, List<String>> a;

    public P7() {
        HashMap<String, List<String>> map = new HashMap<>();
        this.a = map;
        map.put("reports", C1018j8.d.a);
        map.put("sessions", C1018j8.e.a);
        map.put("preferences", C1018j8.c.a);
        map.put("binary_data", C1018j8.b.a);
    }

    public HashMap<String, List<String>> a() {
        return this.a;
    }
}
