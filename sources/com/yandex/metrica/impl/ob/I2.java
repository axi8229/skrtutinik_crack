package com.yandex.metrica.impl.ob;

import java.util.List;

/* loaded from: classes3.dex */
public class I2 extends AbstractC1305v2<List<F2>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public I2() {
        long j = G.e.b;
        this(j, 2 * j);
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected long b(Ph ph) {
        return ph.b;
    }

    I2(long j, long j2) {
        super(j, j2);
    }

    @Override // com.yandex.metrica.impl.ob.G0
    protected long a(Ph ph) {
        return ph.b * 2;
    }
}
