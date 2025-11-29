package com.sputnik.common.mappers.stories;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainStoryButtonToStoryButtonMapper_Factory implements Factory<DomainStoryButtonToStoryButtonMapper> {

    private static final class InstanceHolder {
        private static final DomainStoryButtonToStoryButtonMapper_Factory INSTANCE = new DomainStoryButtonToStoryButtonMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainStoryButtonToStoryButtonMapper get() {
        return newInstance();
    }

    public static DomainStoryButtonToStoryButtonMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainStoryButtonToStoryButtonMapper newInstance() {
        return new DomainStoryButtonToStoryButtonMapper();
    }
}
