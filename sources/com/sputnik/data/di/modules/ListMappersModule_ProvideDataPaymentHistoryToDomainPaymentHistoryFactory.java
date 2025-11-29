package com.sputnik.data.di.modules;

import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory implements Factory<ListMapper<DataPaymentHistory, DomainPaymentHistory>> {
    private final Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory(ListMappersModule listMappersModule, Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataPaymentHistory, DomainPaymentHistory> get() {
        return provideDataPaymentHistoryToDomainPaymentHistory(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory create(ListMappersModule listMappersModule, Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> provider) {
        return new ListMappersModule_ProvideDataPaymentHistoryToDomainPaymentHistoryFactory(listMappersModule, provider);
    }

    public static ListMapper<DataPaymentHistory, DomainPaymentHistory> provideDataPaymentHistoryToDomainPaymentHistory(ListMappersModule listMappersModule, DataPaymentHistoryToDomainPaymentHistoryMapper dataPaymentHistoryToDomainPaymentHistoryMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataPaymentHistoryToDomainPaymentHistory(dataPaymentHistoryToDomainPaymentHistoryMapper));
    }
}
