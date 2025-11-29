package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import java.util.List;

/* loaded from: classes3.dex */
public class Va extends ECommerceEvent {
    public final int b;
    public final Wa c;
    private final Fa d;

    public Va(int i, Wa wa, Fa fa) {
        this.b = i;
        this.c = wa;
        this.d = fa;
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent
    public String getPublicDescription() {
        return "order info";
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent, com.yandex.metrica.impl.ob.Za
    public List<Na<C1100mf, Vm>> toProto() {
        return (List) this.d.fromModel(this);
    }

    public String toString() {
        return "OrderInfoEvent{eventType=" + this.b + ", order=" + this.c + ", converter=" + this.d + '}';
    }
}
