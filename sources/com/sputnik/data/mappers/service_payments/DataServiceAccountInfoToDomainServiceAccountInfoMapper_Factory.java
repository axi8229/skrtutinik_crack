package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory implements Factory<DataServiceAccountInfoToDomainServiceAccountInfoMapper> {

    private static final class InstanceHolder {
        private static final DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory INSTANCE = new DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataServiceAccountInfoToDomainServiceAccountInfoMapper get() {
        return newInstance();
    }

    public static DataServiceAccountInfoToDomainServiceAccountInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataServiceAccountInfoToDomainServiceAccountInfoMapper newInstance() {
        return new DataServiceAccountInfoToDomainServiceAccountInfoMapper();
    }
}
