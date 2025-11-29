package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Ub<T> implements Qb<T> {
    private ICommonExecutor a;
    private volatile Runnable b;

    public Ub(ICommonExecutor iCommonExecutor) {
        this.a = iCommonExecutor;
    }

    void a(Runnable runnable, long j) {
        this.a.executeDelayed(runnable, j, TimeUnit.SECONDS);
        this.b = runnable;
    }

    @Override // com.yandex.metrica.impl.ob.Qb
    public void a() {
        Runnable runnable = this.b;
        if (runnable != null) {
            this.a.remove(runnable);
            this.b = null;
        }
    }
}
