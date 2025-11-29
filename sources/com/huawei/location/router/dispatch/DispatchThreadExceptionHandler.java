package com.huawei.location.router.dispatch;

import java.lang.Thread;

/* loaded from: classes3.dex */
public class DispatchThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    private DispatchBaseRunnable dispatchRunnable;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public DispatchThreadExceptionHandler(DispatchBaseRunnable dispatchBaseRunnable) {
        this.dispatchRunnable = dispatchBaseRunnable;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th instanceof DispatchException) {
            DispatchException dispatchException = (DispatchException) th;
            this.dispatchRunnable.onDispatchError(dispatchException.getExceptionCode(), dispatchException.getMessage());
        } else {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.uncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
