package com.sputnik.common.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory implements Factory<DomainOuterServiceAppearanceToOuterServiceAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory INSTANCE = new DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainOuterServiceAppearanceToOuterServiceAppearanceMapper get() {
        return newInstance();
    }

    public static DomainOuterServiceAppearanceToOuterServiceAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainOuterServiceAppearanceToOuterServiceAppearanceMapper newInstance() {
        return new DomainOuterServiceAppearanceToOuterServiceAppearanceMapper();
    }
}
