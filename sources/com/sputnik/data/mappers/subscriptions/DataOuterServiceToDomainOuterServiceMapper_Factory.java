package com.sputnik.data.mappers.subscriptions;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataOuterServiceToDomainOuterServiceMapper_Factory implements Factory<DataOuterServiceToDomainOuterServiceMapper> {
    private final Provider<DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper> dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapperProvider;

    public DataOuterServiceToDomainOuterServiceMapper_Factory(Provider<DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper> provider) {
        this.dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataOuterServiceToDomainOuterServiceMapper get() {
        return newInstance(this.dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapperProvider.get());
    }

    public static DataOuterServiceToDomainOuterServiceMapper_Factory create(Provider<DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper> provider) {
        return new DataOuterServiceToDomainOuterServiceMapper_Factory(provider);
    }

    public static DataOuterServiceToDomainOuterServiceMapper newInstance(DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper) {
        return new DataOuterServiceToDomainOuterServiceMapper(dataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper);
    }
}
