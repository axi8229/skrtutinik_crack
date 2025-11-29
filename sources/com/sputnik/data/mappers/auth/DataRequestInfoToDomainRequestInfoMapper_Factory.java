package com.sputnik.data.mappers.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataRequestInfoToDomainRequestInfoMapper_Factory implements Factory<DataRequestInfoToDomainRequestInfoMapper> {

    private static final class InstanceHolder {
        private static final DataRequestInfoToDomainRequestInfoMapper_Factory INSTANCE = new DataRequestInfoToDomainRequestInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataRequestInfoToDomainRequestInfoMapper get() {
        return newInstance();
    }

    public static DataRequestInfoToDomainRequestInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataRequestInfoToDomainRequestInfoMapper newInstance() {
        return new DataRequestInfoToDomainRequestInfoMapper();
    }
}
