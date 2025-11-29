package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.gm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0958gm {
    private final SystemTimeProvider a;

    public C0958gm() {
        this(new SystemTimeProvider());
    }

    public long a(long j, TimeUnit timeUnit) {
        return TimeUnit.MILLISECONDS.toSeconds(this.a.elapsedRealtime() - timeUnit.toMillis(j));
    }

    public long b(long j, TimeUnit timeUnit) {
        if (j == 0) {
            return 0L;
        }
        return this.a.currentTimeSeconds() - timeUnit.toSeconds(j);
    }

    public long c(long j, TimeUnit timeUnit) {
        return TimeUnit.NANOSECONDS.toSeconds(this.a.systemNanoTime() - timeUnit.toNanos(j));
    }

    public C0958gm(SystemTimeProvider systemTimeProvider) {
        this.a = systemTimeProvider;
    }
}
