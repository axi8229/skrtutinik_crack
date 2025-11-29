package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.SystemClock;

/* renamed from: com.yandex.metrica.impl.ob.b1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0812b1 {
    private final Handler a;
    private final B b;
    private final RunnableC0837c1 c;

    C0812b1(Handler handler, B b) {
        this.a = handler;
        this.b = b;
        this.c = new RunnableC0837c1(handler, b);
    }

    void a() {
        this.a.removeCallbacks(this.c, this.b.b.b().a());
    }

    void b() {
        a(this.a, this.b, this.c);
    }

    static void a(Handler handler, B b, Runnable runnable) {
        handler.removeCallbacks(runnable, b.b.b().a());
        String strA = b.b.b().a();
        long jUptimeMillis = SystemClock.uptimeMillis();
        Integer numL = b.b.b().l();
        if (numL == null) {
            numL = 10;
        }
        handler.postAtTime(runnable, strA, jUptimeMillis + (numL.intValue() * 500));
    }
}
