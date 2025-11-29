package com.sputnik.data.mappers.market;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataDetailedLayoutToDomainDetailedLayoutMapper_Factory implements Factory<DataDetailedLayoutToDomainDetailedLayoutMapper> {
    private final Provider<DataAppearancePlansToDomainAppearancePlansMapper> dataAppearancePlansToDomainAppearancePlansMapperProvider;
    private final Provider<DataIncludedServiceToDomainIncludedServiceMapper> dataIncludedServiceToDomainIncludedServiceMapperProvider;

    public DataDetailedLayoutToDomainDetailedLayoutMapper_Factory(Provider<DataAppearancePlansToDomainAppearancePlansMapper> provider, Provider<DataIncludedServiceToDomainIncludedServiceMapper> provider2) {
        this.dataAppearancePlansToDomainAppearancePlansMapperProvider = provider;
        this.dataIncludedServiceToDomainIncludedServiceMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DataDetailedLayoutToDomainDetailedLayoutMapper get() {
        return newInstance(this.dataAppearancePlansToDomainAppearancePlansMapperProvider.get(), this.dataIncludedServiceToDomainIncludedServiceMapperProvider.get());
    }

    public static DataDetailedLayoutToDomainDetailedLayoutMapper_Factory create(Provider<DataAppearancePlansToDomainAppearancePlansMapper> provider, Provider<DataIncludedServiceToDomainIncludedServiceMapper> provider2) {
        return new DataDetailedLayoutToDomainDetailedLayoutMapper_Factory(provider, provider2);
    }

    public static DataDetailedLayoutToDomainDetailedLayoutMapper newInstance(DataAppearancePlansToDomainAppearancePlansMapper dataAppearancePlansToDomainAppearancePlansMapper, DataIncludedServiceToDomainIncludedServiceMapper dataIncludedServiceToDomainIncludedServiceMapper) {
        return new DataDetailedLayoutToDomainDetailedLayoutMapper(dataAppearancePlansToDomainAppearancePlansMapper, dataIncludedServiceToDomainIncludedServiceMapper);
    }
}
