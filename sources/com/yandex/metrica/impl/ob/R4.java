package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class R4 extends X4 {
    private final C0819b8 b;
    private final C0933fm c;

    public R4(L3 l3) {
        this(l3, l3.x(), C0933fm.c());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        L3 l3A = a();
        if (this.b.k() || this.b.l()) {
            return false;
        }
        if (l3A.m().P()) {
            this.c.b();
        }
        a().j().a();
        return false;
    }

    R4(L3 l3, C0819b8 c0819b8, C0933fm c0933fm) {
        super(l3);
        this.b = c0819b8;
        this.c = c0933fm;
    }
}
