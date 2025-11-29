package com.sputnik.data.mappers.profile;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataProfileToDomainProfileMapper_Factory implements Factory<DataProfileToDomainProfileMapper> {
    private final Provider<DataProfileCardInfoToDomainProfileCardInfoMapper> mapperProvider;

    public DataProfileToDomainProfileMapper_Factory(Provider<DataProfileCardInfoToDomainProfileCardInfoMapper> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataProfileToDomainProfileMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataProfileToDomainProfileMapper_Factory create(Provider<DataProfileCardInfoToDomainProfileCardInfoMapper> provider) {
        return new DataProfileToDomainProfileMapper_Factory(provider);
    }

    public static DataProfileToDomainProfileMapper newInstance(DataProfileCardInfoToDomainProfileCardInfoMapper dataProfileCardInfoToDomainProfileCardInfoMapper) {
        return new DataProfileToDomainProfileMapper(dataProfileCardInfoToDomainProfileCardInfoMapper);
    }
}
