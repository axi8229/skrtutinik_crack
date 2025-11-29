package bz;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* renamed from: bz.v1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0561v1 extends AbstractC0538n1 {
    public final F1 c;
    public boolean d;
    public long e;

    public C0561v1(F1 f1) {
        super(zone.bi.mobile.fingerprint.api.f.RdpConnectionDuration);
        this.c = f1;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        long jCurrentTimeMillis;
        if (!this.c.h().equals(F1.f)) {
            this.d = false;
            jCurrentTimeMillis = 0;
        } else {
            if (this.d) {
                return Integer.valueOf(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.e)).intValue());
            }
            this.d = true;
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.e = jCurrentTimeMillis;
        return 0;
    }
}
