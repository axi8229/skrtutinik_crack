package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.PromisePaymentUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory implements Factory<PromisePaymentUseCase> {
    private final PaymentsUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = paymentsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public PromisePaymentUseCase get() {
        return providePromisePaymentUseCase(this.module, this.repositoryProvider.get());
    }

    public static PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory create(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new PaymentsUseCaseModule_ProvidePromisePaymentUseCaseFactory(paymentsUseCaseModule, provider);
    }

    public static PromisePaymentUseCase providePromisePaymentUseCase(PaymentsUseCaseModule paymentsUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (PromisePaymentUseCase) Preconditions.checkNotNullFromProvides(paymentsUseCaseModule.providePromisePaymentUseCase(iServicePaymentsRepository));
    }
}
