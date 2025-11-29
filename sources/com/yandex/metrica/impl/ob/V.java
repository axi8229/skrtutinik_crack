package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public abstract class V {
    private V a;

    public V(V v) {
        this.a = v;
    }

    public void a(Object obj) {
        b(obj);
        V v = this.a;
        if (v != null) {
            v.a(obj);
        }
    }

    public abstract void b(Object obj);
}
