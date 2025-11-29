package com.sputnik.data.mappers.service_payments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DataPaymentHistoryToDomainPaymentHistoryMapper_Factory implements Factory<DataPaymentHistoryToDomainPaymentHistoryMapper> {

    private static final class InstanceHolder {
        private static final DataPaymentHistoryToDomainPaymentHistoryMapper_Factory INSTANCE = new DataPaymentHistoryToDomainPaymentHistoryMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DataPaymentHistoryToDomainPaymentHistoryMapper get() {
        return newInstance();
    }

    public static DataPaymentHistoryToDomainPaymentHistoryMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DataPaymentHistoryToDomainPaymentHistoryMapper newInstance() {
        return new DataPaymentHistoryToDomainPaymentHistoryMapper();
    }
}
