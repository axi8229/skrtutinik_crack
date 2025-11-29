package com.sputnik.common.mappers.localization;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainLocalizationToLocalizationMapper_Factory implements Factory<DomainLocalizationToLocalizationMapper> {

    private static final class InstanceHolder {
        private static final DomainLocalizationToLocalizationMapper_Factory INSTANCE = new DomainLocalizationToLocalizationMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainLocalizationToLocalizationMapper get() {
        return newInstance();
    }

    public static DomainLocalizationToLocalizationMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainLocalizationToLocalizationMapper newInstance() {
        return new DomainLocalizationToLocalizationMapper();
    }
}
