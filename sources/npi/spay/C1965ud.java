package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.ud, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1965ud implements Factory {
    public final Provider a;

    public C1965ud(Ne ne) {
        this.a = ne;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Ga((InterfaceC2073yl) this.a.get());
    }
}
