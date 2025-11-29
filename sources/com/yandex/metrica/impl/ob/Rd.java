package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Rd {
    private final String a;
    private final String b;

    public Rd(String str) {
        this(str, null);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public Rd(String str, String str2) {
        this.a = str;
        this.b = a(str2);
    }

    public final String a(String str) {
        if (str == null) {
            return this.a;
        }
        return this.a + str;
    }
}
