package com.sputnik.data.mappers.profile;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataProfileCardInfoToDomainProfileCardInfoMapper_Factory implements Factory<DataProfileCardInfoToDomainProfileCardInfoMapper> {

    private static final class InstanceHolder {
        private static final DataProfileCardInfoToDomainProfileCardInfoMapper_Factory INSTANCE = new DataProfileCardInfoToDomainProfileCardInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataProfileCardInfoToDomainProfileCardInfoMapper get() {
        return newInstance();
    }

    public static DataProfileCardInfoToDomainProfileCardInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataProfileCardInfoToDomainProfileCardInfoMapper newInstance() {
        return new DataProfileCardInfoToDomainProfileCardInfoMapper();
    }
}
