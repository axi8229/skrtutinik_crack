package com.sputnik.service_payments.mappers;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainServiceAccountInfoToServiceAccountInfoMapper_Factory implements Factory<DomainServiceAccountInfoToServiceAccountInfoMapper> {

    private static final class InstanceHolder {
        private static final DomainServiceAccountInfoToServiceAccountInfoMapper_Factory INSTANCE = new DomainServiceAccountInfoToServiceAccountInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainServiceAccountInfoToServiceAccountInfoMapper get() {
        return newInstance();
    }

    public static DomainServiceAccountInfoToServiceAccountInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainServiceAccountInfoToServiceAccountInfoMapper newInstance() {
        return new DomainServiceAccountInfoToServiceAccountInfoMapper();
    }
}
