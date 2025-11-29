package com.sputnik.data.mappers.auth;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataApplyRegistrationToDomainApplyRegistrationMapper_Factory implements Factory<DataApplyRegistrationToDomainApplyRegistrationMapper> {

    private static final class InstanceHolder {
        private static final DataApplyRegistrationToDomainApplyRegistrationMapper_Factory INSTANCE = new DataApplyRegistrationToDomainApplyRegistrationMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataApplyRegistrationToDomainApplyRegistrationMapper get() {
        return newInstance();
    }

    public static DataApplyRegistrationToDomainApplyRegistrationMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataApplyRegistrationToDomainApplyRegistrationMapper newInstance() {
        return new DataApplyRegistrationToDomainApplyRegistrationMapper();
    }
}
