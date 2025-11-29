package com.sputnik.data.mappers.country_code;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataCountryCodeToDomainCountryCodeMapper_Factory implements Factory<DataCountryCodeToDomainCountryCodeMapper> {

    private static final class InstanceHolder {
        private static final DataCountryCodeToDomainCountryCodeMapper_Factory INSTANCE = new DataCountryCodeToDomainCountryCodeMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataCountryCodeToDomainCountryCodeMapper get() {
        return newInstance();
    }

    public static DataCountryCodeToDomainCountryCodeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataCountryCodeToDomainCountryCodeMapper newInstance() {
        return new DataCountryCodeToDomainCountryCodeMapper();
    }
}
