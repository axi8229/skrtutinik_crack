package com.sputnik.data.repositories.country_code;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class CountryCodeSource_Factory implements Factory<CountryCodeSource> {

    private static final class InstanceHolder {
        private static final CountryCodeSource_Factory INSTANCE = new CountryCodeSource_Factory();
    }

    @Override // javax.inject.Provider
    public CountryCodeSource get() {
        return newInstance();
    }

    public static CountryCodeSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CountryCodeSource newInstance() {
        return new CountryCodeSource();
    }
}
