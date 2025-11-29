package com.sputnik.data.mappers.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory implements Factory<DataConfirmRegistrationToDomainConfirmRegistrationMapper> {

    private static final class InstanceHolder {
        private static final DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory INSTANCE = new DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataConfirmRegistrationToDomainConfirmRegistrationMapper get() {
        return newInstance();
    }

    public static DataConfirmRegistrationToDomainConfirmRegistrationMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataConfirmRegistrationToDomainConfirmRegistrationMapper newInstance() {
        return new DataConfirmRegistrationToDomainConfirmRegistrationMapper();
    }
}
