package com.yandex.metrica.networktasks.impl;

import com.yandex.metrica.networktasks.api.ExponentialBackoffPolicy;
import com.yandex.metrica.networktasks.api.IExecutionPolicy;
import com.yandex.metrica.networktasks.api.NetworkTask;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class f implements Runnable {
    private final NetworkTask a;
    private final c b;
    private final d c;

    public f(NetworkTask networkTask, c rootThreadStateSource, d taskPerformingStrategy) {
        Intrinsics.checkNotNullParameter(networkTask, "networkTask");
        Intrinsics.checkNotNullParameter(rootThreadStateSource, "rootThreadStateSource");
        Intrinsics.checkNotNullParameter(taskPerformingStrategy, "taskPerformingStrategy");
        this.a = networkTask;
        this.b = rootThreadStateSource;
        this.c = taskPerformingStrategy;
    }

    @Override // java.lang.Runnable
    public void run() {
        ExponentialBackoffPolicy exponentialBackoffPolicy = this.a.getExponentialBackoffPolicy();
        Intrinsics.checkNotNullExpressionValue(exponentialBackoffPolicy, "networkTask.exponentialBackoffPolicy");
        IExecutionPolicy connectionExecutionPolicy = this.a.getConnectionExecutionPolicy();
        Intrinsics.checkNotNullExpressionValue(connectionExecutionPolicy, "networkTask.connectionExecutionPolicy");
        if (!this.b.isRunning() || !connectionExecutionPolicy.canBeExecuted() || !exponentialBackoffPolicy.canBeExecuted(this.a.getRetryPolicyConfig())) {
            this.a.onShouldNotExecute();
            return;
        }
        boolean zOnCreateNetworkTask = this.a.onCreateNetworkTask();
        Boolean boolValueOf = null;
        while (this.b.isRunning() && zOnCreateNetworkTask && exponentialBackoffPolicy.canBeExecuted(this.a.getRetryPolicyConfig())) {
            boolean zA = this.c.a(this.a);
            boolValueOf = Boolean.valueOf(zA);
            boolean z = !zA && this.a.shouldTryNextHost();
            exponentialBackoffPolicy.onHostAttemptFinished(zA);
            zOnCreateNetworkTask = z;
        }
        if (boolValueOf != null) {
            exponentialBackoffPolicy.onAllHostsAttemptsFinished(boolValueOf.booleanValue());
        }
    }
}
