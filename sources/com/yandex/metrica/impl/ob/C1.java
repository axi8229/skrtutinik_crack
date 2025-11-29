package com.yandex.metrica.impl.ob;

import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class C1 implements Thread.UncaughtExceptionHandler {
    private static final AtomicBoolean f = new AtomicBoolean();
    private final List<A6> a;
    private final Thread.UncaughtExceptionHandler b;
    private final C1038k3 c;
    private final InterfaceC0833bm d;
    private final C0989i3 e;

    C1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, List<A6> list, InterfaceC0833bm interfaceC0833bm, C0989i3 c0989i3, C1038k3 c1038k3) {
        this.a = list;
        this.b = uncaughtExceptionHandler;
        this.d = interfaceC0833bm;
        this.e = c0989i3;
        this.c = c1038k3;
    }

    public static boolean a() {
        return f.get();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            f.set(true);
            C1333w6 c1333w6 = new C1333w6(this.e.a(thread), this.c.a(thread), ((Xl) this.d).b());
            Iterator<A6> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(th, c1333w6);
            }
        } finally {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
