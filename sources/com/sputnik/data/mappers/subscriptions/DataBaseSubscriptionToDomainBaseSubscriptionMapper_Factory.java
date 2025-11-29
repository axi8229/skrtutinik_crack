package com.sputnik.data.mappers.subscriptions;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory implements Factory<DataBaseSubscriptionToDomainBaseSubscriptionMapper> {
    private final Provider<DataBaseAppearanceToDomainAppearanceMapper> dataBaseAppearanceToDomainAppearanceMapperProvider;

    public DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory(Provider<DataBaseAppearanceToDomainAppearanceMapper> provider) {
        this.dataBaseAppearanceToDomainAppearanceMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataBaseSubscriptionToDomainBaseSubscriptionMapper get() {
        return newInstance(this.dataBaseAppearanceToDomainAppearanceMapperProvider.get());
    }

    public static DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory create(Provider<DataBaseAppearanceToDomainAppearanceMapper> provider) {
        return new DataBaseSubscriptionToDomainBaseSubscriptionMapper_Factory(provider);
    }

    public static DataBaseSubscriptionToDomainBaseSubscriptionMapper newInstance(DataBaseAppearanceToDomainAppearanceMapper dataBaseAppearanceToDomainAppearanceMapper) {
        return new DataBaseSubscriptionToDomainBaseSubscriptionMapper(dataBaseAppearanceToDomainAppearanceMapper);
    }
}
