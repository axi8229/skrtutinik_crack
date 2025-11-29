package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C0937g1;
import com.yandex.metrica.impl.ob.Dg;
import com.yandex.metrica.impl.ob.Eg;
import com.yandex.metrica.impl.ob.Eg.d;

/* loaded from: classes3.dex */
public abstract class Gg<T extends Eg, IA, A extends Dg<IA, A>, L extends Eg.d<T, Eg.c<A>>> implements C0937g1.a {
    private T a;
    private L b;
    private Eg.c<A> c;

    public Gg(L l, C1178pi c1178pi, A a) {
        this.b = l;
        C0937g1.a(F0.g().e()).a(this);
        a((Eg.c) new Eg.c<>(c1178pi, a));
    }

    @Override // com.yandex.metrica.impl.ob.C0937g1.a
    public void a() {
        synchronized (this) {
            this.a = null;
        }
    }

    public synchronized T b() {
        try {
            if (this.a == null) {
                this.a = (T) this.b.a(this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a;
    }

    public synchronized A c() {
        return this.c.b;
    }

    public synchronized C1178pi d() {
        return this.c.a;
    }

    public synchronized void e() {
        this.a = null;
    }

    protected synchronized void a(Eg.c<A> cVar) {
        this.c = cVar;
    }

    public synchronized void a(IA ia) {
        try {
            if (!this.c.b.b(ia)) {
                synchronized (this) {
                    Eg.c<A> cVar = this.c;
                    Eg.c<A> cVar2 = new Eg.c<>(cVar.a, cVar.b.a(ia));
                    synchronized (this) {
                        this.c = cVar2;
                    }
                }
                synchronized (this) {
                    this.a = null;
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.yandex.metrica.impl.ob.C1178pi r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.yandex.metrica.impl.ob.Eg$c r0 = new com.yandex.metrica.impl.ob.Eg$c     // Catch: java.lang.Throwable -> L19
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L19
            com.yandex.metrica.impl.ob.Eg$c<A extends com.yandex.metrica.impl.ob.Dg<IA, A>> r1 = r2.c     // Catch: java.lang.Throwable -> L21
            A r1 = r1.b     // Catch: java.lang.Throwable -> L21
            com.yandex.metrica.impl.ob.Dg r1 = (com.yandex.metrica.impl.ob.Dg) r1     // Catch: java.lang.Throwable -> L21
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> L19
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L19
            r2.c = r0     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L19
            r3 = 0
            r2.a = r3     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r2)
            return
        L19:
            r3 = move-exception
            goto L24
        L1b:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            throw r3     // Catch: java.lang.Throwable -> L19
        L1e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            throw r3     // Catch: java.lang.Throwable -> L19
        L21:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            throw r3     // Catch: java.lang.Throwable -> L19
        L24:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L19
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Gg.a(com.yandex.metrica.impl.ob.pi):void");
    }
}
