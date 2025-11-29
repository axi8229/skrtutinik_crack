package com.yandex.metrica.networktasks.api;

import com.yandex.metrica.networktasks.impl.g;
import com.yandex.metrica.networktasks.impl.h;

/* loaded from: classes3.dex */
public class ExponentialBackoffDataHolder {
    private final g a;
    private final h b;
    private final HostRetryInfoProvider c;
    private long d;
    private int e;

    public ExponentialBackoffDataHolder(HostRetryInfoProvider hostRetryInfoProvider) {
        this(hostRetryInfoProvider, new h(), new g());
    }

    ExponentialBackoffDataHolder(HostRetryInfoProvider hostRetryInfoProvider, h hVar, g gVar) {
        this.c = hostRetryInfoProvider;
        this.b = hVar;
        this.a = gVar;
        this.d = hostRetryInfoProvider.getLastAttemptTimeSeconds();
        this.e = hostRetryInfoProvider.getNextSendAttemptNumber();
    }

    public void reset() {
        this.e = 1;
        this.d = 0L;
        this.c.saveNextSendAttemptNumber(1);
        this.c.saveLastAttemptTimeSeconds(this.d);
    }

    public void updateLastAttemptInfo() {
        this.b.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        this.d = jCurrentTimeMillis;
        this.e++;
        this.c.saveLastAttemptTimeSeconds(jCurrentTimeMillis);
        this.c.saveNextSendAttemptNumber(this.e);
    }

    public boolean wasLastAttemptLongAgoEnough(RetryPolicyConfig retryPolicyConfig) {
        if (retryPolicyConfig != null) {
            long j = this.d;
            if (j != 0) {
                g gVar = this.a;
                int i = retryPolicyConfig.exponentialMultiplier * ((1 << (this.e - 1)) - 1);
                int i2 = retryPolicyConfig.maxIntervalSeconds;
                if (i > i2) {
                    i = i2;
                }
                return gVar.a(j, i, "last send attempt");
            }
        }
        return true;
    }
}
