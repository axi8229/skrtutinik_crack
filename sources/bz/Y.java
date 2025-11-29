package bz;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class Y extends AbstractC0538n1 {
    public final InterfaceC0531l1 c;

    public Y(W1 w1) {
        super(zone.bi.mobile.fingerprint.api.f.ShareScreen);
        this.c = w1;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return Boolean.valueOf(((W1) this.c).b());
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() {
        return Boolean.valueOf(((W1) this.c).b());
    }
}
