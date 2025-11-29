package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.c5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0841c5 extends X4 {
    private final C0819b8 b;

    public C0841c5(L3 l3) {
        super(l3);
        this.b = l3.x();
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        L3 l3A = a();
        l3A.e().toString();
        if (!this.b.k() || !l3A.B()) {
            return false;
        }
        l3A.r().d(C0836c0.a(c0836c0, l3A));
        return false;
    }
}
