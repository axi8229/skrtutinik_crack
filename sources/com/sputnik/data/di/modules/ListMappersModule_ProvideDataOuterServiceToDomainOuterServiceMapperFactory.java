package com.sputnik.data.di.modules;

import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.mappers.subscriptions.DataOuterServiceToDomainOuterServiceMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory implements Factory<ListMapper<DataOuterService, DomainOuterService>> {
    private final Provider<DataOuterServiceToDomainOuterServiceMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory(ListMappersModule listMappersModule, Provider<DataOuterServiceToDomainOuterServiceMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataOuterService, DomainOuterService> get() {
        return provideDataOuterServiceToDomainOuterServiceMapper(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory create(ListMappersModule listMappersModule, Provider<DataOuterServiceToDomainOuterServiceMapper> provider) {
        return new ListMappersModule_ProvideDataOuterServiceToDomainOuterServiceMapperFactory(listMappersModule, provider);
    }

    public static ListMapper<DataOuterService, DomainOuterService> provideDataOuterServiceToDomainOuterServiceMapper(ListMappersModule listMappersModule, DataOuterServiceToDomainOuterServiceMapper dataOuterServiceToDomainOuterServiceMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataOuterServiceToDomainOuterServiceMapper(dataOuterServiceToDomainOuterServiceMapper));
    }
}
