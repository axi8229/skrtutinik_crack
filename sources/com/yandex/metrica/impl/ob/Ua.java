package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class Ua {
    public final Ya a;
    public final BigDecimal b;
    public final Xa c;
    public final C0797ab d;

    public Ua(ECommerceCartItem eCommerceCartItem) {
        this(new Ya(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Xa(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new C0797ab(eCommerceCartItem.getReferrer()));
    }

    public String toString() {
        return "CartItemWrapper{product=" + this.a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + '}';
    }

    public Ua(Ya ya, BigDecimal bigDecimal, Xa xa, C0797ab c0797ab) {
        this.a = ya;
        this.b = bigDecimal;
        this.c = xa;
        this.d = c0797ab;
    }
}
