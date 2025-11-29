package com.yandex.metrica.ecommerce;

import com.yandex.metrica.impl.ob.Ba;
import com.yandex.metrica.impl.ob.C0797ab;
import com.yandex.metrica.impl.ob.C0822bb;
import com.yandex.metrica.impl.ob.C0847cb;
import com.yandex.metrica.impl.ob.C0872db;
import com.yandex.metrica.impl.ob.C0897eb;
import com.yandex.metrica.impl.ob.Ga;
import com.yandex.metrica.impl.ob.Pa;
import com.yandex.metrica.impl.ob.Qa;
import com.yandex.metrica.impl.ob.Ra;
import com.yandex.metrica.impl.ob.Ta;
import com.yandex.metrica.impl.ob.Ua;
import com.yandex.metrica.impl.ob.Va;
import com.yandex.metrica.impl.ob.Wa;
import com.yandex.metrica.impl.ob.Ya;

/* loaded from: classes3.dex */
public class ECommerceEventProvider {
    public ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new Ta(4, new Ua(eCommerceCartItem), new Ba());
    }

    public ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return new Va(6, new Wa(eCommerceOrder), new Ga());
    }

    public ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return new Va(7, new Wa(eCommerceOrder), new Ga());
    }

    public ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return new Ta(5, new Ua(eCommerceCartItem), new Ba());
    }

    public ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return new C0847cb(new Ya(eCommerceProduct), new C0822bb(eCommerceScreen), new Pa());
    }

    public ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return new C0872db(new Ya(eCommerceProduct), eCommerceReferrer == null ? null : new C0797ab(eCommerceReferrer), new Qa());
    }

    public ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return new C0897eb(new C0822bb(eCommerceScreen), new Ra());
    }
}
