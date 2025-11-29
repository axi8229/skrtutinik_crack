package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.n5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1783n5 implements Factory {
    public final Provider a;

    public C1783n5(Provider provider) {
        this.a = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new F4((Ih) this.a.get());
    }
}
