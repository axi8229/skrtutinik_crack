package com.yandex.metrica.impl.ob;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class H6 {
    public final F6 a;
    public final C1333w6 b;
    public final List<D6> c;
    public final String d;
    public final String e;
    public final Map<String, String> f;
    public final String g;
    public final Boolean h;

    public H6(F6 f6, C1333w6 c1333w6, List<D6> list, String str, String str2, Map<String, String> map, String str3, Boolean bool) {
        this.a = f6;
        this.b = c1333w6;
        this.c = list;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = str3;
        this.h = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        F6 f6 = this.a;
        if (f6 != null) {
            for (D6 d6 : f6.d()) {
                sb.append("at " + d6.a() + "." + d6.e() + "(" + d6.c() + ":" + d6.d() + ":" + d6.b() + ")\n");
            }
        }
        return "UnhandledException{exception=" + this.a + "\n" + sb.toString() + '}';
    }
}
