package bz;

import java.io.Serializable;

/* renamed from: bz.m1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0535m1 extends AbstractC0538n1 {
    public C0535m1() {
        super(zone.bi.mobile.fingerprint.api.f.LocationHash);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        throw new e2("ignored");
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() {
        return String.valueOf(this.a.hashCode());
    }
}
