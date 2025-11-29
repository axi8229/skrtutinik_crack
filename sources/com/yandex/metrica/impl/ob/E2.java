package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class E2 implements InterfaceC1107mm<C0858cm> {
    final /* synthetic */ Throwable a;
    final /* synthetic */ String b;

    E2(D2 d2, Throwable th, String str) {
        this.a = th;
        this.b = str;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
    public void b(C0858cm c0858cm) {
        C0858cm c0858cm2 = c0858cm;
        if (c0858cm2.isEnabled()) {
            c0858cm2.e(this.a, this.b);
        }
    }
}
