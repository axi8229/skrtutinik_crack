package com.sputnik.common.viewmodels;

import com.sputnik.common.mappers.subscriptions.DomainBaseSubscriptionToBaseSubscriptionMapper;
import com.sputnik.common.mappers.subscriptions.DomainMarketItemToMarketItemMapper;
import com.sputnik.common.mappers.subscriptions.DomainOuterServiceToOuterServiceMapper;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.market.GetMarketV2UseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SubscriptionsViewModel_Factory implements Factory<SubscriptionsViewModel> {
    private final Provider<GetMarketV2UseCase> getMarketV2UseCaseProvider;
    private final Provider<DomainMarketItemToMarketItemMapper> marketItemsMapperProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<DomainOuterServiceToOuterServiceMapper> servicesMapperProvider;
    private final Provider<DomainBaseSubscriptionToBaseSubscriptionMapper> subscriptionsMapperProvider;

    public SubscriptionsViewModel_Factory(Provider<GetMarketV2UseCase> provider, Provider<DomainBaseSubscriptionToBaseSubscriptionMapper> provider2, Provider<DomainOuterServiceToOuterServiceMapper> provider3, Provider<DomainMarketItemToMarketItemMapper> provider4, Provider<PrefManager> provider5) {
        this.getMarketV2UseCaseProvider = provider;
        this.subscriptionsMapperProvider = provider2;
        this.servicesMapperProvider = provider3;
        this.marketItemsMapperProvider = provider4;
        this.prefManagerProvider = provider5;
    }

    @Override // javax.inject.Provider
    public SubscriptionsViewModel get() {
        return newInstance(this.getMarketV2UseCaseProvider.get(), this.subscriptionsMapperProvider.get(), this.servicesMapperProvider.get(), this.marketItemsMapperProvider.get(), this.prefManagerProvider.get());
    }

    public static SubscriptionsViewModel_Factory create(Provider<GetMarketV2UseCase> provider, Provider<DomainBaseSubscriptionToBaseSubscriptionMapper> provider2, Provider<DomainOuterServiceToOuterServiceMapper> provider3, Provider<DomainMarketItemToMarketItemMapper> provider4, Provider<PrefManager> provider5) {
        return new SubscriptionsViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SubscriptionsViewModel newInstance(GetMarketV2UseCase getMarketV2UseCase, DomainBaseSubscriptionToBaseSubscriptionMapper domainBaseSubscriptionToBaseSubscriptionMapper, DomainOuterServiceToOuterServiceMapper domainOuterServiceToOuterServiceMapper, DomainMarketItemToMarketItemMapper domainMarketItemToMarketItemMapper, PrefManager prefManager) {
        return new SubscriptionsViewModel(getMarketV2UseCase, domainBaseSubscriptionToBaseSubscriptionMapper, domainOuterServiceToOuterServiceMapper, domainMarketItemToMarketItemMapper, prefManager);
    }
}
