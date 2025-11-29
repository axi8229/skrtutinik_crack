package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.x2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1353x2 {
    private final TimeProvider a;

    public C1353x2() {
        this(new SystemTimeProvider());
    }

    private boolean a(long j, long j2, long j3) {
        return j < j2 || j - j2 >= j3;
    }

    public boolean a(long j, long j2, String str) {
        return a(this.a.currentTimeMillis(), j, j2);
    }

    public boolean b(long j, long j2, String str) {
        return a(this.a.currentTimeSeconds(), j, j2);
    }

    C1353x2(TimeProvider timeProvider) {
        this.a = timeProvider;
    }
}
