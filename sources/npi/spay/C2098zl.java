package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.zl, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2098zl implements Factory {
    public final Provider a;

    public C2098zl(Ne ne) {
        this.a = ne;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Zk((InterfaceC2073yl) this.a.get());
    }
}
