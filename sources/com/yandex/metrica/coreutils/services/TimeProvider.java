package com.yandex.metrica.coreutils.services;

/* loaded from: classes3.dex */
public interface TimeProvider {
    long currentTimeMillis();

    long currentTimeSeconds();

    long elapsedRealtime();
}
