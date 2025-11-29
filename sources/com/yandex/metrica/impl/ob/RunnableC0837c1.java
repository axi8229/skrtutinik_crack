package com.yandex.metrica.impl.ob;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.yandex.metrica.impl.ob.c1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC0837c1 implements Runnable {
    private final WeakReference<Handler> a;
    private final WeakReference<B> b;

    RunnableC0837c1(Handler handler, B b) {
        this.a = new WeakReference<>(handler);
        this.b = new WeakReference<>(b);
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = this.a.get();
        B b = this.b.get();
        if (handler == null || b == null || !b.e()) {
            return;
        }
        C0812b1.a(handler, b, this);
    }
}
