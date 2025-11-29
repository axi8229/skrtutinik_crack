package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.j2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1012j2 {
    private final C1037k2 a;
    private final Context b;
    private final Map<String, C0988i2> c = new HashMap();

    public C1012j2(Context context, C1037k2 c1037k2) {
        this.b = context;
        this.a = c1037k2;
    }

    public synchronized C0988i2 a(String str, CounterConfiguration.b bVar) {
        C0988i2 c0988i2;
        c0988i2 = this.c.get(str);
        if (c0988i2 == null) {
            c0988i2 = new C0988i2(str, this.b, bVar, this.a);
            this.c.put(str, c0988i2);
        }
        return c0988i2;
    }
}
