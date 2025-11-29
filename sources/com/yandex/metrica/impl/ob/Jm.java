package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Jm implements IHandlerExecutor {
    private final Looper a;
    private final Handler b;
    private final Km c;

    public Jm(String str) {
        this(a(str));
    }

    private static Km a(String str) {
        Km kmB = new Mm(str).b();
        kmB.start();
        return kmB;
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor
    public void executeDelayed(Runnable runnable, long j) {
        this.b.postDelayed(runnable, TimeUnit.MILLISECONDS.toMillis(j));
    }

    @Override // com.yandex.metrica.core.api.executors.IHandlerExecutor
    public Handler getHandler() {
        return this.b;
    }

    @Override // com.yandex.metrica.core.api.executors.IHandlerExecutor
    public Looper getLooper() {
        return this.a;
    }

    public boolean isRunning() {
        return this.c.isRunning();
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor
    public void remove(Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor
    public void removeAll() {
        this.b.removeCallbacksAndMessages(null);
    }

    public void stopRunning() {
        this.c.stopRunning();
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor
    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    Jm(Km km) {
        this(km, km.getLooper(), new Handler(km.getLooper()));
    }

    public Jm(Km km, Looper looper, Handler handler) {
        this.c = km;
        this.a = looper;
        this.b = handler;
    }

    @Override // com.yandex.metrica.core.api.executors.ICommonExecutor
    public void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
