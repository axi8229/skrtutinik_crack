package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.Je;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Oe;
import com.yandex.metrica.impl.ob.Pe;

/* loaded from: classes3.dex */
public final class CounterAttribute {
    private final Pe a;

    CounterAttribute(String str, Kn<String> kn, Je je) {
        this.a = new Pe(str, kn, je);
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withDelta(double d) {
        return new UserProfileUpdate<>(new Oe(this.a.a(), d));
    }
}
