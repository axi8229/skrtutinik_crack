package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.GetServicePaymentsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory implements Factory<GetServicePaymentsUseCase> {
    private final PaymentsUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = paymentsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetServicePaymentsUseCase get() {
        return provideGetServicePaymentsUseCase(this.module, this.repositoryProvider.get());
    }

    public static PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory create(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new PaymentsUseCaseModule_ProvideGetServicePaymentsUseCaseFactory(paymentsUseCaseModule, provider);
    }

    public static GetServicePaymentsUseCase provideGetServicePaymentsUseCase(PaymentsUseCaseModule paymentsUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (GetServicePaymentsUseCase) Preconditions.checkNotNullFromProvides(paymentsUseCaseModule.provideGetServicePaymentsUseCase(iServicePaymentsRepository));
    }
}
