package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ValidationException;

/* loaded from: classes3.dex */
public class Hn<T> implements Kn<T> {
    private final Kn<T> a;

    public Hn(Kn<T> kn) {
        this.a = kn;
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(T t) {
        In inA = this.a.a(t);
        if (inA.b()) {
            return inA;
        }
        throw new ValidationException(inA.a());
    }
}
