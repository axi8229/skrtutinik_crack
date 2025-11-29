package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.eb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0897eb extends ECommerceEvent {
    public final C0822bb b;
    private final Fa c;

    public C0897eb(C0822bb c0822bb, Fa fa) {
        this.b = c0822bb;
        this.c = fa;
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent
    public String getPublicDescription() {
        return "shown screen info";
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent, com.yandex.metrica.impl.ob.Za
    public List<Na<C1100mf, Vm>> toProto() {
        return (List) this.c.fromModel(this);
    }

    public String toString() {
        return "ShownScreenInfoEvent{screen=" + this.b + ", converter=" + this.c + '}';
    }
}
