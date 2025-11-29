package com.yandex.metrica.ecommerce;

import java.util.List;

/* loaded from: classes3.dex */
public class ECommercePrice {
    private final ECommerceAmount a;
    private List<ECommerceAmount> b;

    public ECommercePrice(ECommerceAmount eCommerceAmount) {
        this.a = eCommerceAmount;
    }

    public ECommerceAmount getFiat() {
        return this.a;
    }

    public List<ECommerceAmount> getInternalComponents() {
        return this.b;
    }

    public ECommercePrice setInternalComponents(List<ECommerceAmount> list) {
        this.b = list;
        return this;
    }

    public String toString() {
        return "ECommercePrice{fiat=" + this.a + ", internalComponents=" + this.b + '}';
    }
}
