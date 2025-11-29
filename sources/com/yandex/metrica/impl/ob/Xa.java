package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceAmount;
import com.yandex.metrica.ecommerce.ECommercePrice;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class Xa {
    public final Sa a;
    public final List<Sa> b;

    public Xa(ECommercePrice eCommercePrice) {
        this(new Sa(eCommercePrice.getFiat()), a(eCommercePrice.getInternalComponents()));
    }

    public static List<Sa> a(List<ECommerceAmount> list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ECommerceAmount eCommerceAmount : list) {
            linkedList.add(new Sa(eCommerceAmount.getAmount(), eCommerceAmount.getUnit()));
        }
        return linkedList;
    }

    public String toString() {
        return "PriceWrapper{fiat=" + this.a + ", internalComponents=" + this.b + '}';
    }

    public Xa(Sa sa, List<Sa> list) {
        this.a = sa;
        this.b = list;
    }
}
