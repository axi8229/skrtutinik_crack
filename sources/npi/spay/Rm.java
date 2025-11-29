package npi.spay;

import dagger.internal.Factory;
import dagger.internal.MapProviderFactory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Rm implements Factory {
    public final Provider a;

    public Rm(MapProviderFactory mapProviderFactory) {
        this.a = mapProviderFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new Ql((Map) this.a.get());
    }
}
