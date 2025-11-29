package com.yandex.metrica.networktasks.api;

/* loaded from: classes3.dex */
public interface ExponentialBackoffPolicy {
    boolean canBeExecuted(RetryPolicyConfig retryPolicyConfig);

    void onAllHostsAttemptsFinished(boolean z);

    void onHostAttemptFinished(boolean z);
}
