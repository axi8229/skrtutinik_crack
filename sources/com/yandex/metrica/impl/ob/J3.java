package com.yandex.metrica.impl.ob;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class J3 {
    private final List<InterfaceC1039k4> a = new CopyOnWriteArrayList();

    public void a(InterfaceC1039k4 interfaceC1039k4) {
        this.a.add(interfaceC1039k4);
    }

    public void b(InterfaceC1039k4 interfaceC1039k4) {
        this.a.remove(interfaceC1039k4);
    }

    public List<InterfaceC1039k4> a() {
        return this.a;
    }
}
