package com.yandex.metrica.impl.ob;

import java.util.concurrent.Callable;

/* renamed from: com.yandex.metrica.impl.ob.dm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractCallableC0883dm<T> implements Callable<T> {
    public abstract T a() throws Exception;

    @Override // java.util.concurrent.Callable
    public T call() {
        try {
            return a();
        } catch (Throwable unused) {
            return null;
        }
    }
}
