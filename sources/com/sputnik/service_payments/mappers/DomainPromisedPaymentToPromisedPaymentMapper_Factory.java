package com.sputnik.service_payments.mappers;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class DomainPromisedPaymentToPromisedPaymentMapper_Factory implements Factory<DomainPromisedPaymentToPromisedPaymentMapper> {

    private static final class InstanceHolder {
        private static final DomainPromisedPaymentToPromisedPaymentMapper_Factory INSTANCE = new DomainPromisedPaymentToPromisedPaymentMapper_Factory();
    }

    @Override // javax.inject.Provider
    public DomainPromisedPaymentToPromisedPaymentMapper get() {
        return newInstance();
    }

    public static DomainPromisedPaymentToPromisedPaymentMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DomainPromisedPaymentToPromisedPaymentMapper newInstance() {
        return new DomainPromisedPaymentToPromisedPaymentMapper();
    }
}
