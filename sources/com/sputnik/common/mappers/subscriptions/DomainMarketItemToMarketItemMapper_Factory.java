package com.sputnik.common.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainMarketItemToMarketItemMapper_Factory implements Factory<DomainMarketItemToMarketItemMapper> {

    private static final class InstanceHolder {
        private static final DomainMarketItemToMarketItemMapper_Factory INSTANCE = new DomainMarketItemToMarketItemMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainMarketItemToMarketItemMapper get() {
        return newInstance();
    }

    public static DomainMarketItemToMarketItemMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainMarketItemToMarketItemMapper newInstance() {
        return new DomainMarketItemToMarketItemMapper();
    }
}
