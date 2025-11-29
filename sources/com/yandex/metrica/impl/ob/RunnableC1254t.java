package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC1254t implements Runnable {
    final /* synthetic */ E1 a;
    final /* synthetic */ C1010j0 b;

    RunnableC1254t(C1278u c1278u, E1 e1, C1010j0 c1010j0) {
        this.a = e1;
        this.b = c1010j0;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b);
    }
}
