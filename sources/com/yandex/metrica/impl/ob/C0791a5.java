package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.a5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0791a5 extends X4 {
    private final C0819b8 b;

    public C0791a5(L3 l3) {
        this(l3, l3.x());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        L3 l3A = a();
        if (this.b.k()) {
            return false;
        }
        if (!this.b.l()) {
            l3A.r().a(C0836c0.b(c0836c0));
        }
        this.b.a(true);
        return false;
    }

    C0791a5(L3 l3, C0819b8 c0819b8) {
        super(l3);
        this.b = c0819b8;
    }
}
