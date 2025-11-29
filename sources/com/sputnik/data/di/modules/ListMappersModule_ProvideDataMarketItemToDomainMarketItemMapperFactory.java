package com.sputnik.data.di.modules;

import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.mappers.subscriptions.DataMarketItemToDomainMarketItemMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory implements Factory<ListMapper<DataMarketItem, DomainMarketItem>> {
    private final Provider<DataMarketItemToDomainMarketItemMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory(ListMappersModule listMappersModule, Provider<DataMarketItemToDomainMarketItemMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataMarketItem, DomainMarketItem> get() {
        return provideDataMarketItemToDomainMarketItemMapper(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory create(ListMappersModule listMappersModule, Provider<DataMarketItemToDomainMarketItemMapper> provider) {
        return new ListMappersModule_ProvideDataMarketItemToDomainMarketItemMapperFactory(listMappersModule, provider);
    }

    public static ListMapper<DataMarketItem, DomainMarketItem> provideDataMarketItemToDomainMarketItemMapper(ListMappersModule listMappersModule, DataMarketItemToDomainMarketItemMapper dataMarketItemToDomainMarketItemMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataMarketItemToDomainMarketItemMapper(dataMarketItemToDomainMarketItemMapper));
    }
}
