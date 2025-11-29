package com.yandex.metrica;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.P;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class a {
    private final ICommonExecutor a;
    private final Set<b> b;
    private boolean c;

    /* renamed from: com.yandex.metrica.a$a, reason: collision with other inner class name */
    public interface InterfaceC0279a {
        void a();

        void b();
    }

    private class b {
        final ICommonExecutor a;
        final InterfaceC0279a b;
        private final long c;
        private boolean d = true;
        private final Runnable e = new RunnableC0280a();

        /* renamed from: com.yandex.metrica.a$b$a, reason: collision with other inner class name */
        class RunnableC0280a implements Runnable {
            RunnableC0280a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.a();
            }
        }

        b(a aVar, InterfaceC0279a interfaceC0279a, ICommonExecutor iCommonExecutor, long j) {
            this.b = interfaceC0279a;
            this.a = iCommonExecutor;
            this.c = j;
        }

        void a() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.executeDelayed(this.e, this.c);
        }

        void b() {
            if (this.d) {
                this.d = false;
                this.a.remove(this.e);
                this.b.b();
            }
        }
    }

    public a(long j) {
        this(j, P.g().d().b());
    }

    public synchronized void a() {
        this.c = true;
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized void b() {
        this.c = false;
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    a(long j, ICommonExecutor iCommonExecutor) {
        this.b = new HashSet();
        this.c = true;
        this.a = iCommonExecutor;
    }

    public synchronized void a(InterfaceC0279a interfaceC0279a, long j) {
        synchronized (this) {
            this.b.add(new b(this, interfaceC0279a, this.a, j));
        }
    }
}
