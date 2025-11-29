package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.data.mappers.market.DataSmallServiceToDomainSmallServiceMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory implements Factory<NullableInputListMapper<DataSmallService, DomainSmallServices>> {
    private final Provider<DataSmallServiceToDomainSmallServiceMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory(ListMappersModule listMappersModule, Provider<DataSmallServiceToDomainSmallServiceMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataSmallService, DomainSmallServices> get() {
        return provideDataSmallServiceToDomainSmallServices(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory create(ListMappersModule listMappersModule, Provider<DataSmallServiceToDomainSmallServiceMapper> provider) {
        return new ListMappersModule_ProvideDataSmallServiceToDomainSmallServicesFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataSmallService, DomainSmallServices> provideDataSmallServiceToDomainSmallServices(ListMappersModule listMappersModule, DataSmallServiceToDomainSmallServiceMapper dataSmallServiceToDomainSmallServiceMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataSmallServiceToDomainSmallServices(dataSmallServiceToDomainSmallServiceMapper));
    }
}
