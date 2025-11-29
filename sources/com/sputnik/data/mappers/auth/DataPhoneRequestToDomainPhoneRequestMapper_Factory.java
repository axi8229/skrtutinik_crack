package com.sputnik.data.mappers.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPhoneRequestToDomainPhoneRequestMapper_Factory implements Factory<DataPhoneRequestToDomainPhoneRequestMapper> {

    private static final class InstanceHolder {
        private static final DataPhoneRequestToDomainPhoneRequestMapper_Factory INSTANCE = new DataPhoneRequestToDomainPhoneRequestMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPhoneRequestToDomainPhoneRequestMapper get() {
        return newInstance();
    }

    public static DataPhoneRequestToDomainPhoneRequestMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPhoneRequestToDomainPhoneRequestMapper newInstance() {
        return new DataPhoneRequestToDomainPhoneRequestMapper();
    }
}
