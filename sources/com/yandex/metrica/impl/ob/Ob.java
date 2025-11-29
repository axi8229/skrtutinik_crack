package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.TimeProvider;

/* loaded from: classes3.dex */
public class Ob implements Gc {
    private final TimeProvider a;
    private final InterfaceC0948gc b;

    Ob(InterfaceC0948gc interfaceC0948gc, TimeProvider timeProvider) {
        this.b = interfaceC0948gc;
        this.a = timeProvider;
    }

    @Override // com.yandex.metrica.impl.ob.Gc
    public void a() {
        this.b.a(this.a.currentTimeSeconds());
    }
}
