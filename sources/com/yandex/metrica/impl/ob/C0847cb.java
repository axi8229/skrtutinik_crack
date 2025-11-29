package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.cb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0847cb extends ECommerceEvent {
    public final Ya b;
    public final C0822bb c;
    private final Fa d;

    public C0847cb(Ya ya, C0822bb c0822bb, Fa fa) {
        this.b = ya;
        this.c = c0822bb;
        this.d = fa;
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent
    public String getPublicDescription() {
        return "shown product card info";
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent, com.yandex.metrica.impl.ob.Za
    public List<Na<C1100mf, Vm>> toProto() {
        return (List) this.d.fromModel(this);
    }

    public String toString() {
        return "ShownProductCardInfoEvent{product=" + this.b + ", screen=" + this.c + ", converter=" + this.d + '}';
    }
}
