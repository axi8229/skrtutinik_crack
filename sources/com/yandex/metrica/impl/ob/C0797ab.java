package com.yandex.metrica.impl.ob;

import com.yandex.metrica.ecommerce.ECommerceReferrer;

/* renamed from: com.yandex.metrica.impl.ob.ab, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0797ab {
    public final String a;
    public final String b;
    public final C0822bb c;

    public C0797ab(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C0822bb(eCommerceReferrer.getScreen()));
    }

    public String toString() {
        return "ReferrerWrapper{type='" + this.a + "', identifier='" + this.b + "', screen=" + this.c + '}';
    }

    public C0797ab(String str, String str2, C0822bb c0822bb) {
        this.a = str;
        this.b = str2;
        this.c = c0822bb;
    }
}
