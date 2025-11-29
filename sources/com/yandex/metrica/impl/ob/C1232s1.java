package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.s1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1232s1 implements InterfaceC1088m3<C1187q3> {
    final /* synthetic */ C1208r1 a;

    C1232s1(C1208r1 c1208r1) {
        this.a = c1208r1;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1088m3
    public boolean a(C1113n3 c1113n3) {
        return !this.a.c.getPackageName().equals(((C1187q3) c1113n3).a);
    }
}
