package com.sputnik.data.mappers.market.subscription;

import com.sputnik.data.entities.market.DataSubsPlans;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory implements Factory<DataSubscriptionDetailsToDomainSubscriptionDetailsMapper> {
    private final Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> mapperProvider;

    public DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory(Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataSubscriptionDetailsToDomainSubscriptionDetailsMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory create(Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> provider) {
        return new DataSubscriptionDetailsToDomainSubscriptionDetailsMapper_Factory(provider);
    }

    public static DataSubscriptionDetailsToDomainSubscriptionDetailsMapper newInstance(NullableInputListMapper<DataSubsPlans, DomainSubsPlans> nullableInputListMapper) {
        return new DataSubscriptionDetailsToDomainSubscriptionDetailsMapper(nullableInputListMapper);
    }
}
