package com.yandex.metrica.ecommerce;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ECommerceOrder {
    private final String a;
    private final List<ECommerceCartItem> b;
    private Map<String, String> c;

    public ECommerceOrder(String str, List<ECommerceCartItem> list) {
        this.a = str;
        this.b = list;
    }

    public List<ECommerceCartItem> getCartItems() {
        return this.b;
    }

    public String getIdentifier() {
        return this.a;
    }

    public Map<String, String> getPayload() {
        return this.c;
    }

    public ECommerceOrder setPayload(Map<String, String> map) {
        this.c = map;
        return this;
    }

    public String toString() {
        return "ECommerceOrder{identifier='" + this.a + "', cartItems=" + this.b + ", payload=" + this.c + '}';
    }
}
