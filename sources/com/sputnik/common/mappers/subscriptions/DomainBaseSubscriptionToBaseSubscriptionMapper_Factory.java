package com.sputnik.common.mappers.subscriptions;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainBaseSubscriptionToBaseSubscriptionMapper_Factory implements Factory<DomainBaseSubscriptionToBaseSubscriptionMapper> {
    private final Provider<DomainBaseAppearanceToBaseAppearanceMapper> domainBaseSubscriptionToBaseSubscriptionMapperProvider;

    public DomainBaseSubscriptionToBaseSubscriptionMapper_Factory(Provider<DomainBaseAppearanceToBaseAppearanceMapper> provider) {
        this.domainBaseSubscriptionToBaseSubscriptionMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DomainBaseSubscriptionToBaseSubscriptionMapper get() {
        return newInstance(this.domainBaseSubscriptionToBaseSubscriptionMapperProvider.get());
    }

    public static DomainBaseSubscriptionToBaseSubscriptionMapper_Factory create(Provider<DomainBaseAppearanceToBaseAppearanceMapper> provider) {
        return new DomainBaseSubscriptionToBaseSubscriptionMapper_Factory(provider);
    }

    public static DomainBaseSubscriptionToBaseSubscriptionMapper newInstance(DomainBaseAppearanceToBaseAppearanceMapper domainBaseAppearanceToBaseAppearanceMapper) {
        return new DomainBaseSubscriptionToBaseSubscriptionMapper(domainBaseAppearanceToBaseAppearanceMapper);
    }
}
