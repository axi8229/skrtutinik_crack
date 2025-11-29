package com.sputnik.service_payments.ui;

import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import com.sputnik.domain.usecases.service_payments.GetServiceAccountInfoUseCase;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import com.sputnik.service_payments.mappers.DomainPaymentHistoryToPaymentHistoryMapper;
import com.sputnik.service_payments.mappers.DomainPromisedPaymentToPromisedPaymentMapper;
import com.sputnik.service_payments.mappers.DomainServiceAccountInfoToServiceAccountInfoMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ServicePaymentsViewModel_Factory implements Factory<ServicePaymentsViewModel> {
    private final Provider<DomainServiceAccountInfoToServiceAccountInfoMapper> accountInfoMapperProvider;
    private final Provider<IConfig> configProvider;
    private final Provider<GetReceiptByAccrualUseCase> getReceiptByAccrualUseCaseProvider;
    private final Provider<GetServiceAccountInfoUseCase> getServiceAccountInfoUseCaseProvider;
    private final Provider<GetServicePaymentsUseCase> getServicePaymentsUseCaseProvider;
    private final Provider<DomainPaymentHistoryToPaymentHistoryMapper> mapperProvider;
    private final Provider<PrefManager> prefManagerProvider;
    private final Provider<DomainPromisedPaymentToPromisedPaymentMapper> promiseMapperProvider;
    private final Provider<PromisePaymentUseCase> promisePaymentUseCaseProvider;

    public ServicePaymentsViewModel_Factory(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetServicePaymentsUseCase> provider3, Provider<GetServiceAccountInfoUseCase> provider4, Provider<GetReceiptByAccrualUseCase> provider5, Provider<PromisePaymentUseCase> provider6, Provider<DomainPaymentHistoryToPaymentHistoryMapper> provider7, Provider<DomainPromisedPaymentToPromisedPaymentMapper> provider8, Provider<DomainServiceAccountInfoToServiceAccountInfoMapper> provider9) {
        this.prefManagerProvider = provider;
        this.configProvider = provider2;
        this.getServicePaymentsUseCaseProvider = provider3;
        this.getServiceAccountInfoUseCaseProvider = provider4;
        this.getReceiptByAccrualUseCaseProvider = provider5;
        this.promisePaymentUseCaseProvider = provider6;
        this.mapperProvider = provider7;
        this.promiseMapperProvider = provider8;
        this.accountInfoMapperProvider = provider9;
    }

    @Override // javax.inject.Provider
    public ServicePaymentsViewModel get() {
        return newInstance(this.prefManagerProvider.get(), this.configProvider.get(), this.getServicePaymentsUseCaseProvider.get(), this.getServiceAccountInfoUseCaseProvider.get(), this.getReceiptByAccrualUseCaseProvider.get(), this.promisePaymentUseCaseProvider.get(), this.mapperProvider.get(), this.promiseMapperProvider.get(), this.accountInfoMapperProvider.get());
    }

    public static ServicePaymentsViewModel_Factory create(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetServicePaymentsUseCase> provider3, Provider<GetServiceAccountInfoUseCase> provider4, Provider<GetReceiptByAccrualUseCase> provider5, Provider<PromisePaymentUseCase> provider6, Provider<DomainPaymentHistoryToPaymentHistoryMapper> provider7, Provider<DomainPromisedPaymentToPromisedPaymentMapper> provider8, Provider<DomainServiceAccountInfoToServiceAccountInfoMapper> provider9) {
        return new ServicePaymentsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ServicePaymentsViewModel newInstance(PrefManager prefManager, IConfig iConfig, GetServicePaymentsUseCase getServicePaymentsUseCase, GetServiceAccountInfoUseCase getServiceAccountInfoUseCase, GetReceiptByAccrualUseCase getReceiptByAccrualUseCase, PromisePaymentUseCase promisePaymentUseCase, DomainPaymentHistoryToPaymentHistoryMapper domainPaymentHistoryToPaymentHistoryMapper, DomainPromisedPaymentToPromisedPaymentMapper domainPromisedPaymentToPromisedPaymentMapper, DomainServiceAccountInfoToServiceAccountInfoMapper domainServiceAccountInfoToServiceAccountInfoMapper) {
        return new ServicePaymentsViewModel(prefManager, iConfig, getServicePaymentsUseCase, getServiceAccountInfoUseCase, getReceiptByAccrualUseCase, promisePaymentUseCase, domainPaymentHistoryToPaymentHistoryMapper, domainPromisedPaymentToPromisedPaymentMapper, domainServiceAccountInfoToServiceAccountInfoMapper);
    }
}
