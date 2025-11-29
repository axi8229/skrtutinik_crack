package com.sputnik.data.mappers.localization;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataLocalizationToDomainLocalizationMapper_Factory implements Factory<DataLocalizationToDomainLocalizationMapper> {

    private static final class InstanceHolder {
        private static final DataLocalizationToDomainLocalizationMapper_Factory INSTANCE = new DataLocalizationToDomainLocalizationMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataLocalizationToDomainLocalizationMapper get() {
        return newInstance();
    }

    public static DataLocalizationToDomainLocalizationMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataLocalizationToDomainLocalizationMapper newInstance() {
        return new DataLocalizationToDomainLocalizationMapper();
    }
}
