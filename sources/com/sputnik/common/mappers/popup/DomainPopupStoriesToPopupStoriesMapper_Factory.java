package com.sputnik.common.mappers.popup;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainPopupStoriesToPopupStoriesMapper_Factory implements Factory<DomainPopupStoriesToPopupStoriesMapper> {

    private static final class InstanceHolder {
        private static final DomainPopupStoriesToPopupStoriesMapper_Factory INSTANCE = new DomainPopupStoriesToPopupStoriesMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainPopupStoriesToPopupStoriesMapper get() {
        return newInstance();
    }

    public static DomainPopupStoriesToPopupStoriesMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainPopupStoriesToPopupStoriesMapper newInstance() {
        return new DomainPopupStoriesToPopupStoriesMapper();
    }
}
