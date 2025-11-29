package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.em, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractRunnableC0908em implements Runnable {
    public abstract void a() throws Exception;

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }
}
