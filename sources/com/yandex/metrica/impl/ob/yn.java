package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.impl.ob.zn;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class yn<D> implements wn<D> {
    private final Comparator<D> a;
    private final int b;
    private final TimeProvider c;
    final long d;
    private D e;
    private int f;
    private long g;

    public yn(Comparator<D> comparator, TimeProvider timeProvider, int i, long j) {
        this.a = comparator;
        this.b = i;
        this.c = timeProvider;
        this.d = TimeUnit.SECONDS.toMillis(j);
    }

    private void a() {
        this.f = 0;
        this.g = this.c.elapsedRealtime();
    }

    @Override // com.yandex.metrica.impl.ob.wn
    public zn<D> get(D d) {
        D d2 = this.e;
        if (d2 != d) {
            if (this.a.compare(d2, d) != 0) {
                this.e = d;
                a();
                return new zn<>(zn.a.NEW, this.e);
            }
            this.e = d;
        }
        int i = this.f + 1;
        this.f = i;
        this.f = i % this.b;
        if (this.c.elapsedRealtime() - this.g >= this.d) {
            a();
            return new zn<>(zn.a.REFRESH, this.e);
        }
        if (this.f != 0) {
            return new zn<>(zn.a.NOT_CHANGED, this.e);
        }
        a();
        return new zn<>(zn.a.REFRESH, this.e);
    }
}
