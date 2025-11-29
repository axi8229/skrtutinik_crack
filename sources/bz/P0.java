package bz;

import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes.dex */
public final class P0 extends AbstractC0538n1 implements A0 {
    public final Z0 c;

    public P0(Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.AppKey);
        this.c = z0;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.c;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        String str = (String) a(A0.n);
        if (str != null) {
            return str;
        }
        String string = UUID.randomUUID().toString();
        a(string);
        return string;
    }
}
