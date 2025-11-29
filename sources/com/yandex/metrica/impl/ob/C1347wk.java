package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.wk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1347wk {
    public final int a;
    public final String b;
    private final int c = a();

    public C1347wk(int i, String str) {
        this.a = i;
        this.b = str;
    }

    private int a() {
        return (this.a * 31) + this.b.length();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1347wk.class != obj.getClass()) {
            return false;
        }
        C1347wk c1347wk = (C1347wk) obj;
        if (this.a != c1347wk.a) {
            return false;
        }
        return this.b.equals(c1347wk.b);
    }

    public int hashCode() {
        return this.c;
    }
}
