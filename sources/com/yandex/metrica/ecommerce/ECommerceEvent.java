package com.yandex.metrica.ecommerce;

import com.yandex.metrica.impl.ob.C1100mf;
import com.yandex.metrica.impl.ob.Na;
import com.yandex.metrica.impl.ob.Vm;
import com.yandex.metrica.impl.ob.Za;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ECommerceEvent implements Za {
    private static ECommerceEventProvider a = new ECommerceEventProvider();

    public static ECommerceEvent addCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return a.addCartItemEvent(eCommerceCartItem);
    }

    public static ECommerceEvent beginCheckoutEvent(ECommerceOrder eCommerceOrder) {
        return a.beginCheckoutEvent(eCommerceOrder);
    }

    public static ECommerceEvent purchaseEvent(ECommerceOrder eCommerceOrder) {
        return a.purchaseEvent(eCommerceOrder);
    }

    public static ECommerceEvent removeCartItemEvent(ECommerceCartItem eCommerceCartItem) {
        return a.removeCartItemEvent(eCommerceCartItem);
    }

    public static ECommerceEvent showProductCardEvent(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        return a.showProductCardEvent(eCommerceProduct, eCommerceScreen);
    }

    public static ECommerceEvent showProductDetailsEvent(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        return a.showProductDetailsEvent(eCommerceProduct, eCommerceReferrer);
    }

    public static ECommerceEvent showScreenEvent(ECommerceScreen eCommerceScreen) {
        return a.showScreenEvent(eCommerceScreen);
    }

    public String getPublicDescription() {
        return "E-commerce base event";
    }

    @Override // com.yandex.metrica.impl.ob.Za
    public abstract /* synthetic */ List<Na<C1100mf, Vm>> toProto();
}
