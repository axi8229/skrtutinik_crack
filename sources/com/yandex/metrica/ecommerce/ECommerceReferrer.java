package com.yandex.metrica.ecommerce;

/* loaded from: classes3.dex */
public class ECommerceReferrer {
    private String a;
    private String b;
    private ECommerceScreen c;

    public String getIdentifier() {
        return this.b;
    }

    public ECommerceScreen getScreen() {
        return this.c;
    }

    public String getType() {
        return this.a;
    }

    public ECommerceReferrer setIdentifier(String str) {
        this.b = str;
        return this;
    }

    public ECommerceReferrer setScreen(ECommerceScreen eCommerceScreen) {
        this.c = eCommerceScreen;
        return this;
    }

    public ECommerceReferrer setType(String str) {
        this.a = str;
        return this;
    }

    public String toString() {
        return "ECommerceReferrer{type='" + this.a + "', identifier='" + this.b + "', screen=" + this.c + '}';
    }
}
