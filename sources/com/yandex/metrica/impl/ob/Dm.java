package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Dm {
    private final Zl<Em, Cm> a;
    private final Zl<EnumC0787a1, Cm> b;

    public Dm() {
        this(new Am(), new Fm(), new C1373xm());
    }

    public Cm a(Em em) {
        return this.a.a(em);
    }

    public Dm(Cm cm, Cm cm2, Cm cm3) {
        Zl<Em, Cm> zl = new Zl<>(cm);
        this.a = zl;
        zl.a(Em.NONE, cm);
        zl.a(Em.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, cm2);
        zl.a(Em.AES_VALUE_ENCRYPTION, cm3);
        Zl<EnumC0787a1, Cm> zl2 = new Zl<>(cm);
        this.b = zl2;
        zl2.a(EnumC0787a1.EVENT_TYPE_IDENTITY, cm3);
    }

    public Cm a(C0836c0 c0836c0) {
        return this.b.a(EnumC0787a1.a(c0836c0.o()));
    }
}
