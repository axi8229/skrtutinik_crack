package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.z7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC1406z7 implements Runnable {
    final /* synthetic */ InterfaceC1132nm a;
    final /* synthetic */ C1382y7 b;

    RunnableC1406z7(C1382y7 c1382y7, InterfaceC1132nm interfaceC1132nm) {
        this.b = c1382y7;
        this.a = interfaceC1132nm;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.a);
    }
}
