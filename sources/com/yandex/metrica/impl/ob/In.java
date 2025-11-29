package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public final class In {
    private final boolean a;
    private final String b;

    private In(Kn<?> kn, boolean z, String str) {
        kn.getClass();
        this.a = z;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public static final In a(Kn<?> kn) {
        return new In(kn, true, "");
    }

    public static final In a(Kn<?> kn, String str) {
        return new In(kn, false, str);
    }
}
