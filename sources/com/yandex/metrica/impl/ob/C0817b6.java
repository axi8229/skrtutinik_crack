package com.yandex.metrica.impl.ob;

import okhttp3.internal.connection.RealConnection;

/* renamed from: com.yandex.metrica.impl.ob.b6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0817b6 {
    private final L3 a;
    private final C0792a6 b;
    private final a c;
    private final A0 d;
    private final U5<W5> e;
    private final U5<W5> f;
    private V5 g;
    private b h;

    /* renamed from: com.yandex.metrica.impl.ob.b6$a */
    public interface a {
        void a(C0836c0 c0836c0, C0842c6 c0842c6);
    }

    /* renamed from: com.yandex.metrica.impl.ob.b6$b */
    public enum b {
        EMPTY,
        BACKGROUND,
        FOREGROUND
    }

    public C0817b6(L3 l3, C0792a6 c0792a6, a aVar) {
        this(l3, c0792a6, aVar, new T5(l3, c0792a6), new S5(l3, c0792a6), new A0(l3.g()));
    }

    private void e(C0836c0 c0836c0) {
        if (this.h == null) {
            V5 v5B = ((R5) this.e).b();
            if (a(v5B, c0836c0)) {
                this.g = v5B;
                this.h = b.FOREGROUND;
                return;
            }
            V5 v5B2 = ((R5) this.f).b();
            if (a(v5B2, c0836c0)) {
                this.g = v5B2;
                this.h = b.BACKGROUND;
            } else {
                this.g = null;
                this.h = b.EMPTY;
            }
        }
    }

    public synchronized long a() {
        V5 v5;
        v5 = this.g;
        return v5 == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : v5.c() - 1;
    }

    public C0842c6 b(C0836c0 c0836c0) {
        return a(c(c0836c0), c0836c0.e());
    }

    public synchronized V5 c(C0836c0 c0836c0) {
        try {
            e(c0836c0);
            b bVar = this.h;
            b bVar2 = b.EMPTY;
            if (bVar != bVar2 && !a(this.g, c0836c0)) {
                this.h = bVar2;
                this.g = null;
            }
            int iOrdinal = this.h.ordinal();
            if (iOrdinal == 1) {
                this.g.c(c0836c0.e());
                return this.g;
            }
            if (iOrdinal == 2) {
                return this.g;
            }
            this.h = b.BACKGROUND;
            long jE = c0836c0.e();
            V5 v5A = ((R5) this.f).a(new W5(jE, c0836c0.f()));
            if (this.a.x().k()) {
                this.c.a(C0836c0.a(c0836c0, this.d), a(v5A, c0836c0.e()));
            } else if (c0836c0.o() == EnumC0787a1.EVENT_TYPE_FIRST_ACTIVATION.b()) {
                this.c.a(c0836c0, a(v5A, jE));
                this.c.a(C0836c0.a(c0836c0, this.d), a(v5A, jE));
            }
            this.g = v5A;
            return v5A;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(C0836c0 c0836c0) {
        try {
            e(c0836c0);
            int iOrdinal = this.h.ordinal();
            if (iOrdinal == 0) {
                this.g = a(c0836c0);
            } else if (iOrdinal == 1) {
                b(this.g, c0836c0);
                this.g = a(c0836c0);
            } else if (iOrdinal == 2) {
                if (a(this.g, c0836c0)) {
                    this.g.c(c0836c0.e());
                } else {
                    this.g = a(c0836c0);
                }
            }
        } finally {
        }
    }

    public C0842c6 f(C0836c0 c0836c0) {
        V5 v5B;
        if (this.h == null) {
            v5B = ((R5) this.e).b();
            if (v5B == null ? false : v5B.b(c0836c0.e())) {
                v5B = ((R5) this.f).b();
                if (v5B != null ? v5B.b(c0836c0.e()) : false) {
                    v5B = null;
                }
            }
        } else {
            v5B = this.g;
        }
        if (v5B != null) {
            return new C0842c6().c(v5B.c()).a(v5B.e()).b(v5B.d()).a(v5B.f());
        }
        long jF = c0836c0.f();
        long jA = this.b.a();
        L7 l7I = this.a.i();
        EnumC0917f6 enumC0917f6 = EnumC0917f6.BACKGROUND;
        l7I.a(jA, enumC0917f6, jF);
        return new C0842c6().c(jA).a(enumC0917f6).a(0L).b(0L);
    }

    public synchronized void g(C0836c0 c0836c0) {
        try {
            c(c0836c0).a(false);
            b bVar = this.h;
            b bVar2 = b.EMPTY;
            if (bVar != bVar2) {
                b(this.g, c0836c0);
            }
            this.h = bVar2;
        } catch (Throwable th) {
            throw th;
        }
    }

    private V5 a(C0836c0 c0836c0) {
        long jE = c0836c0.e();
        V5 v5A = ((R5) this.e).a(new W5(jE, c0836c0.f()));
        this.h = b.FOREGROUND;
        this.a.l().c();
        this.c.a(C0836c0.a(c0836c0, this.d), a(v5A, jE));
        return v5A;
    }

    private void b(V5 v5, C0836c0 c0836c0) {
        if (v5.h()) {
            this.c.a(C0836c0.a(c0836c0), new C0842c6().c(v5.c()).a(v5.f()).a(v5.e()).b(v5.b()));
            v5.a(false);
        }
        v5.i();
    }

    public C0817b6(L3 l3, C0792a6 c0792a6, a aVar, U5<W5> u5, U5<W5> u52, A0 a0) {
        this.h = null;
        this.a = l3;
        this.c = aVar;
        this.e = u5;
        this.f = u52;
        this.b = c0792a6;
        this.d = a0;
    }

    private boolean a(V5 v5, C0836c0 c0836c0) {
        if (v5 == null) {
            return false;
        }
        if (v5.b(c0836c0.e())) {
            return true;
        }
        b(v5, c0836c0);
        return false;
    }

    private C0842c6 a(V5 v5, long j) {
        return new C0842c6().c(v5.c()).a(v5.e()).b(v5.a(j)).a(v5.f());
    }
}
