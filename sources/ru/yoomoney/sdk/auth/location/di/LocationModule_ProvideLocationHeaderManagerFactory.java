package ru.yoomoney.sdk.auth.location.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.auth.location.LocationHeaderManager;

/* loaded from: classes4.dex */
public final class LocationModule_ProvideLocationHeaderManagerFactory implements Factory<LocationHeaderManager> {

    public static final class a {
        public static final LocationModule_ProvideLocationHeaderManagerFactory a = new LocationModule_ProvideLocationHeaderManagerFactory();
    }

    public static LocationModule_ProvideLocationHeaderManagerFactory create() {
        return a.a;
    }

    public static LocationHeaderManager provideLocationHeaderManager() {
        return (LocationHeaderManager) Preconditions.checkNotNullFromProvides(LocationModule.INSTANCE.provideLocationHeaderManager());
    }

    @Override // javax.inject.Provider
    public LocationHeaderManager get() {
        return provideLocationHeaderManager();
    }
}
