package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceScreen;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.bb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0822bb {
    public final String a;
    public final List<String> b;
    public final String c;
    public final Map<String, String> d;

    public C0822bb(ECommerceScreen eCommerceScreen) {
        this(eCommerceScreen.getName(), A2.a((Collection) eCommerceScreen.getCategoriesPath()), eCommerceScreen.getSearchQuery(), A2.c(eCommerceScreen.getPayload()));
    }

    public String toString() {
        return "ScreenWrapper{name='" + this.a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + '}';
    }

    public C0822bb(String str, List<String> list, String str2, Map<String, String> map) {
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = map;
    }
}
