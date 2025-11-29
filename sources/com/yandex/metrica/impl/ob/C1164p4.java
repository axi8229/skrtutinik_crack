package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.p4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1164p4 {
    private final HashMap<String, X3> a = new HashMap<>();
    private final HashMap<String, F3> b = new HashMap<>();
    private final Context c;

    public C1164p4(Context context) {
        this.c = context.getApplicationContext();
    }

    public synchronized X3 a(I3 i3) {
        return this.a.get(i3.toString());
    }

    public synchronized X3 b(I3 i3, D3 d3, N3<X3> n3) {
        return (X3) a(i3, d3, n3, this.a);
    }

    public synchronized F3 a(I3 i3, D3 d3, N3<F3> n3) {
        return (F3) a(i3, d3, n3, this.b);
    }

    private <T extends R3> T a(I3 i3, D3 d3, N3<T> n3, Map<String, T> map) {
        T t = map.get(i3.toString());
        if (t == null) {
            T t2 = (T) n3.a(this.c, i3, d3);
            map.put(i3.toString(), t2);
            return t2;
        }
        t.a(d3);
        return t;
    }
}
