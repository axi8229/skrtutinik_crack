package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
abstract class ExecutionModule {
    @SuppressLint({"ThreadPoolCreation"})
    static Executor executor() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
