package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.yandex.metrica.impl.ob.ob, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1146ob {
    private final List<InterfaceC1096mb> a;
    private final InterfaceC1171pb b;
    private final AtomicBoolean c = new AtomicBoolean(true);

    public C1146ob(List<InterfaceC1096mb> list, InterfaceC1171pb interfaceC1171pb) {
        this.a = list;
        this.b = interfaceC1171pb;
    }

    public void a() {
        this.c.set(false);
    }

    public void b() {
        this.c.set(true);
    }

    public void c() {
        if (this.c.get()) {
            if (this.a.isEmpty()) {
                ((L3) this.b).c();
                return;
            }
            Iterator<InterfaceC1096mb> it = this.a.iterator();
            boolean zA = false;
            while (it.hasNext()) {
                zA |= it.next().a();
            }
            if (zA) {
                ((L3) this.b).c();
            }
        }
    }
}
