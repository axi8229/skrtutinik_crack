package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            lazySet(AbstractDirectTask.FINISHED);
            RxJavaPlugins.onError(th);
        }
    }
}
