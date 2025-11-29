package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.DataSubsPlans;
import com.sputnik.data.mappers.market.DataSubsPlansToDomainSubsPlansMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory implements Factory<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> {
    private final Provider<DataSubsPlansToDomainSubsPlansMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory(ListMappersModule listMappersModule, Provider<DataSubsPlansToDomainSubsPlansMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataSubsPlans, DomainSubsPlans> get() {
        return provideDataSubsPlansToDomainSubsPlans(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory create(ListMappersModule listMappersModule, Provider<DataSubsPlansToDomainSubsPlansMapper> provider) {
        return new ListMappersModule_ProvideDataSubsPlansToDomainSubsPlansFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataSubsPlans, DomainSubsPlans> provideDataSubsPlansToDomainSubsPlans(ListMappersModule listMappersModule, DataSubsPlansToDomainSubsPlansMapper dataSubsPlansToDomainSubsPlansMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataSubsPlansToDomainSubsPlans(dataSubsPlansToDomainSubsPlansMapper));
    }
}
