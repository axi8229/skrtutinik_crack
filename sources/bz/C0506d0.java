package bz;

import java.io.Serializable;

/* renamed from: bz.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0506d0 extends AbstractC0538n1 implements A0 {
    public final Z0 c;

    public C0506d0(Z0 z0) {
        super(zone.bi.mobile.fingerprint.api.f.OSFontsHash);
        this.c = z0;
    }

    @Override // bz.A0
    public final Z0 f() {
        return this.c;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        Integer num = (Integer) a(A0.n);
        if (num != null) {
            return num;
        }
        throw new e2("cachedValue == null");
    }
}
