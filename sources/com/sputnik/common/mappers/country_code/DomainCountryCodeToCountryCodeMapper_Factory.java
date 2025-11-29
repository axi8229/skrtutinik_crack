package com.sputnik.common.mappers.country_code;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainCountryCodeToCountryCodeMapper_Factory implements Factory<DomainCountryCodeToCountryCodeMapper> {

    private static final class InstanceHolder {
        private static final DomainCountryCodeToCountryCodeMapper_Factory INSTANCE = new DomainCountryCodeToCountryCodeMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainCountryCodeToCountryCodeMapper get() {
        return newInstance();
    }

    public static DomainCountryCodeToCountryCodeMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainCountryCodeToCountryCodeMapper newInstance() {
        return new DomainCountryCodeToCountryCodeMapper();
    }
}
