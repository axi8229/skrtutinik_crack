package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceCartItem;
import com.yandex.metrica.ecommerce.ECommerceOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class Wa {
    public final String a;
    public final String b;
    public final List<Ua> c;
    public final Map<String, String> d;

    public Wa(ECommerceOrder eCommerceOrder) {
        this(UUID.randomUUID().toString(), eCommerceOrder.getIdentifier(), a(eCommerceOrder.getCartItems()), A2.c(eCommerceOrder.getPayload()));
    }

    private static List<Ua> a(List<ECommerceCartItem> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ECommerceCartItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Ua(it.next()));
        }
        return arrayList;
    }

    public String toString() {
        return "OrderWrapper{uuid='" + this.a + "', identifier='" + this.b + "', cartItems=" + this.c + ", payload=" + this.d + '}';
    }

    public Wa(String str, String str2, List<Ua> list, Map<String, String> map) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
    }
}
