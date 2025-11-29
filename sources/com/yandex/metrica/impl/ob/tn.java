package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public abstract class tn<T> {
    public final T a;

    public tn(T t) {
        this.a = t;
    }

    protected abstract boolean a(tn<T> tnVar);

    public boolean equals(Object obj) {
        if (obj instanceof tn) {
            try {
                return a((tn) obj);
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }
}
