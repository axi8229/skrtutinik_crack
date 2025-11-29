package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.mappers.market.DataServiceToDomainServiceMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.services.DomainService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataServiceToDomainServiceFactory implements Factory<ListMapper<DataService, DomainService>> {
    private final Provider<DataServiceToDomainServiceMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataServiceToDomainServiceFactory(ListMappersModule listMappersModule, Provider<DataServiceToDomainServiceMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataService, DomainService> get() {
        return provideDataServiceToDomainService(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataServiceToDomainServiceFactory create(ListMappersModule listMappersModule, Provider<DataServiceToDomainServiceMapper> provider) {
        return new ListMappersModule_ProvideDataServiceToDomainServiceFactory(listMappersModule, provider);
    }

    public static ListMapper<DataService, DomainService> provideDataServiceToDomainService(ListMappersModule listMappersModule, DataServiceToDomainServiceMapper dataServiceToDomainServiceMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataServiceToDomainService(dataServiceToDomainServiceMapper));
    }
}
