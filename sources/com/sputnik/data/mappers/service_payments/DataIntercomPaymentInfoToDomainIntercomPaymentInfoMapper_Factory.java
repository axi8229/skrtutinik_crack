package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory implements Factory<DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper> {

    private static final class InstanceHolder {
        private static final DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory INSTANCE = new DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper get() {
        return newInstance();
    }

    public static DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper newInstance() {
        return new DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper();
    }
}
