package com.yandex.metrica.ecommerce;

import com.yandex.metrica.impl.ob.A2;
import com.yandex.varioqub.config.model.ConfigValue;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class ECommerceCartItem {
    private final ECommerceProduct a;
    private final BigDecimal b;
    private final ECommercePrice c;
    private ECommerceReferrer d;

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, long j) {
        this(eCommerceProduct, eCommercePrice, A2.a(j));
    }

    public ECommerceProduct getProduct() {
        return this.a;
    }

    public BigDecimal getQuantity() {
        return this.b;
    }

    public ECommerceReferrer getReferrer() {
        return this.d;
    }

    public ECommercePrice getRevenue() {
        return this.c;
    }

    public ECommerceCartItem setReferrer(ECommerceReferrer eCommerceReferrer) {
        this.d = eCommerceReferrer;
        return this;
    }

    public String toString() {
        return "ECommerceCartItem{product=" + this.a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + '}';
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, double d) {
        this(eCommerceProduct, eCommercePrice, new BigDecimal(A2.a(d, ConfigValue.DOUBLE_DEFAULT_VALUE)));
    }

    public ECommerceCartItem(ECommerceProduct eCommerceProduct, ECommercePrice eCommercePrice, BigDecimal bigDecimal) {
        this.a = eCommerceProduct;
        this.b = bigDecimal;
        this.c = eCommercePrice;
    }
}
