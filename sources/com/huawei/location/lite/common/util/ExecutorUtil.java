package com.huawei.location.lite.common.util;

import com.huawei.location.lite.common.log.LogLocation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ExecutorUtil {
    private final ThreadPoolExecutor executor;
    private final ScheduledThreadPoolExecutor scheduledExecutor;

    private static class ExecutorsHolder {
        private static final ExecutorUtil INSTANCE = new ExecutorUtil();
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(1);
        private final String poolName;

        NamedThreadFactory(String str) {
            this.poolName = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.poolName + "-" + this.counter.getAndIncrement());
        }
    }

    private ExecutorUtil() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 60L, timeUnit, new LinkedBlockingQueue(), new NamedThreadFactory("Location-Task"));
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, new NamedThreadFactory("Loc-Task-Delay"));
        this.scheduledExecutor = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static ExecutorUtil getInstance() {
        return ExecutorsHolder.INSTANCE;
    }

    public void execute(Runnable runnable) {
        try {
            getExecutor().execute(runnable);
        } catch (Throwable unused) {
            LogLocation.e("ExecutorUtil", "ExecutorUtil fatal error", true);
        }
    }

    public void execute(FutureTask futureTask) {
        try {
            Thread thread = new Thread(futureTask);
            thread.setName(Thread.currentThread().getName());
            thread.start();
        } catch (Throwable unused) {
            LogLocation.e("ExecutorUtil", "ExecutorUtil futureTask error", true);
        }
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }
}
