package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* loaded from: classes3.dex */
public class E4 {
    private Long a;
    private int b;
    private TimeProvider c;

    public static class a {
        public final long a;
        public final long b;
        public final int c;

        public a(long j, long j2, int i) {
            this.a = j;
            this.c = i;
            this.b = j2;
        }
    }

    public E4() {
        this(new SystemTimeProvider());
    }

    public a a() {
        if (this.a == null) {
            this.a = Long.valueOf(this.c.currentTimeSeconds());
        }
        long jLongValue = this.a.longValue();
        long jLongValue2 = this.a.longValue();
        int i = this.b;
        a aVar = new a(jLongValue, jLongValue2, i);
        this.b = i + 1;
        return aVar;
    }

    public E4(TimeProvider timeProvider) {
        this.c = timeProvider;
    }
}
