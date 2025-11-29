package com.sputnik.data.mappers.market;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataOriginSubToDomainOriginSubMapper_Factory implements Factory<DataOriginSubToDomainOriginSubMapper> {

    private static final class InstanceHolder {
        private static final DataOriginSubToDomainOriginSubMapper_Factory INSTANCE = new DataOriginSubToDomainOriginSubMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataOriginSubToDomainOriginSubMapper get() {
        return newInstance();
    }

    public static DataOriginSubToDomainOriginSubMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataOriginSubToDomainOriginSubMapper newInstance() {
        return new DataOriginSubToDomainOriginSubMapper();
    }
}
