package com.sputnik.common.mappers.subscriptions;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainOuterServiceToOuterServiceMapper_Factory implements Factory<DomainOuterServiceToOuterServiceMapper> {
    private final Provider<DomainOuterServiceAppearanceToOuterServiceAppearanceMapper> domainOuterServiceAppearanceToOuterServiceAppearanceMapperProvider;

    public DomainOuterServiceToOuterServiceMapper_Factory(Provider<DomainOuterServiceAppearanceToOuterServiceAppearanceMapper> provider) {
        this.domainOuterServiceAppearanceToOuterServiceAppearanceMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DomainOuterServiceToOuterServiceMapper get() {
        return newInstance(this.domainOuterServiceAppearanceToOuterServiceAppearanceMapperProvider.get());
    }

    public static DomainOuterServiceToOuterServiceMapper_Factory create(Provider<DomainOuterServiceAppearanceToOuterServiceAppearanceMapper> provider) {
        return new DomainOuterServiceToOuterServiceMapper_Factory(provider);
    }

    public static DomainOuterServiceToOuterServiceMapper newInstance(DomainOuterServiceAppearanceToOuterServiceAppearanceMapper domainOuterServiceAppearanceToOuterServiceAppearanceMapper) {
        return new DomainOuterServiceToOuterServiceMapper(domainOuterServiceAppearanceToOuterServiceAppearanceMapper);
    }
}
