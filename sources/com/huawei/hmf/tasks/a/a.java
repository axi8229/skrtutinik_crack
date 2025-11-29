package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class a {
    private static final a a = new a();
    private static final int c;
    private static final int d;
    private static final int e;
    private final Executor b = new ExecutorC0076a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    static class ExecutorC0076a implements Executor {
        private ExecutorC0076a() {
        }

        /* synthetic */ ExecutorC0076a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        d = iAvailableProcessors + 1;
        e = (iAvailableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return a.b;
    }
}
