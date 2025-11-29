package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Mb extends Uc<Xb> {
    private final String c;

    public Mb(InterfaceC0948gc interfaceC0948gc, String str) {
        this(interfaceC0948gc, str, new C1353x2());
    }

    @Override // com.yandex.metrica.impl.ob.Lb
    public boolean a(Object obj) {
        Wb wb = ((Xb) obj).b;
        return wb != null && a(wb.b);
    }

    @Override // com.yandex.metrica.impl.ob.Lb
    public boolean b(Object obj) {
        return ((Xb) obj).a.a;
    }

    Mb(InterfaceC0948gc interfaceC0948gc, String str, C1353x2 c1353x2) {
        super(interfaceC0948gc, c1353x2);
        this.c = str;
    }

    @Override // com.yandex.metrica.impl.ob.Uc
    protected String a() {
        return this.c;
    }
}
