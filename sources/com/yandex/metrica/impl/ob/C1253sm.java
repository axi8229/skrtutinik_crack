package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.yandex.metrica.impl.ob.sm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1253sm {
    private final ReentrantLock a;
    private final C1277tm b;

    public C1253sm(Context context, String str) {
        this(new ReentrantLock(), new C1277tm(context, str));
    }

    public void a() throws Throwable {
        this.a.lock();
        this.b.a();
    }

    public void b() {
        this.b.b();
        this.a.unlock();
    }

    public void c() {
        this.b.c();
        this.a.unlock();
    }

    C1253sm(ReentrantLock reentrantLock, C1277tm c1277tm) {
        this.a = reentrantLock;
        this.b = c1277tm;
    }
}
