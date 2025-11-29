package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.sc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC1243sc implements Runnable {
    final /* synthetic */ C1315vc a;

    RunnableC1243sc(C1315vc c1315vc) {
        this.a = c1315vc;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.e != null) {
            this.a.e.e();
        }
    }
}
