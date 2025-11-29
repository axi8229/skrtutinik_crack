package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import java.util.List;

/* loaded from: classes3.dex */
public class Ta extends ECommerceEvent {
    public final int b;
    public final Ua c;
    private final Fa d;

    public Ta(int i, Ua ua, Fa fa) {
        this.b = i;
        this.c = ua;
        this.d = fa;
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent
    public String getPublicDescription() {
        int i = this.b;
        return i != 4 ? i != 5 ? "unknown cart action info" : "remove cart item info" : "add cart item info";
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent, com.yandex.metrica.impl.ob.Za
    public List<Na<C1100mf, Vm>> toProto() {
        return (List) this.d.fromModel(this);
    }

    public String toString() {
        return "CartActionInfoEvent{eventType=" + this.b + ", cartItem=" + this.c + ", converter=" + this.d + '}';
    }
}
