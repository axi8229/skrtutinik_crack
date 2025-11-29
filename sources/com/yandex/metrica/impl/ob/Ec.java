package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Ec<T> implements InterfaceC1172pc<T> {
    private final Dc<T> a;
    private final Lb<T> b;
    private final Gc c;
    private final Qb<T> d;
    private final Runnable e = new a();
    private T f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ec.this.b();
        }
    }

    public Ec(Dc<T> dc, Lb<T> lb, Gc gc, Qb<T> qb, T t) {
        this.a = dc;
        this.b = lb;
        this.c = gc;
        this.d = qb;
        this.f = t;
    }

    public void a() {
        T t = this.f;
        if (t != null && this.b.a(t) && this.a.a(this.f)) {
            this.c.a();
            this.d.a(this.e, this.f);
        }
    }

    public void b() {
        this.d.a();
        this.a.a();
    }

    public void c() {
        T t = this.f;
        if (t != null && this.b.b(t)) {
            this.a.b();
        }
        a();
    }

    public void a(T t) {
        if (A2.a(this.f, t)) {
            return;
        }
        this.f = t;
        b();
        a();
    }
}
