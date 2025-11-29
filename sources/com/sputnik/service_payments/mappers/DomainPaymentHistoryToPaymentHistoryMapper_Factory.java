package com.sputnik.service_payments.mappers;

import com.sputnik.common.localization.LocalizationStorage;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainPaymentHistoryToPaymentHistoryMapper_Factory implements Factory<DomainPaymentHistoryToPaymentHistoryMapper> {
    private final Provider<LocalizationStorage> localizationStorageProvider;

    public DomainPaymentHistoryToPaymentHistoryMapper_Factory(Provider<LocalizationStorage> provider) {
        this.localizationStorageProvider = provider;
    }

    @Override // javax.inject.Provider
    public DomainPaymentHistoryToPaymentHistoryMapper get() {
        return newInstance(this.localizationStorageProvider.get());
    }

    public static DomainPaymentHistoryToPaymentHistoryMapper_Factory create(Provider<LocalizationStorage> provider) {
        return new DomainPaymentHistoryToPaymentHistoryMapper_Factory(provider);
    }

    public static DomainPaymentHistoryToPaymentHistoryMapper newInstance(LocalizationStorage localizationStorage) {
        return new DomainPaymentHistoryToPaymentHistoryMapper(localizationStorage);
    }
}
