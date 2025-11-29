package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.Je;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Me;
import com.yandex.metrica.impl.ob.Pe;
import com.yandex.metrica.impl.ob.Qe;
import com.yandex.metrica.impl.ob.Re;
import com.yandex.metrica.impl.ob.Te;
import com.yandex.metrica.impl.ob.Ve;
import com.yandex.metrica.impl.ob.We;
import com.yandex.metrica.impl.ob.Wm;

/* loaded from: classes3.dex */
public final class NumberAttribute {
    private final Pe a;

    NumberAttribute(String str, Kn<String> kn, Je je) {
        this.a = new Pe(str, kn, je);
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValue(double d) {
        return new UserProfileUpdate<>(new Te(this.a.a(), d, new Qe(), new Me(new Re(new Wm(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new Te(this.a.a(), d, new Qe(), new We(new Re(new Wm(100)))));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueReset() {
        return new UserProfileUpdate<>(new Ve(1, this.a.a(), new Qe(), new Re(new Wm(100))));
    }
}
