package com.yandex.metrica.profile;

import com.yandex.metrica.impl.ob.InterfaceC0826bf;
import com.yandex.metrica.impl.ob.InterfaceC0934fn;
import com.yandex.metrica.impl.ob.Je;
import com.yandex.metrica.impl.ob.Kn;
import com.yandex.metrica.impl.ob.Me;
import com.yandex.metrica.impl.ob.Pe;
import com.yandex.metrica.impl.ob.Ve;
import com.yandex.metrica.impl.ob.We;
import com.yandex.metrica.impl.ob.Ye;

/* loaded from: classes3.dex */
public class StringAttribute {
    private final InterfaceC0934fn<String> a;
    private final Pe b;

    StringAttribute(String str, InterfaceC0934fn<String> interfaceC0934fn, Kn<String> kn, Je je) {
        this.b = new Pe(str, kn, je);
        this.a = interfaceC0934fn;
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValue(String str) {
        return new UserProfileUpdate<>(new Ye(this.b.a(), str, this.a, this.b.b(), new Me(this.b.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueIfUndefined(String str) {
        return new UserProfileUpdate<>(new Ye(this.b.a(), str, this.a, this.b.b(), new We(this.b.c())));
    }

    public UserProfileUpdate<? extends InterfaceC0826bf> withValueReset() {
        return new UserProfileUpdate<>(new Ve(0, this.b.a(), this.b.b(), this.b.c()));
    }
}
