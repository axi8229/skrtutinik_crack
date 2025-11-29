package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPaymentReceiptToDomainPaymentReceiptMapper_Factory implements Factory<DataPaymentReceiptToDomainPaymentReceiptMapper> {

    private static final class InstanceHolder {
        private static final DataPaymentReceiptToDomainPaymentReceiptMapper_Factory INSTANCE = new DataPaymentReceiptToDomainPaymentReceiptMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPaymentReceiptToDomainPaymentReceiptMapper get() {
        return newInstance();
    }

    public static DataPaymentReceiptToDomainPaymentReceiptMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPaymentReceiptToDomainPaymentReceiptMapper newInstance() {
        return new DataPaymentReceiptToDomainPaymentReceiptMapper();
    }
}
