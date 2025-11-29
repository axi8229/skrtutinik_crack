package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.H0;

/* loaded from: classes3.dex */
public abstract class G0<T> implements H0.d {
    protected final G<T> a;
    private H0 b;

    public G0(long j, long j2) {
        this.a = new G<>(j, j2);
    }

    protected abstract long a(Ph ph);

    public T a() {
        H0 h0;
        if (b() && (h0 = this.b) != null) {
            h0.b();
        }
        if (this.a.c()) {
            this.a.a(null);
        }
        return this.a.a();
    }

    protected abstract boolean a(T t);

    protected abstract long b(Ph ph);

    public void b(T t) {
        if (a((G0<T>) t)) {
            this.a.a(t);
            H0 h0 = this.b;
            if (h0 != null) {
                h0.a();
            }
        }
    }

    public abstract boolean b();

    public void c(Ph ph) {
        this.a.a(b(ph), a(ph));
    }

    public void a(H0 h0) {
        this.b = h0;
    }
}
