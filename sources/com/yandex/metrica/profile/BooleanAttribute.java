package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.Je;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Le;
import com.yandex.metrica.impl.ob.Me;
import com.yandex.metrica.impl.ob.Pe;
import com.yandex.metrica.impl.ob.Ve;
import com.yandex.metrica.impl.ob.We;

/* loaded from: classes3.dex */
public class BooleanAttribute {
    private final Pe a;

    BooleanAttribute(String str, Kn<String> kn, Je je) {
        this.a = new Pe(str, kn, je);
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValue(boolean z) {
        return new UserProfileUpdate<>(new Le(this.a.a(), z, this.a.b(), new Me(this.a.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueIfUndefined(boolean z) {
        return new UserProfileUpdate<>(new Le(this.a.a(), z, this.a.b(), new We(this.a.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueReset() {
        return new UserProfileUpdate<>(new Ve(3, this.a.a(), this.a.b(), this.a.c()));
    }
}
