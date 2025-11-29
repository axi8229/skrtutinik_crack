package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceEvent;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.db, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0872db extends ECommerceEvent {
    public final Ya b;
    public final C0797ab c;
    private final Fa d;

    public C0872db(Ya ya, C0797ab c0797ab, Fa fa) {
        this.b = ya;
        this.c = c0797ab;
        this.d = fa;
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent
    public String getPublicDescription() {
        return "shown product details info";
    }

    @Override // com.yandex.metrica.ecommerce.ECommerceEvent, com.yandex.metrica.impl.ob.Za
    public List<Na<C1100mf, Vm>> toProto() {
        return (List) this.d.fromModel(this);
    }

    public String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.b + ", referrer=" + this.c + ", converter=" + this.d + '}';
    }
}
