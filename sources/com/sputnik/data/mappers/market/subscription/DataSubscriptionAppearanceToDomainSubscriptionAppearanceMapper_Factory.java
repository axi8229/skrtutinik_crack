package com.sputnik.data.mappers.market.subscription;

import com.sputnik.data.mappers.market.DataDetailedLayoutToDomainDetailedLayoutMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory implements Factory<DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper> {
    private final Provider<DataDetailedLayoutToDomainDetailedLayoutMapper> mapperProvider;

    public DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory(Provider<DataDetailedLayoutToDomainDetailedLayoutMapper> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory create(Provider<DataDetailedLayoutToDomainDetailedLayoutMapper> provider) {
        return new DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper_Factory(provider);
    }

    public static DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper newInstance(DataDetailedLayoutToDomainDetailedLayoutMapper dataDetailedLayoutToDomainDetailedLayoutMapper) {
        return new DataSubscriptionAppearanceToDomainSubscriptionAppearanceMapper(dataDetailedLayoutToDomainDetailedLayoutMapper);
    }
}
