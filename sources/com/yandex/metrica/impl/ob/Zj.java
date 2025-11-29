package com.yandex.metrica.impl.ob;

import java.util.List;

/* loaded from: classes3.dex */
public final class Zj {
    private final List<Tj> a;
    private final C1298uj b;
    private final int c;

    public Zj(Yj<C1298uj> yj, Yj<List<Tj>> yj2, Yj<Integer> yj3) {
        this.b = (C1298uj) ((C1346wj) yj).b();
        this.a = (List) ((Uj) yj2).b();
        this.c = ((Integer) ((C1226rj) yj3).a()).intValue();
    }

    public int a() {
        return this.c;
    }

    public C1298uj b() {
        return this.b;
    }

    public List<Tj> c() {
        return this.a;
    }
}
