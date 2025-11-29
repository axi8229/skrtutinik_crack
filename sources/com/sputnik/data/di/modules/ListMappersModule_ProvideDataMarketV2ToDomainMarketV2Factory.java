package com.sputnik.data.di.modules;

import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.data.mappers.subscriptions.DataBaseSubscriptionToDomainBaseSubscriptionMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory implements Factory<ListMapper<DataBaseSubscription, DomainBaseSubscription>> {
    private final Provider<DataBaseSubscriptionToDomainBaseSubscriptionMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory(ListMappersModule listMappersModule, Provider<DataBaseSubscriptionToDomainBaseSubscriptionMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataBaseSubscription, DomainBaseSubscription> get() {
        return provideDataMarketV2ToDomainMarketV2(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory create(ListMappersModule listMappersModule, Provider<DataBaseSubscriptionToDomainBaseSubscriptionMapper> provider) {
        return new ListMappersModule_ProvideDataMarketV2ToDomainMarketV2Factory(listMappersModule, provider);
    }

    public static ListMapper<DataBaseSubscription, DomainBaseSubscription> provideDataMarketV2ToDomainMarketV2(ListMappersModule listMappersModule, DataBaseSubscriptionToDomainBaseSubscriptionMapper dataBaseSubscriptionToDomainBaseSubscriptionMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataMarketV2ToDomainMarketV2(dataBaseSubscriptionToDomainBaseSubscriptionMapper));
    }
}
