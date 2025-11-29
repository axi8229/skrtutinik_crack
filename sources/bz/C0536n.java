package bz;

import java.io.Serializable;

/* renamed from: bz.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0536n extends AbstractC0538n1 implements A0 {
    public final Z0 c;

    public C0536n(Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.AgentSignalTypeCellular);
        this.c = z0;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.c;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        String str = (String) a(A0.n);
        if (str != null) {
            return str;
        }
        throw new e2("cachedValue == null");
    }
}
