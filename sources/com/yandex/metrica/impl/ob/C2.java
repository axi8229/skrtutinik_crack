package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class C2 implements InterfaceC1107mm<C0858cm> {
    final /* synthetic */ String a;

    C2(D2 d2, String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
    public void b(C0858cm c0858cm) {
        C0858cm c0858cm2 = c0858cm;
        if (c0858cm2.isEnabled()) {
            c0858cm2.i(this.a);
        }
    }
}
