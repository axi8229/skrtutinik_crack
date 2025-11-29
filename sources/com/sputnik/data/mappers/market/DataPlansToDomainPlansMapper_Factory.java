package com.sputnik.data.mappers.market;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataPlansToDomainPlansMapper_Factory implements Factory<DataPlansToDomainPlansMapper> {
    private final Provider<DataPlanAppearanceToDomainPlanAppearanceMapper> dataPlanAppearanceToDomainPlanAppearanceMapperProvider;

    public DataPlansToDomainPlansMapper_Factory(Provider<DataPlanAppearanceToDomainPlanAppearanceMapper> provider) {
        this.dataPlanAppearanceToDomainPlanAppearanceMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataPlansToDomainPlansMapper get() {
        return newInstance(this.dataPlanAppearanceToDomainPlanAppearanceMapperProvider.get());
    }

    public static DataPlansToDomainPlansMapper_Factory create(Provider<DataPlanAppearanceToDomainPlanAppearanceMapper> provider) {
        return new DataPlansToDomainPlansMapper_Factory(provider);
    }

    public static DataPlansToDomainPlansMapper newInstance(DataPlanAppearanceToDomainPlanAppearanceMapper dataPlanAppearanceToDomainPlanAppearanceMapper) {
        return new DataPlansToDomainPlansMapper(dataPlanAppearanceToDomainPlanAppearanceMapper);
    }
}
