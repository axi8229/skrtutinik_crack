package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.ExponentialBackoffDataHolder;
import com.yandex.metrica.networktasks.api.ExponentialBackoffPolicy;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;

/* renamed from: com.yandex.metrica.impl.ob.ld, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1073ld implements ExponentialBackoffPolicy {
    private final ExponentialBackoffDataHolder a;

    public C1073ld(ExponentialBackoffDataHolder exponentialBackoffDataHolder) {
        this.a = exponentialBackoffDataHolder;
    }

    @Override // com.yandex.metrica.networktasks.api.ExponentialBackoffPolicy
    public boolean canBeExecuted(RetryPolicyConfig retryPolicyConfig) {
        return this.a.wasLastAttemptLongAgoEnough(retryPolicyConfig);
    }

    @Override // com.yandex.metrica.networktasks.api.ExponentialBackoffPolicy
    public void onAllHostsAttemptsFinished(boolean z) {
        if (z) {
            this.a.reset();
        } else {
            this.a.updateLastAttemptInfo();
        }
    }

    @Override // com.yandex.metrica.networktasks.api.ExponentialBackoffPolicy
    public void onHostAttemptFinished(boolean z) {
    }
}
