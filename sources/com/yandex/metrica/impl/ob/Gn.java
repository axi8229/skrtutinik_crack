package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Gn<T> implements Kn<T> {
    private final String a;

    public Gn(String str) {
        this.a = str;
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(T t) {
        if (t != null) {
            return In.a(this);
        }
        return In.a(this, this.a + " is null.");
    }
}
