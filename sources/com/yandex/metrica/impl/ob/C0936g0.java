package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0936g0 implements InterfaceC0806ak {
    final /* synthetic */ C0986i0 a;

    C0936g0(C0986i0 c0986i0) {
        this.a = c0986i0;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0806ak
    public void a(Zj zj) {
        C1298uj c1298ujB = zj.b();
        if (c1298ujB != null) {
            this.a.g.put("cellular_connection_type", c1298ujB.m());
        }
        this.a.g.put("call_state", Integer.valueOf(zj.a()));
    }
}
