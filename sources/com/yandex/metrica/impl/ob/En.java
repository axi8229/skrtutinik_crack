package com.yandex.metrica.impl.ob;

import java.util.Collection;

/* loaded from: classes3.dex */
public class En<T> implements Kn<Collection<T>> {
    public En(String str) {
    }

    @Override // com.yandex.metrica.impl.ob.Kn
    public In a(Object obj) {
        if (!A2.b((Collection) obj)) {
            return In.a(this);
        }
        return In.a(this, "Stacktrace is null or empty.");
    }
}
