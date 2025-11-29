package com.sputnik.data.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataMarketItemToDomainMarketItemMapper_Factory implements Factory<DataMarketItemToDomainMarketItemMapper> {

    private static final class InstanceHolder {
        private static final DataMarketItemToDomainMarketItemMapper_Factory INSTANCE = new DataMarketItemToDomainMarketItemMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataMarketItemToDomainMarketItemMapper get() {
        return newInstance();
    }

    public static DataMarketItemToDomainMarketItemMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataMarketItemToDomainMarketItemMapper newInstance() {
        return new DataMarketItemToDomainMarketItemMapper();
    }
}
