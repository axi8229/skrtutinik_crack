package com.sputnik.data.mappers.market;

import com.sputnik.data.mappers.market.subscription.DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper;
import com.sputnik.data.mappers.market.subscription.DataSubscriptionDetailsToDomainSubscriptionDetailsMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataMarketToDomainMarketMapper_Factory implements Factory<DataMarketToDomainMarketMapper> {
    private final Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider;
    private final Provider<DataSubscriptionDetailsToDomainSubscriptionDetailsMapper> dataSubscriptionDetailsToDomainSubscriptionDetailsMapperProvider;

    public DataMarketToDomainMarketMapper_Factory(Provider<DataSubscriptionDetailsToDomainSubscriptionDetailsMapper> provider, Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> provider2) {
        this.dataSubscriptionDetailsToDomainSubscriptionDetailsMapperProvider = provider;
        this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DataMarketToDomainMarketMapper get() {
        return newInstance(this.dataSubscriptionDetailsToDomainSubscriptionDetailsMapperProvider.get(), this.dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapperProvider.get());
    }

    public static DataMarketToDomainMarketMapper_Factory create(Provider<DataSubscriptionDetailsToDomainSubscriptionDetailsMapper> provider, Provider<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> provider2) {
        return new DataMarketToDomainMarketMapper_Factory(provider, provider2);
    }

    public static DataMarketToDomainMarketMapper newInstance(DataSubscriptionDetailsToDomainSubscriptionDetailsMapper dataSubscriptionDetailsToDomainSubscriptionDetailsMapper, DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper) {
        return new DataMarketToDomainMarketMapper(dataSubscriptionDetailsToDomainSubscriptionDetailsMapper, dataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper);
    }
}
