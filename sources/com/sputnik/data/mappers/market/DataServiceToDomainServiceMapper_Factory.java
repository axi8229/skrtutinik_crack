package com.sputnik.data.mappers.market;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataServiceToDomainServiceMapper_Factory implements Factory<DataServiceToDomainServiceMapper> {
    private final Provider<DataOriginSubToDomainOriginSubMapper> dataOriginSubToDomainOriginSubMapperProvider;
    private final Provider<DataServiceAppearanceToDomainServiceAppearanceMapper> dataServiceAppearanceToDomainServiceAppearanceMapperProvider;

    public DataServiceToDomainServiceMapper_Factory(Provider<DataServiceAppearanceToDomainServiceAppearanceMapper> provider, Provider<DataOriginSubToDomainOriginSubMapper> provider2) {
        this.dataServiceAppearanceToDomainServiceAppearanceMapperProvider = provider;
        this.dataOriginSubToDomainOriginSubMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DataServiceToDomainServiceMapper get() {
        return newInstance(this.dataServiceAppearanceToDomainServiceAppearanceMapperProvider.get(), this.dataOriginSubToDomainOriginSubMapperProvider.get());
    }

    public static DataServiceToDomainServiceMapper_Factory create(Provider<DataServiceAppearanceToDomainServiceAppearanceMapper> provider, Provider<DataOriginSubToDomainOriginSubMapper> provider2) {
        return new DataServiceToDomainServiceMapper_Factory(provider, provider2);
    }

    public static DataServiceToDomainServiceMapper newInstance(DataServiceAppearanceToDomainServiceAppearanceMapper dataServiceAppearanceToDomainServiceAppearanceMapper, DataOriginSubToDomainOriginSubMapper dataOriginSubToDomainOriginSubMapper) {
        return new DataServiceToDomainServiceMapper(dataServiceAppearanceToDomainServiceAppearanceMapper, dataOriginSubToDomainOriginSubMapper);
    }
}
