package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.rc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class RunnableC1219rc implements Runnable {
    final /* synthetic */ C1315vc a;

    RunnableC1219rc(C1315vc c1315vc) {
        this.a = c1315vc;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.e != null) {
                this.a.e.c();
            }
        } catch (Throwable unused) {
        }
    }
}
