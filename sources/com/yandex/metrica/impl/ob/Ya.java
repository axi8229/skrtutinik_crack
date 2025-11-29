package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceProduct;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Ya {
    public final String a;
    public final String b;
    public final List<String> c;
    public final Map<String, String> d;
    public final Xa e;
    public final Xa f;
    public final List<String> g;

    public Ya(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), A2.a((Collection) eCommerceProduct.getCategoriesPath()), A2.c(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new Xa(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() == null ? null : new Xa(eCommerceProduct.getOriginalPrice()), A2.a((Collection) eCommerceProduct.getPromocodes()));
    }

    public String toString() {
        return "ProductWrapper{sku='" + this.a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + '}';
    }

    public Ya(String str, String str2, List<String> list, Map<String, String> map, Xa xa, Xa xa2, List<String> list2) {
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = xa;
        this.f = xa2;
        this.g = list2;
    }
}
