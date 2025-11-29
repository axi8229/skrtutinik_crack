package npi.spay;

import dagger.internal.DoubleCheck;
import dagger.internal.MapProviderFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class Oj {
    public static Provider a(MapProviderFactory mapProviderFactory) {
        return DoubleCheck.provider(new Rm(mapProviderFactory));
    }
}
