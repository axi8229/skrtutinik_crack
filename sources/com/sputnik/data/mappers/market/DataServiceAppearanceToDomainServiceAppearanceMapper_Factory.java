package com.sputnik.data.mappers.market;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataServiceAppearanceToDomainServiceAppearanceMapper_Factory implements Factory<DataServiceAppearanceToDomainServiceAppearanceMapper> {

    private static final class InstanceHolder {
        private static final DataServiceAppearanceToDomainServiceAppearanceMapper_Factory INSTANCE = new DataServiceAppearanceToDomainServiceAppearanceMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataServiceAppearanceToDomainServiceAppearanceMapper get() {
        return newInstance();
    }

    public static DataServiceAppearanceToDomainServiceAppearanceMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataServiceAppearanceToDomainServiceAppearanceMapper newInstance() {
        return new DataServiceAppearanceToDomainServiceAppearanceMapper();
    }
}
