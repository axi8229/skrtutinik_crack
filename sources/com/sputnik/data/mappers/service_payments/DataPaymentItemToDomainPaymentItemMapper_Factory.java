package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPaymentItemToDomainPaymentItemMapper_Factory implements Factory<DataPaymentItemToDomainPaymentItemMapper> {

    private static final class InstanceHolder {
        private static final DataPaymentItemToDomainPaymentItemMapper_Factory INSTANCE = new DataPaymentItemToDomainPaymentItemMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPaymentItemToDomainPaymentItemMapper get() {
        return newInstance();
    }

    public static DataPaymentItemToDomainPaymentItemMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPaymentItemToDomainPaymentItemMapper newInstance() {
        return new DataPaymentItemToDomainPaymentItemMapper();
    }
}
