package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Z8 extends AbstractC0870d9 {
    private static final Rd c = new Rd("LAST_SATELLITE_CLIDS_DIAGNOSTICS_SENT_TIME", null);
    private static final Rd d = new Rd("LAST_PRELOAD_INFO_DIAGNOSTICS_SENT_TIME", null);

    public Z8(S7 s7) {
        super(s7);
    }

    public long b(long j) {
        return a(c.a(), j);
    }

    public long c(long j) {
        return a(d.a(), j);
    }

    public Z8 d(long j) {
        return (Z8) b(c.a(), j);
    }

    public Z8 e(long j) {
        return (Z8) b(d.a(), j);
    }
}
