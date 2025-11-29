package com.huawei.location.lite.common.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ExecutorManager {
    public static ThreadFactory createThreadFactory(final String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException("ThreadName is empty");
        }
        return new ThreadFactory() { // from class: com.huawei.location.lite.common.util.ExecutorManager.1
            private final AtomicInteger threadNumbers = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Location_" + str + "_" + this.threadNumbers.getAndIncrement());
            }
        };
    }
}
