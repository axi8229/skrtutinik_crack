package com.yandex.metrica;

import java.util.Map;

/* loaded from: classes3.dex */
public class g {
    private String a;
    private String b;
    private Map<String, String> c;

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.a;
        if (str == null ? gVar.a != null : !str.equals(gVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? gVar.b != null : !str2.equals(gVar.b)) {
            return false;
        }
        Map<String, String> map = this.c;
        Map<String, String> map2 = gVar.c;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.c;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public Map<String, String> a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public void a(Map<String, String> map) {
        this.c = map;
    }
}
