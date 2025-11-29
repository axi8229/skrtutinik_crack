package com.sputnik.data.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory implements Factory<DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory INSTANCE = new DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper get() {
        return newInstance();
    }

    public static DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper newInstance() {
        return new DataOuterServiceAppearanceToDomainOuterServiceAppearanceMapper();
    }
}
