package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
class Dk implements Yk {
    private final C1130nk a;

    Dk() {
        this(new C1130nk());
    }

    @Override // com.yandex.metrica.impl.ob.Yk
    public boolean a(String str, C1348wl c1348wl) {
        if (!c1348wl.g) {
            return !A2.a("allow-parsing", str);
        }
        this.a.getClass();
        return A2.a("do-not-parse", str);
    }

    Dk(C1130nk c1130nk) {
        this.a = c1130nk;
    }
}
