package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPromisePaymentToDomainPromisePaymentMapper_Factory implements Factory<DataPromisePaymentToDomainPromisePaymentMapper> {

    private static final class InstanceHolder {
        private static final DataPromisePaymentToDomainPromisePaymentMapper_Factory INSTANCE = new DataPromisePaymentToDomainPromisePaymentMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPromisePaymentToDomainPromisePaymentMapper get() {
        return newInstance();
    }

    public static DataPromisePaymentToDomainPromisePaymentMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPromisePaymentToDomainPromisePaymentMapper newInstance() {
        return new DataPromisePaymentToDomainPromisePaymentMapper();
    }
}
