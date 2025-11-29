package com.yandex.metrica.networktasks.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class g {
    private final h a;

    public g() {
        this(new h());
    }

    public g(h timeProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.a = timeProvider;
    }

    public final boolean a(long j, long j2, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return jCurrentTimeMillis < j || jCurrentTimeMillis - j >= j2;
    }
}
