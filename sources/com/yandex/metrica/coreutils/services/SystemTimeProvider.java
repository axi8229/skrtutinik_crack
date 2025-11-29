package com.yandex.metrica.coreutils.services;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class SystemTimeProvider implements TimeProvider {
    @Override // com.yandex.metrica.coreutils.services.TimeProvider
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.yandex.metrica.coreutils.services.TimeProvider
    public long currentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Override // com.yandex.metrica.coreutils.services.TimeProvider
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long systemNanoTime() {
        return System.nanoTime();
    }
}
