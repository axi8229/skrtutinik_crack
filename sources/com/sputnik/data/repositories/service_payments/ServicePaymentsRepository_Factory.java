package com.sputnik.data.repositories.service_payments;

import com.sputnik.data.api.ServicePaymentsApi;
import com.sputnik.data.entities.service_payments.DataPaymentHistory;
import com.sputnik.data.mappers.service_payments.DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentHistoryToDomainPaymentHistoryMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentItemToDomainPaymentItemMapper;
import com.sputnik.data.mappers.service_payments.DataPaymentReceiptToDomainPaymentReceiptMapper;
import com.sputnik.data.mappers.service_payments.DataPromisePaymentToDomainPromisePaymentMapper;
import com.sputnik.data.mappers.service_payments.DataServiceAccountInfoToDomainServiceAccountInfoMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.service_payments.DomainPaymentHistory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ServicePaymentsRepository_Factory implements Factory<ServicePaymentsRepository> {
    private final Provider<DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper> dataIntercomPaymentInfoToDomainIntercomPaymentInfoProvider;
    private final Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapperProvider;
    private final Provider<DataPaymentItemToDomainPaymentItemMapper> dataObjectPaymentItemToDomainPaymentItemObjectMapperProvider;
    private final Provider<ListMapper<DataPaymentHistory, DomainPaymentHistory>> dataPaymentHistoryToDomainPaymentHistoryMapperProvider;
    private final Provider<DataPaymentReceiptToDomainPaymentReceiptMapper> dataPaymentReceiptToDomainPaymentReceiptMapperProvider;
    private final Provider<DataPromisePaymentToDomainPromisePaymentMapper> dataPromisedPaymentToDomainPromisedPaymentProvider;
    private final Provider<DataServiceAccountInfoToDomainServiceAccountInfoMapper> dataServiceAccountInfoToDomainServiceAccountInfoProvider;
    private final Provider<ServicePaymentsApi> servicePaymentsApiProvider;

    public ServicePaymentsRepository_Factory(Provider<ServicePaymentsApi> provider, Provider<ListMapper<DataPaymentHistory, DomainPaymentHistory>> provider2, Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> provider3, Provider<DataPaymentItemToDomainPaymentItemMapper> provider4, Provider<DataPromisePaymentToDomainPromisePaymentMapper> provider5, Provider<DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper> provider6, Provider<DataServiceAccountInfoToDomainServiceAccountInfoMapper> provider7, Provider<DataPaymentReceiptToDomainPaymentReceiptMapper> provider8) {
        this.servicePaymentsApiProvider = provider;
        this.dataPaymentHistoryToDomainPaymentHistoryMapperProvider = provider2;
        this.dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapperProvider = provider3;
        this.dataObjectPaymentItemToDomainPaymentItemObjectMapperProvider = provider4;
        this.dataPromisedPaymentToDomainPromisedPaymentProvider = provider5;
        this.dataIntercomPaymentInfoToDomainIntercomPaymentInfoProvider = provider6;
        this.dataServiceAccountInfoToDomainServiceAccountInfoProvider = provider7;
        this.dataPaymentReceiptToDomainPaymentReceiptMapperProvider = provider8;
    }

    @Override // javax.inject.Provider
    public ServicePaymentsRepository get() {
        return newInstance(this.servicePaymentsApiProvider.get(), this.dataPaymentHistoryToDomainPaymentHistoryMapperProvider.get(), this.dataObjectPaymentHistoryToDomainPaymentHistoryObjectMapperProvider.get(), this.dataObjectPaymentItemToDomainPaymentItemObjectMapperProvider.get(), this.dataPromisedPaymentToDomainPromisedPaymentProvider.get(), this.dataIntercomPaymentInfoToDomainIntercomPaymentInfoProvider.get(), this.dataServiceAccountInfoToDomainServiceAccountInfoProvider.get(), this.dataPaymentReceiptToDomainPaymentReceiptMapperProvider.get());
    }

    public static ServicePaymentsRepository_Factory create(Provider<ServicePaymentsApi> provider, Provider<ListMapper<DataPaymentHistory, DomainPaymentHistory>> provider2, Provider<DataPaymentHistoryToDomainPaymentHistoryMapper> provider3, Provider<DataPaymentItemToDomainPaymentItemMapper> provider4, Provider<DataPromisePaymentToDomainPromisePaymentMapper> provider5, Provider<DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper> provider6, Provider<DataServiceAccountInfoToDomainServiceAccountInfoMapper> provider7, Provider<DataPaymentReceiptToDomainPaymentReceiptMapper> provider8) {
        return new ServicePaymentsRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ServicePaymentsRepository newInstance(ServicePaymentsApi servicePaymentsApi, ListMapper<DataPaymentHistory, DomainPaymentHistory> listMapper, DataPaymentHistoryToDomainPaymentHistoryMapper dataPaymentHistoryToDomainPaymentHistoryMapper, DataPaymentItemToDomainPaymentItemMapper dataPaymentItemToDomainPaymentItemMapper, DataPromisePaymentToDomainPromisePaymentMapper dataPromisePaymentToDomainPromisePaymentMapper, DataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper dataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper, DataServiceAccountInfoToDomainServiceAccountInfoMapper dataServiceAccountInfoToDomainServiceAccountInfoMapper, DataPaymentReceiptToDomainPaymentReceiptMapper dataPaymentReceiptToDomainPaymentReceiptMapper) {
        return new ServicePaymentsRepository(servicePaymentsApi, listMapper, dataPaymentHistoryToDomainPaymentHistoryMapper, dataPaymentItemToDomainPaymentItemMapper, dataPromisePaymentToDomainPromisePaymentMapper, dataIntercomPaymentInfoToDomainIntercomPaymentInfoMapper, dataServiceAccountInfoToDomainServiceAccountInfoMapper, dataPaymentReceiptToDomainPaymentReceiptMapper);
    }
}
