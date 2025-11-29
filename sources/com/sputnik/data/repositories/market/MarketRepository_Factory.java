package com.sputnik.data.repositories.market;

import com.sputnik.data.api.MarketApi;
import com.sputnik.data.entities.market.DataMarket;
import com.sputnik.data.entities.market.service.DataService;
import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.entities.subscriptions.items.DataMarketItem;
import com.sputnik.data.entities.subscriptions.services.DataOuterService;
import com.sputnik.data.entities.subscriptions.subscriptions.DataBaseSubscription;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.DomainMarket;
import com.sputnik.domain.entities.market.services.DomainService;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import com.sputnik.domain.entities.subscriptions.items.DomainMarketItem;
import com.sputnik.domain.entities.subscriptions.services.DomainOuterService;
import com.sputnik.domain.entities.subscriptions.subscriptions.DomainBaseSubscription;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MarketRepository_Factory implements Factory<MarketRepository> {
    private final Provider<ListMapper<DataMarketItem, DomainMarketItem>> dataMarketItemToDomainMarketItemMapperProvider;
    private final Provider<ListMapper<DataMarket, DomainMarket>> dataMarketToDomainMarketMapperProvider;
    private final Provider<ListMapper<DataBaseSubscription, DomainBaseSubscription>> dataMarketV2ToDomainMarketV2MapperProvider;
    private final Provider<ListMapper<DataOuterService, DomainOuterService>> dataOuterServiceToDomainOuterServiceMapperProvider;
    private final Provider<ListMapper<DataService, DomainService>> dataServiceToDomainServiceMapperProvider;
    private final Provider<ListMapper<DataSubscription, DomainSubscription>> dataSubscriptionToDomainSubscriptionMapperProvider;
    private final Provider<MarketApi> marketApiProvider;

    public MarketRepository_Factory(Provider<MarketApi> provider, Provider<ListMapper<DataSubscription, DomainSubscription>> provider2, Provider<ListMapper<DataMarket, DomainMarket>> provider3, Provider<ListMapper<DataBaseSubscription, DomainBaseSubscription>> provider4, Provider<ListMapper<DataOuterService, DomainOuterService>> provider5, Provider<ListMapper<DataMarketItem, DomainMarketItem>> provider6, Provider<ListMapper<DataService, DomainService>> provider7) {
        this.marketApiProvider = provider;
        this.dataSubscriptionToDomainSubscriptionMapperProvider = provider2;
        this.dataMarketToDomainMarketMapperProvider = provider3;
        this.dataMarketV2ToDomainMarketV2MapperProvider = provider4;
        this.dataOuterServiceToDomainOuterServiceMapperProvider = provider5;
        this.dataMarketItemToDomainMarketItemMapperProvider = provider6;
        this.dataServiceToDomainServiceMapperProvider = provider7;
    }

    @Override // javax.inject.Provider
    public MarketRepository get() {
        return newInstance(this.marketApiProvider.get(), this.dataSubscriptionToDomainSubscriptionMapperProvider.get(), this.dataMarketToDomainMarketMapperProvider.get(), this.dataMarketV2ToDomainMarketV2MapperProvider.get(), this.dataOuterServiceToDomainOuterServiceMapperProvider.get(), this.dataMarketItemToDomainMarketItemMapperProvider.get(), this.dataServiceToDomainServiceMapperProvider.get());
    }

    public static MarketRepository_Factory create(Provider<MarketApi> provider, Provider<ListMapper<DataSubscription, DomainSubscription>> provider2, Provider<ListMapper<DataMarket, DomainMarket>> provider3, Provider<ListMapper<DataBaseSubscription, DomainBaseSubscription>> provider4, Provider<ListMapper<DataOuterService, DomainOuterService>> provider5, Provider<ListMapper<DataMarketItem, DomainMarketItem>> provider6, Provider<ListMapper<DataService, DomainService>> provider7) {
        return new MarketRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static MarketRepository newInstance(MarketApi marketApi, ListMapper<DataSubscription, DomainSubscription> listMapper, ListMapper<DataMarket, DomainMarket> listMapper2, ListMapper<DataBaseSubscription, DomainBaseSubscription> listMapper3, ListMapper<DataOuterService, DomainOuterService> listMapper4, ListMapper<DataMarketItem, DomainMarketItem> listMapper5, ListMapper<DataService, DomainService> listMapper6) {
        return new MarketRepository(marketApi, listMapper, listMapper2, listMapper3, listMapper4, listMapper5, listMapper6);
    }
}
