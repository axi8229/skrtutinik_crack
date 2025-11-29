package com.yandex.metrica.ecommerce;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ECommerceScreen {
    private String a;
    private List<String> b;
    private String c;
    private Map<String, String> d;

    public List<String> getCategoriesPath() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public Map<String, String> getPayload() {
        return this.d;
    }

    public String getSearchQuery() {
        return this.c;
    }

    public ECommerceScreen setCategoriesPath(List<String> list) {
        this.b = list;
        return this;
    }

    public ECommerceScreen setName(String str) {
        this.a = str;
        return this;
    }

    public ECommerceScreen setPayload(Map<String, String> map) {
        this.d = map;
        return this;
    }

    public ECommerceScreen setSearchQuery(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "ECommerceScreen{name='" + this.a + "', categoriesPath=" + this.b + ", searchQuery='" + this.c + "', payload=" + this.d + '}';
    }
}
