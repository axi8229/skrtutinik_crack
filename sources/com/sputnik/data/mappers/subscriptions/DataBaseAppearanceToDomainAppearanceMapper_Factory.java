package com.sputnik.data.mappers.subscriptions;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataBaseAppearanceToDomainAppearanceMapper_Factory implements Factory<DataBaseAppearanceToDomainAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DataBaseAppearanceToDomainAppearanceMapper_Factory INSTANCE = new DataBaseAppearanceToDomainAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataBaseAppearanceToDomainAppearanceMapper get() {
        return newInstance();
    }

    public static DataBaseAppearanceToDomainAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataBaseAppearanceToDomainAppearanceMapper newInstance() {
        return new DataBaseAppearanceToDomainAppearanceMapper();
    }
}
