package npi.spay;

import android.content.Context;
import dagger.internal.Factory;

/* renamed from: npi.spay.k0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1703k0 implements Factory {
    public final Factory a;

    public C1703k0(Factory factory) {
        this.a = factory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // javax.inject.Provider
    public final Object get() {
        return new C1876qn((Context) this.a.get());
    }
}
