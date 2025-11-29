package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;

/* loaded from: classes3.dex */
public class Q {
    private SystemTimeProvider a;

    public Q() {
        this(new SystemTimeProvider());
    }

    public void a() {
        this.a.elapsedRealtime();
    }

    Q(SystemTimeProvider systemTimeProvider) {
        this.a = systemTimeProvider;
    }
}
