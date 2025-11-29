package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1318vf;

/* loaded from: classes3.dex */
public abstract class Ne<T> extends Se {
    private final T f;

    Ne(int i, String str, T t, Kn<String> kn, Ke ke) {
        super(i, str, kn, ke);
        this.f = t;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0826bf
    public void a(C0801af c0801af) {
        C1318vf.a aVarA;
        if (!e() || (aVarA = b().a(c0801af, c0801af.a(d(), c()), this)) == null) {
            return;
        }
        a(aVarA);
    }

    protected abstract void a(C1318vf.a aVar);

    public T f() {
        return this.f;
    }
}
