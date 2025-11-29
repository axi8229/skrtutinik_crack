package com.huawei.updatesdk.b.g;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class c {
    public static final ThreadPoolExecutor a;
    public static final ThreadPoolExecutor b;

    private static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger();
        private String b;

        public a(String str) {
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.b + "#" + this.a.incrementAndGet());
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = new ThreadPoolExecutor(2, 2, 10L, timeUnit, new LinkedBlockingQueue(), new a("UpdateSDK-ServerTask"));
        b = new ThreadPoolExecutor(0, 2, 5L, timeUnit, new LinkedBlockingQueue(), new a("UpdateSDK-CheckTask"));
    }
}
