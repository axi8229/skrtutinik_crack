package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.mappers.market.DataMarketToDomainMarketMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.DomainMarket;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataMarketToDomainMarketFactory implements Factory<ListMapper<DataMarket, DomainMarket>> {
    private final Provider<DataMarketToDomainMarketMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataMarketToDomainMarketFactory(ListMappersModule listMappersModule, Provider<DataMarketToDomainMarketMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataMarket, DomainMarket> get() {
        return provideDataMarketToDomainMarket(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataMarketToDomainMarketFactory create(ListMappersModule listMappersModule, Provider<DataMarketToDomainMarketMapper> provider) {
        return new ListMappersModule_ProvideDataMarketToDomainMarketFactory(listMappersModule, provider);
    }

    public static ListMapper<DataMarket, DomainMarket> provideDataMarketToDomainMarket(ListMappersModule listMappersModule, DataMarketToDomainMarketMapper dataMarketToDomainMarketMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataMarketToDomainMarket(dataMarketToDomainMarketMapper));
    }
}
