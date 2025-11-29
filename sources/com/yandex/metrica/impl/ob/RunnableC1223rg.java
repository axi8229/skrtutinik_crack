package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.rg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC1223rg implements Runnable {
    final /* synthetic */ InterfaceC1319vg a;
    final /* synthetic */ Throwable b;

    RunnableC1223rg(C1200qg c1200qg, InterfaceC1319vg interfaceC1319vg, Throwable th) {
        this.a = interfaceC1319vg;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b);
    }
}
