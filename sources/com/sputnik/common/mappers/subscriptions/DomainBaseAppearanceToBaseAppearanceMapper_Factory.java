package com.sputnik.common.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainBaseAppearanceToBaseAppearanceMapper_Factory implements Factory<DomainBaseAppearanceToBaseAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DomainBaseAppearanceToBaseAppearanceMapper_Factory INSTANCE = new DomainBaseAppearanceToBaseAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainBaseAppearanceToBaseAppearanceMapper get() {
        return newInstance();
    }

    public static DomainBaseAppearanceToBaseAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainBaseAppearanceToBaseAppearanceMapper newInstance() {
        return new DomainBaseAppearanceToBaseAppearanceMapper();
    }
}
