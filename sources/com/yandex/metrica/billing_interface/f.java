package com.yandex.metrica.billing_interface;

/* loaded from: classes3.dex */
public abstract class f implements Runnable {
    public abstract void a() throws Throwable;

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }
}
