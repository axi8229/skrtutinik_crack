package com.sputnik.data.di.modules;

import com.sputnik.data.entities.market.subscription.DataSubscription;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionToDomainSubscriptionMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.subscription.DomainSubscription;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory implements Factory<ListMapper<DataSubscription, DomainSubscription>> {
    private final Provider<DataSubscriptionToDomainSubscriptionMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory(ListMappersModule listMappersModule, Provider<DataSubscriptionToDomainSubscriptionMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataSubscription, DomainSubscription> get() {
        return provideDataSubscriptionToDomainSubscription(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory create(ListMappersModule listMappersModule, Provider<DataSubscriptionToDomainSubscriptionMapper> provider) {
        return new ListMappersModule_ProvideDataSubscriptionToDomainSubscriptionFactory(listMappersModule, provider);
    }

    public static ListMapper<DataSubscription, DomainSubscription> provideDataSubscriptionToDomainSubscription(ListMappersModule listMappersModule, DataSubscriptionToDomainSubscriptionMapper dataSubscriptionToDomainSubscriptionMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataSubscriptionToDomainSubscription(dataSubscriptionToDomainSubscriptionMapper));
    }
}
