package npi.spay;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Zm implements Factory {
    public final Provider a;
    public final Provider b;

    public Zm(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new C1824ol((C1951u) this.a.get(), (Ih) this.b.get());
    }
}
