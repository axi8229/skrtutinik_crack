package com.sputnik.data.mappers.market.subscription;

import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.data.mappers.market.DataPlansToDomainPlansMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataSubscriptionToDomainSubscriptionMapper_Factory implements Factory<DataSubscriptionToDomainSubscriptionMapper> {
    private final Provider<DataPlansToDomainPlansMapper> dataPlansToDomainPlansMapperProvider;
    private final Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> dataSmallServiceToDomainSmallServiceMapperProvider;
    private final Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider;

    public DataSubscriptionToDomainSubscriptionMapper_Factory(Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> provider, Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> provider2, Provider<DataPlansToDomainPlansMapper> provider3) {
        this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider = provider;
        this.dataSmallServiceToDomainSmallServiceMapperProvider = provider2;
        this.dataPlansToDomainPlansMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public DataSubscriptionToDomainSubscriptionMapper get() {
        return newInstance(this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider.get(), this.dataSmallServiceToDomainSmallServiceMapperProvider.get(), this.dataPlansToDomainPlansMapperProvider.get());
    }

    public static DataSubscriptionToDomainSubscriptionMapper_Factory create(Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> provider, Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> provider2, Provider<DataPlansToDomainPlansMapper> provider3) {
        return new DataSubscriptionToDomainSubscriptionMapper_Factory(provider, provider2, provider3);
    }

    public static DataSubscriptionToDomainSubscriptionMapper newInstance(DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper, NullableInputListMapper<DataSmallService, DomainSmallServices> nullableInputListMapper, DataPlansToDomainPlansMapper dataPlansToDomainPlansMapper) {
        return new DataSubscriptionToDomainSubscriptionMapper(dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper, nullableInputListMapper, dataPlansToDomainPlansMapper);
    }
}
