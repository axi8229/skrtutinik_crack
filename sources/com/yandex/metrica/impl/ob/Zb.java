package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Zb extends Uc<C0848cc> {
    Zb(InterfaceC0948gc interfaceC0948gc, C1353x2 c1353x2) {
        super(interfaceC0948gc, c1353x2);
    }

    @Override // com.yandex.metrica.impl.ob.Uc
    protected String a() {
        return "fused";
    }

    @Override // com.yandex.metrica.impl.ob.Lb
    public boolean a(Object obj) {
        C0798ac c0798ac = ((C0848cc) obj).b;
        return c0798ac != null && a(c0798ac.c);
    }

    @Override // com.yandex.metrica.impl.ob.Lb
    public boolean b(Object obj) {
        return ((C0848cc) obj).a.a;
    }
}
